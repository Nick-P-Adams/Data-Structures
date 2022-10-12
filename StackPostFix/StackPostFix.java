import java.io.File;

public class StackPostFix 
{

	public static void main(String[] args) 
	{
		LinkedList ll = new LinkedList();
		File file = new File(args[0]);
		double res = 0.0;
		res = ll.postFixCalculate(file);
		System.out.println(res);
	}

}
