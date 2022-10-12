public class DHDLL {

	protected Node index;
	protected Node head;
	protected Node tail;
	protected Node right;
	protected int size;



	public DHDLL() {
		head= new Node();
		tail=new Node();		
		this.head.next=tail;
		this.tail.prev=head;
		this.size=0;
	}

	public void add(int element) {
		Node insert=new Node(element);

		if(insert==null)
			return;

		if(this.size==0) {
			this.head.next=insert;
			this.tail.prev=insert;
			insert.next=tail;
			insert.prev=head;
			tail.next=null;
			head.prev=null;
			this.size++;

		}
		else {
			insert.prev=(tail.prev);
			insert.next=(tail);
			tail.prev.setnext(insert);
			tail.prev=insert;
			this.size++;
		}


	}
	//Prints and Begins the Qsort the array
	public void quickSort() {
		if(this.size==0) {
			System.out.println("There is nothing to sort");
			return;	
		}		
		Node cur=this.head.next;
		while(cur!=null&&cur!=tail){ 
			System.out.print(cur.element+" "); 
			cur = cur.next; 
		} 
		System.out.println();
		//Starting the Sort

		quickSortHelper(head.next,tail.prev);
		cur=this.head.next;
		while(cur!=null&&cur!=tail){ 
			System.out.print(cur.element+" "); 
			cur = cur.next; 
		} 

	}
	//the Helper method to Quick
	private void quickSortHelper(Node left, Node right) {

		if(left!=right&&left!=right.next&&left!=tail) {

			Node[] index=Partition(left,right);	

			quickSortHelper(index[0],index[1].prev); 
			quickSortHelper(index[1].next,index[2]);

		}
	}

	private Node[] Partition(Node left, Node right) {
		Node index = left; 
		Node pivot=right;
		Node[] array=new Node[3];

		Node i,x;
		for(x=left,i=left; i!=right; i=i.next) 
		{ 
			if(i.element <= pivot.element) 
			{ 
				if(x==left) {
					left=left.prev;
					swap(x,i);
					left=left.next;
					Node temp=i;

					i=x;
					x=temp;
					x=x.next;
				}
				else {
					swap(x,i);
					Node temp=i;
					i=x;
					x=temp;
					x=x.next;
				}
			}        
		}

		if(x==left) {
			left=left.prev;
			right=right.next;
			swap(x,i);
			right=right.prev;
			left=left.next;
			Node temp=i;

			i=x;
			x=temp;
			x=x.next;
		}
		else {
			right=right.next;
			swap(x,i);
			right=right.prev;
			Node temp=i;
			i=x;
			x=temp;
			x=x.next;
		}


		array[0]=left;
		array[1]=pivot;
		array[2]=right;

		return array; 

	}

	private void swap(Node x, Node pivot) {

		if(x==pivot) {
			return;
		}

		if(x.next==pivot) {
			x.prev.setnext(pivot);
			pivot.next.setprev(x);
			x.setnext(pivot.next);
			pivot.setprev(x.prev);
			x.setprev(pivot);
			pivot.setnext(x);
		}
		else { 
			Node temp = new Node(x.next,pivot.prev);
			x.prev.setnext(pivot);
			pivot.next.setprev(x);
			x.next.setprev(pivot);
			pivot.prev.setnext(x);
			x.setnext(pivot.next);
			pivot.setprev(x.prev);
			x.setprev(temp.prev);
			pivot.setnext(temp.next);
			temp.prev=null;
			temp.next=null;
		}		
	}
}