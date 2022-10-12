import java.io.File;
import java.io.FileNotFoundException;

public class FIFOQueue 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		ArrayQueue[] arrayQ = new ArrayQueue[args.length];
		ListQueue listQ = new ListQueue();
		
		constructArrayQs(arrayQ, args);
		fillArrayQs(arrayQ);
		
		for(int i=0; i < arrayQ.length; i++)
		{
			while(arrayQ[i].size() > 0)
			{
				dequeueIntoList(arrayQ, listQ);
			}
		}
		
		int size = listQ.size();
		for(int j=0; j < size; j++)
		{
			System.out.println(listQ.dequeue());
		}
	}
	
	public static void dequeueIntoList(ArrayQueue[] arrayQ, ListQueue listQ)
	{
		ArrayQueue min = arrayQ[0];
		for(int i=1; i < arrayQ.length; i++)
		{
			if(arrayQ[i].front().compareTo(min.front()) < 0)
			{
				min = arrayQ[i];
			}
		}
		
		listQ.enqueue(min.dequeue());
		fillArrayQs(arrayQ);
	}
	
	public static void constructArrayQs(ArrayQueue[] arrayQ, String[] args) throws FileNotFoundException
	{
		for(int i=0; i < args.length; i++)
		{
			File file = new File(args[i]);
			arrayQ[i] = new ArrayQueue(file);
		}
	}
	
	public static void fillArrayQ(ArrayQueue arrayQ)
	{
		if(arrayQ.scanner().hasNext() && arrayQ.size() < 10)
		{
			arrayQ.enqueue(arrayQ.scanner().next());
			//System.out.println(arrayQ[i].front());
		}
	}
	
	public static void fillArrayQs(ArrayQueue[] arrayQ)
	{
		for(int i = 0; i < arrayQ.length; i++)
		{
			while(arrayQ[i].scanner().hasNext() && arrayQ[i].size() < 10)
			{
				arrayQ[i].enqueue(arrayQ[i].scanner().next());
				//System.out.println(arrayQ[i].front());
			}
		}
	}
}



