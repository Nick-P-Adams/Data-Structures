
public class HashChain implements Map 
{
	private int size;
	private SinglyLinkedList[] bucket = new SinglyLinkedList[5];
	
	public HashChain()
	{
		this.size = 0;
		for(int i = 0; i < this.bucket.length; i++)
		{
			this.bucket[i] = new SinglyLinkedList();
		}
	}

	@Override
	public void insert(String id, String value) 
	{
		int index = this.hash(id);
		
		if(this.size == 0)
		{
			this.bucket[index].addLast(id, value);
			System.out.println("The new student has been added successfully.");
			this.size++;
		}
		else
		{
			if(this.bucket[index].update(id, value) == true)
			{
				System.out.println("The student was existing and the record has been updated.");
			}
			else
			{
				this.bucket[index].addLast(id, value);
				System.out.println("The new student has been added successfully.");
				this.size++;
			}
		}
	}

	@Override
	public void delete(String id) 
	{
		int index = this.hash(id);
		if(this.bucket[index].delete(id) == true)
		{
			System.out.println("The student has been deleted successfully.");
			this.size--;
		}
		else
		{
			System.out.println("No such a student.");
		}
	}

	@Override
	public void search(String id) 
	{
		int index = this.hash(id);
		System.out.println(this.bucket[index].search(id));
	}

	@Override
	public void print() 
	{
		for(int i = 0; i < this.bucket.length; i++)
		{
			this.bucket[i].print();
		}
	}

	private int hash(String id)
	{
		int index = Integer.parseInt(id) % this.getTableCapcity();
		return index;
	}
	
	@Override
	public int getSize() {return this.size;}
	public int getTableCapcity(){return this.bucket.length;}
}
