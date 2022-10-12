
public class Node 
{
	private int id, pTime;
	private Node prev, next;
	
	public Node(int id, int pTime, Node prev, Node next)
	{
		this.id = id;
		this.pTime = pTime;
		this.prev = prev;
		this.next = next;
	}
	
	public void setID(int id){this.id = id;}
	public void setPTime(int pTime){this.pTime = pTime;}
	public void setPrev(Node prev){this.prev = prev;}
	public void setNext(Node next){this.next = next;}
	public int getID(){return this.id;}
	public int getPTime(){return this.pTime;}
	public Node getPrev(){return this.prev;}
	public Node getNext(){return this.next;}
}
