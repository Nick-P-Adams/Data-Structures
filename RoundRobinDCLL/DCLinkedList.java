
public class DCLinkedList 
{
	Node start, end;
	long size;
	
	public DCLinkedList()
	{
		this.start = null;
		this.end = null;
		this.size = 0;
	}
	
	public void addLast(int id, int pTime)
	{
		Node nn = new Node(id, pTime, null, null);
		
		if(start == null)
		{
			nn.setNext(nn);
			nn.setPrev(nn);
			start = nn;
			end = start;
		}
		else
		{
			nn.setPrev(end);
			end.setNext(nn);
			start.setPrev(nn);
			nn.setNext(start);
			end = nn;
		}
		
		this.size++;
	}
	
	public void delete(Node cur)
	{
		if(this.size == 1)
		{
			cur = null;
		}
		else
		{
			cur.getPrev().setNext(cur.getNext());
			cur.getNext().setPrev(cur.getPrev());
		}
		this.size--;
	}
	
	public void insert(int id, int pTime)
	{
		Node nn = new Node(id, pTime, null, null);
		Node temp, cur;
		boolean insert = false;
		
		if(start == null)
		{
			nn.setNext(nn);
			nn.setPrev(nn);
			start = nn;
			end = start;
		}
		else if(nn.getID() <= start.getID())
		{
			nn.setPrev(end);
			end.setNext(nn);
			start.setPrev(nn);
			nn.setNext(start);
			end = start;
		}
		else if(nn.getID() >= end.getID())
		{
			end.setNext(nn);
			nn.setPrev(end);
			nn.setNext(start);
			start.setPrev(nn);
			end = nn;
		}
		else
		{
			temp = start;
			cur = start.getNext();
			while(cur != null)
			{
				if(nn.getID() >= temp.getID() && nn.getID() <= cur.getID())
				{
					temp.setNext(nn);
					nn.setPrev(temp);
					nn.setNext(cur);
					cur.setPrev(nn);
					insert = true;
					break;
				}
				else
				{
					temp = cur;
					cur = cur.getNext();
				}
			}
			if(!insert)
			{
				temp.setNext(nn);
				nn.setPrev(temp);
			}
		}
		this.size++;
	}
	
	public String roundRobin(int serveTime)
	{
		String res = "";
		Node cur = start;
		
		while(this.size > 0)
		{
			cur.setPTime((cur.getPTime() - serveTime));
		
			if(cur.getPTime() <= 0)
			{
				res += cur.getID() + ", "; 
				this.delete(cur);
			}
			
			cur = cur.getNext();
		}
		
		return res;
	}
}
