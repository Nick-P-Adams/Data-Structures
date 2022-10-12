
public class BSTNode 
{
	private int key;
	private BSTNode right, left, parent;
	
	public BSTNode(int key)
	{
		this.key = key;
		this.right = null;
		this.left = null;
		this.parent = null;
	}
	
	public int getKey() {return this.key;}
	public void setKey(int key) {this.key = key;}
	public BSTNode getRight() {return this.right;}
	public void setRight(BSTNode right) {this.right = right;}
	public BSTNode getLeft() {return this.left;}
	public void setLeft(BSTNode left) {this.left = left;}
	public BSTNode getParent() {return this.parent;}
	public void setParent(BSTNode parent) {this.parent = parent;}
}
