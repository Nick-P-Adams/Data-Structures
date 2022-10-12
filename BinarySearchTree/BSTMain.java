import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BSTMain {

	public static void main(String[] args) throws FileNotFoundException 
	{
		File file = new File(args[0]);
		Scanner inf = new Scanner(file);
		int choice, key;
		BST tree = new BST();
		
		while(inf.hasNext())
		{
			tree.insert(inf.nextInt());
		}
		
		do
		{
			System.out.print("Choose one of the following options.\r\n" + 
					"====================================\r\n" + 
					"1) Search for a key\r\n" + 
					"2) Insert a new key\r\n" + 
					"3) Delete an existing key\r\n" + 
					"4) Inorder traversal of the BST\r\n" + 
					"5) Preorder traversal of the BST\r\n" + 
					"6) Postorder traversal of the BST\r\n" + 
					"7) Level-order traversal of the BST\r\n" + 
					"8) Find the smallest key\r\n" + 
					"9) Find the largest key\r\n" + 
					"10) Find the successor of a given key\r\n" + 
					"11) Find the predecessor of a given key\r\n" + 
					"12) quit\r\n" + 
					"Your choice: ");
			
			Scanner kb = new Scanner(System.in);
			choice = kb.nextInt();
			
			if(choice == 1)
			{
				System.out.println("Please enter a key: ");
				key = kb.nextInt();
				if(tree.search(key) != null)
				{
					System.out.println("key was found\r\n");
				}
				else
				{
					System.out.println("key was not found\r\n");
				}
			}
			else if(choice == 2)
			{
				System.out.println("Please enter a key\r\n");
				key = kb.nextInt();
				tree.insert(key);
			}
			else if(choice == 3)
			{
				System.out.println("Please enter a key\r\n");
				key = kb.nextInt();
				tree.delete(key);
			}
			else if(choice == 4)
			{
				tree.inOrderTraversal(tree.getGlobalRoot());
			}
			else if(choice == 5)
			{
				tree.preOrderTraversal(tree.getGlobalRoot());
			}
			else if(choice == 6)
			{
				tree.postOrderTraversal(tree.getGlobalRoot());
			}
			else if(choice == 7)
			{
				tree.levelOrderTraversal(tree.getGlobalRoot());
			}
			else if(choice == 8)
			{
				System.out.println(tree.min(tree.getGlobalRoot()).getKey());
			}
			else if(choice == 9)
			{
				System.out.println(tree.max(tree.getGlobalRoot()).getKey());
			}
			else if(choice == 10)
			{
				System.out.println("Please enter a key\r\n");
				key = kb.nextInt();
				if(tree.successor(tree.search(key)) != null)
				{
					System.out.println(tree.successor(tree.search(key)).getKey());
				}
				else
				{
					System.out.println("There is no successor to this key");
				}
			}
			else if(choice == 11)
			{
				System.out.println("Please enter a key\r\n");
				key = kb.nextInt();
				
				if(tree.predecessor(tree.search(key)) != null)
				{	
					System.out.println(tree.predecessor(tree.search(key)).getKey());
				}
				else
				{
					System.out.println("There is no predecessor to this key");
				}
			}
			else if(choice == 12)
			{
				break;
			}
		}while(choice > 1 || choice < 12);
	}

}
