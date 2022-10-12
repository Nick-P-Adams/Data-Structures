import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArrayQueue implements Queue 
{
	private String[] array;
	private Scanner inf;
	private int capacity, head, tail, size;
	
	public ArrayQueue(File file) throws FileNotFoundException
	{
		this.capacity = 10;
		this.size = 0;
		this.head = -1;
		this.tail = -1;
		this.array = new String[capacity];
		this.inf = new Scanner(file);
	}
	
	@Override
	public void enqueue(String item) 
	{
		if(this.size() == this.capacity)
		{
			throw new IllegalArgumentException("The array queue is already full");
		}
		else if(this.size() == 0)
		{
			this.array[0] = item;
			head = 0;
			tail = 0;
		}
		else
		{
			tail = (tail + 1) % this.capacity;
			this.array[tail] = item;
		}
		this.size++;
	}

	@Override
	public String dequeue() 
	{
		if(this.size() == 0)
		{
			throw new IllegalArgumentException("The array queue is already empty");
		}
		
		String res = this.array[head];
		
		if(this.size() == 1)
		{
			head = -1;
			tail = -1;
		}
		else
		{
			head = (head + 1) % this.capacity;
		}
		this.size--;
		return res;
	}
	
	@Override
	public String front() 
	{
		if(this.size() == 0)
		{
			return "The array queue is empty";
		}
		return array[head];
	}
	public String back() 
	{
		if(this.size() == 0)
		{
			return "The array queue is empty";
		}
		return array[tail];
	}
	@Override
	public int size(){return this.size;}
	public Scanner scanner(){return this.inf;}
}
