import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RoundRobin 
{

	public static void main(String[] args) 
	{
		DCLinkedList ll = new DCLinkedList();
		String fileName = args[0], res;
		int serveTime = Integer.parseInt(args[1]);
		
		setupList(fileName, ll);
		res = ll.roundRobin(serveTime);
		System.out.println(res);
			
	}
	
	public static void setupList(String fileName, DCLinkedList ll)
	{
		String line;
		int id, pTime, index;
		File file = new File(fileName);
		
		try 
		{
			Scanner fb = new Scanner(file);
			
			if(!fb.hasNext())
			{
				throw new IllegalArgumentException("File is empty");
			}
			
			while(fb.hasNext())
			{
				line = fb.nextLine();
				index = line.indexOf(",");
				id = Integer.parseInt(line.substring(0, index).trim());
				pTime = Integer.parseInt(line.substring(index + 1).trim());
				
				ll.insert(id, pTime);	
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}
