public class ListQueue implements Queue 
{
	private Node head, tail;
	private int size;
	
	public ListQueue()
	{
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	@Override
	public void enqueue(String item) 
	{
		Node nn = new Node(item, null);
		
		if(this.size == 0)
		{
			this.head = nn;
			this.tail = nn;
		}
		else
		{
			this.tail.setNext(nn);
			this.tail = nn;
		}
		this.size++;
	}

	@Override
	public String dequeue() 
	{
		if(this.size == 0)
		{
			throw new IllegalArgumentException("The list queue is already empty");
		}
		
		String res = this.head.getData();
		
		if(this.size == 1)
		{
			this.head = null;
			this.tail = null;
		}
		else 
		{
			head = head.getNext();
		}
		this.size--;
		return res;
	}
	
	@Override
	public String front()
	{
		if(this.size == 0)
		{
			return "The list queue is empty";
		}
		return this.head.getData();
	}
	@Override
	public int size(){return this.size;}
}
