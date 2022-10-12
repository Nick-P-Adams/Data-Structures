public class ListQueue 
{
	private BSTNode head, tail;
	private int size;
	
	public ListQueue()
	{
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public void enqueue(BSTNode node) 
	{
		BSTNode nn = node;
		
		if(this.size == 0)
		{
			this.head = nn;
			this.tail = nn;
		}
		else
		{
			this.tail.setRight(nn);
			this.tail = nn;
		}
		this.size++;
	}

	public BSTNode dequeue() 
	{
		if(this.size == 0)
		{
			throw new IllegalArgumentException("The list queue is already empty");
		}
		
		BSTNode res = this.head;
		
		if(this.size == 1)
		{
			this.head = null;
			this.tail = null;
		}
		else 
		{
			head = head.getRight();
		}
		this.size--;
		return res;
	}
	
	public BSTNode front()
	{
		if(this.size == 0)
		{
			return null;
		}
		return this.head;
	}

	public int size(){return this.size;}
}
