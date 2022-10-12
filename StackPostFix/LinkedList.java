import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinkedList implements Stack
{
	private Node top;
	private long size;
	
	public LinkedList()
	{
		this.top = null;
		this.size = 0;
	}

	@Override
	public void push(Node n) 
	{
		if(n == null)
		{
			throw new IllegalArgumentException("Node passed into push is null");
		}
		else if(this.top == null)
		{
			this.top = n;
		}
		else
		{
			n.setNext(this.top);
			this.top = n;
		}
		this.size++;
	}

	@Override
	public Node pop() 
	{
		Node popped = this.top;
		if(this.top != null)
		{
			this.top = this.top.getNext();
			popped.setNext(null);
			this.size--;
		}
		return popped;
	}
	
	public double postFixCalculate(File file)
	{
		try 
		{
			Scanner inf = new Scanner(file);
			double res = 0.0;
			String operator = "";
			Node n1, n2;
			
			while(inf.hasNext())
			{
				if(inf.hasNextDouble())
				{
					n1 = new Node(inf.nextDouble(), null);
					this.push(n1);
				}
				else
				{
					operator = inf.next().trim();
				
					n1 = this.pop();
					n2 = this.pop();
					
					if(operator.compareTo("+") == 0)
					{
						res = n1.getData() + n2.getData();
						push(new Node(res, null));
					}
					else if(operator.compareTo("-") == 0)
					{
						res = n2.getData() - n1.getData();
						push(new Node(res, null));
					}
					else if(operator.compareTo("*") == 0)
					{
						res = n1.getData() * n2.getData();
						push(new Node(res, null));
					}
					else if(operator.compareTo("/") == 0)
					{
						res = n1.getData() / n2.getData();
						push(new Node(res, null));
					}
					else
					{
						throw new IllegalArgumentException("Not an acceptable operator");
					}		
				}
			}
			return res;
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("file not found");
			e.printStackTrace();
			return 0.0;
		}
	}
	
	public long getSize(){return this.size;}
	public Node getTop(){return this.top;}
}
