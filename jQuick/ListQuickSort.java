import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListQuickSort {
	
	 public static void main(String [] args) throws FileNotFoundException {

	if(args[0]==null)throw new IllegalArgumentException("No File");
	   File inf = new File(args[0]);
	   Scanner fin = new Scanner(inf);
	
	   DHDLL process = new DHDLL();
	   while(fin.hasNext()) {
		   process.add((int)fin.nextInt());
	   }
	
	   process.quickSort();
	 }


		
	}


