
public class SinglyLinkedList 
{
	private int size;
	private Node head;
	
	SinglyLinkedList()
	{
		this.size = 0;
		this.head = null;
	}
	
	public void addLast(String id, String value)
	{
		Node nn = new Node(id, value, null);
		if(this.size == 0)
		{
			this.head = nn;
		}
		else
		{
			Node cur = this.head;
			if (this.size == 1)
			{
				this.head.setNext(nn);
			}
			while(cur.getNext() != null)
			{
				cur = cur.getNext();
			}
			cur.setNext(nn);
		}
		this.size++;
	}
	
	public boolean delete(String id)
	{
		Node cur = this.head, deleted;
		if(this.size != 0)
		{
			if(this.size == 1)
			{
				if(this.head.getID().compareTo(id) == 0)
				{
					this.head = null;
					this.size--;
					return true;
				}
				return false;
			}
			else
			{
				if(this.head.getID().compareTo(id) == 0)
				{
					this.head = this.head.getNext();
					cur.setNext(null);
					this.size--;
					return true;
				}
				else
				{
					while(cur.getNext().getID().compareTo(id) != 0)
					{
						cur = cur.getNext();
					}
					deleted = cur.getNext();
					cur.setNext(cur.getNext().getNext());
					deleted.setNext(null);
					this.size--;
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean update(String id, String value)
	{
		Node cur = this.head;
		
		if(this.head == null)
		{
			return false;
		}
		if(this.size == 1)
		{
			if(this.head.getID().compareTo(id) == 0)
			{
				this.head.setValue(value);
				return true;
			}
			return false;
		}
		while(cur.getNext() != null)
		{
			if(cur.getID().compareTo(id) == 0)
			{
				cur.setValue(value);
				return true;
			}
			cur = cur.getNext();
		}
		return false;
	}
	
	public String search(String id)
	{
		Node cur = this.head;
		String res;
		
		if(this.head == null)
		{
			return "No such a student.";
		}
		if(this.size == 1)
		{
			if(this.head.getID().compareTo(id) == 0)
			{
				res = "Student ID:" + this.head.getID() + " Student Name:" + this.head.getValue();
				return res;
			}
			return "No such a student.";
		}
		else
		{
			while(cur.getID().compareTo(id) != 0 && cur.getNext() != null)
			{
				cur = cur.getNext();
			}
			if(cur.getID().compareTo(id) == 0)
			{
				res = "Student ID:" + this.head.getID() + " Student Name:" + this.head.getValue();
				return res;
			}
		}
		return "No such a student.";
	}
	
	public void print()
	{
		if(this.size != 0)
		{
			Node cur = this.head;
			String res = "";
			if(this.size == 1)
			{
				res += "Student ID:" + cur.getID() + " Student Name:" + cur.getValue() + " ";
			}
			else
			{
				while(cur.getNext() != null)
				{
					res += "Student ID:" + cur.getID() + " Student Name:" + cur.getValue() + " ";
					cur = cur.getNext();
				}
			}
			System.out.println(res);
		}
	}
	
	public int getSize(){return this.size;}
}
