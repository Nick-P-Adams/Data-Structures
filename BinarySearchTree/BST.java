
public class BST 
{
	private BSTNode root;
	
	public BST()
	{
		this.root = null;
	}
	
	public BSTNode search(int key)
	{
		BSTNode target, cur = this.root;
		
		if(cur == null)
		{
			return null;
		}
		
		while(cur != null)
		{
			if(key == cur.getKey())
			{
				return cur;
			}
			else if(key < cur.getKey())
			{
				cur = cur.getLeft();
			}
			else
			{
				cur = cur.getRight();
			}
		}
		return null;
	}
	
	public BSTNode insert(int key)
	{
		BSTNode inserted = new BSTNode(key), insRoot = null, cur = this.root;
		
		while(cur != null)
		{
			insRoot = cur;
			
			if(key == cur.getKey())
			{
				return null;
			}
			else if(key < cur.getKey())
			{
				cur = cur.getLeft();
			}
			else 
			{
				cur = cur.getRight();
			}
		}

		inserted.setParent(insRoot);
		
		if(insRoot == null)
		{
			this.root = inserted;
		}
		else if(key < insRoot.getKey())
		{
			insRoot.setLeft(inserted);
		}
		else
		{
			insRoot.setRight(inserted);
		}
		
		return inserted;
	}

	public BSTNode delete(int key)
	{
		BSTNode deleted = this.search(key);
	
		if(deleted == null)
		{
			return null;
		}
		else if(deleted.getRight() == null && deleted.getLeft() == null)
		{
			if(deleted.getParent().getLeft() == deleted)
			{
				deleted.getParent().setLeft(null);
			}
			else if(deleted.getParent().getRight() == deleted)
			{
				deleted.getParent().setRight(null);
			}
			deleted.setParent(null);
		}
		else if(deleted.getRight() == null)
		{
			if(deleted.getParent().getLeft() == deleted)
			{
				deleted.getParent().setLeft(deleted.getLeft());
			}
			else if(deleted.getParent().getRight() == deleted)
			{
				deleted.getParent().setRight(deleted.getLeft());
			}
			
			deleted.getLeft().setParent(deleted.getParent());
			deleted.setLeft(null);
			deleted.setParent(null);
		}
		else if(deleted.getLeft() == null)
		{
			if(deleted.getParent().getLeft() == deleted)
			{
				deleted.getParent().setLeft(deleted.getRight());
			}
			else if(deleted.getParent().getRight() == deleted)
			{
				deleted.getParent().setRight(deleted.getRight());
			}
			deleted.getRight().setParent(deleted.getParent());
			deleted.setRight(null);
			deleted.setParent(null);
		}
		else if(deleted.getLeft() != null && deleted.getRight() != null)
		{
			BSTNode successor = this.successor(deleted);
			int temp = successor.getKey();
			
			this.delete(successor.getKey());
			deleted.setKey(temp);
		}

		return deleted;
	}
	
	public void inOrderTraversal(BSTNode subtreeRoot)
	{
		if(subtreeRoot != null)
		{
			this.inOrderTraversal(subtreeRoot.getLeft());
			System.out.println(subtreeRoot.getKey());
			this.inOrderTraversal(subtreeRoot.getRight());
		}
	}
	
	public void preOrderTraversal(BSTNode subtreeRoot)
	{
		if(subtreeRoot != null)
		{
			System.out.println(subtreeRoot.getKey());
			this.preOrderTraversal(subtreeRoot.getLeft());
			this.preOrderTraversal(subtreeRoot.getRight());
		}
	}
	
	public void postOrderTraversal(BSTNode subtreeRoot)
	{
		if(subtreeRoot != null)
		{
			this.postOrderTraversal(subtreeRoot.getLeft());
			this.postOrderTraversal(subtreeRoot.getRight());
			System.out.println(subtreeRoot.getKey());
		}
	}
	
	public void levelOrderTraversal(BSTNode subtreeRoot)
	{
		ListQueue fifo = new ListQueue();
		BSTNode node;
		fifo.enqueue(subtreeRoot);
		
		while(fifo.size() > 0)
		{
			node = fifo.dequeue();
			System.out.println(node.getKey());
			
			if(node.getLeft() != null)
			{
				fifo.enqueue(node.getLeft());
			}
			if(node.getRight() != null)
			{
				fifo.enqueue(node.getRight());
			}
		}
	}
	
	public BSTNode min(BSTNode subtreeRoot)
	{
		BSTNode temp = subtreeRoot;
		
		while(temp.getLeft() != null)
		{
			temp = temp.getLeft();
		}
		return temp;
	}
	
	public BSTNode max(BSTNode subtreeRoot)
	{
		BSTNode temp = subtreeRoot;
		
		while(temp.getRight() != null)
		{
			temp = temp.getRight();
		}
		return temp;
	}
	
	public BSTNode successor(BSTNode node)
	{
		if(node.getRight() != null)
		{
			return this.min(node.getRight());
		}
		
		BSTNode localRoot = node.getParent();
			
		while(localRoot != null && node == localRoot.getRight())
		{
			node = localRoot;
			localRoot = localRoot.getParent();
		}
		
		return localRoot;
	}

	public BSTNode predecessor(BSTNode node)
	{
		if(node.getRight() != null)
		{
			return this.max(node.getLeft());
		}
		
		BSTNode localRoot = node.getParent();
			
		while(localRoot != null && node == localRoot.getLeft())
		{
			node = localRoot;
			localRoot = localRoot.getParent();
		}
		
		return localRoot;
	}
	
	public BSTNode getGlobalRoot() {return this.root;}
}
