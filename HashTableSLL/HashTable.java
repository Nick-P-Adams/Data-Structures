import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashTable {

	public static void main(String[] args) throws FileNotFoundException 
	{
		HashChain table = new HashChain();
		String id, value, line;
		File file = new File(args[0]);
		Scanner inf = new Scanner(file);
		int choice = 0;
		
		while(inf.hasNext())
		{
			int index;
			line = inf.next();
			index = line.indexOf(",");
			
			id = line.substring(0, index);
			value = line.substring(index+1);
			
			table.insert(id, value);
		}
		
		do
		{
			Scanner kb = new Scanner(System.in);
			System.out.println("Choose one of the following options.");
			System.out.println("====================================");
			System.out.println("1) insert/update a new student record");
			System.out.println("2) delete a student record");
			System.out.println("3) search for a student record");
			System.out.println("4) print all the student records");
			System.out.println("5) quit");
			choice = kb.nextInt(); 
			
			if(choice == 1)
			{
				System.out.println("Enter Student ID: ");
				id = kb.next().trim();
				System.out.println("Enter Student Name: ");
				value = kb.next().trim();
				table.insert(id, value);
			}
			else if(choice == 2)
			{
				System.out.println("Enter Student ID: ");
				id = kb.next().trim();
				table.delete(id);
			}
			else if(choice == 3)
			{
				System.out.println("Enter Student ID: ");
				id = kb.next().trim();
				table.search(id);
			}
			else if(choice == 4)
			{
				table.print();
			}
			else if(choice == 5)
			{
				break;
			}
			
			if(choice < 1 || choice > 5)
			{
				System.out.println("You entered a number out of menu option range please pick a menu option");
			}
		}while(choice < 1 || choice > 5 || choice != 5);

	}
}
