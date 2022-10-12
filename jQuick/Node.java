public class Node{
	protected Node prev;
	protected Node next;
	protected int element;

	
	public Node() {
		this.prev=null;
		this.next=null;
		this.element=0;

	}
	public Node(int element) {
		this.element=element;
		this.prev=null;
		this.next = null;
	}
	public Node(Node next, Node prev){
		this.next=next;
		this.prev=prev;
		
		
	}
	
	public int getElement() {return this.element;}
	public Node getnext() {return this.next;}
	public Node getprev() {return this.prev;}
	public void setElement(int element) {this.element=element;}
	public void setnext(Node next) {this.next=next;}
	public void setprev(Node prev) {this.prev=prev;}
	
	
	
}

