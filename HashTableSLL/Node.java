public class Node 
{
	private String id, value;
	private Node next;
	
	public Node(String id, String value, Node next)
	{
		this.id = id;
		this.value = value;
		this.next = next;
	}
	
	public void setID(String id){this.id = id;}
	public void setValue(String value){this.value = value;}
	public void setNext(Node next){this.next = next;}
	public String getID(){return this.id;}
	public String getValue(){return this.value;}
	public Node getNext(){return this.next;}
}
