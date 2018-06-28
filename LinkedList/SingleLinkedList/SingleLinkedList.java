package SingleLinkedList;

import java.util.Scanner;

public class SingleLinkedList {
		private Node start;
		
		public SingleLinkedList() {
			start = null;
		}
		
		public void displayList() {
			Node p;
			if(start==null)
			{
				System.out.println("The list is empty");
				return;
			
			}
			
			System.out.println("List is : ");
			p=start;
			while(p!=null)
			{
				System.out.println(p.info + " ");
				p=p.link;
			}
			
			System.out.println();
			
		}
		
		public void countNodes() {
			int n = 0;
			Node p = start;
			while(p!=null)
			{
				n++;
				p=p.link;
			}
			System.out.println("The number of nodes in the list are : "+n);
		}
		
		public boolean search(int x)
		{
			Node p;
			int position = 1;
			p = start;
			while(p!=null)
			{
				if(p.info==x)
					break;
				position++;
				p=p.link;
			}
			if(p==null)
			{
				System.out.println(x + " Not found in the list");
				return false;
			}
			else
			{
				System.out.println(x+ " is at position "+ position);
				return true;
			}
				
		}
		
		public void insertInBeginning(int data) 
		{
			Node temp = new Node(data);
			temp.link = start;
			start = temp;
		}
		
		public void insertAtEnd(int data)
		{
			Node p;
			Node temp = new Node(data);
			
			if(start == null)
			{
				start = temp;
				return;
			}
			
			p=start;
			while(p.link!=null)
		        p=p.link;
			
			p.link = temp;
			
		}
		
		public void createList() 
		{
			int i,n,data;
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Enter the number of nodes : ");
			n =  scan.nextInt();
			
			if(n==0)
			   return;
			
			for(i=1;i<=n;i++)
			{
				System.out.println("Enter the element to be inserted : ");
				data = scan.nextInt();
				insertAtEnd(data);
			}
		}
		
		public void insertAfter(int data, int x)
		{
			Node p = start;
			while(p!=null)
			{
				if(p.info==x)
					break;
				p=p.link;
				
			}
			
			if(p==null)
			    System.out.println(x+" not present in the list");
			else
			{
				Node temp = new Node(data);
				temp.link = p.link;
				p.link = temp;
				
			}
			
		}
		
		public void insertBefore(int data,int x)
		{
			Node temp;
			
			if(start==null)
			{
				System.out.println("List is empty");
				return;
			}
			
			if(x==start.info)
			{
				temp = new Node(data);
				temp.link=start;
				start=temp;
				return;
			}
			
			Node p = start;
			while(p.link!=null)
			{
				if(p.link.info==x)
					break;
				p=p.link;
				
			}
			
			if(p.link==null)
		        System.out.println(x+ " not present in the list");
			else
			{
			    temp = new Node(data);
				temp.link = p.link;
				p.link = temp;
			}
			
		}
		
		public void insertAtPosition(int data,int k)
		{
			Node temp;
			int i;
			
			if(k==1)
			{
				temp = new Node(data);
				temp.link=start;
				start=temp;
				return;
			}
			
			Node p=start;
			for(i=1; i<k-1 && p!=null;i++)
				p=p.link;
			if(p==null)
			    System.out.println("You can insert only upto "+i+"th position");
			else
			{
				temp = new Node(data);
				temp.link = p.link;
				p.link = temp;
			}
		}
		
		public void deleteFirstNode()
		{
			if(start==null)
				return;
			start= start.link;
			
		}
		
		public void deleteLastNode()
		{
			if(start==null)
				return;
			
			if(start.link==null)
			{
				start=null;
				return;
				
			}
			
			Node p=start;
			while(p.link.link!=null)
				p=p.link;
			p.link=null;
		}
		
		
		public void deleteNode(int x)
		{
				if(start==null)
				{
					System.out.println("List is empty\n");
					return;
				}
				
				if(start.info==x)
				{
					start=start.link;
					return;
				}
				
				Node p = start;
				while(p.link!=null)
				{
					if(p.link.info==x)
						break;
					p=p.link;
				}
				
				if(p.link==null)
					System.out.println("Element "+ x+" not in the list");
				else
					p.link=p.link.link;
				
		}
		
		public void reverseList()
		{
			Node prev,p, next;
			prev = null;
			p = start;
			while(p!=null)
			{
				next=p.link;
				p.link=prev;
				prev=p;
				p=next;
			}
			
			start= prev;
		}
		
		public void BubbleSortExData()
		{
			Node end,p,q;
			
			for(end=null;end!=start.link; end=p)
			{
				for(p=start;p.link!=end;p=p.link)
				{
				q=p.link;
				if(p.info>q.info)
				{
					int temp = p.info;
					p.info=q.info;
					q.info=temp;
				}
				}
				
			}
		}
		
		public void BubbleSortExLinks()
		{
			Node end,r,p,q,temp;		 
		
		for(end=null;end!=start.link;end=p)
		{
			for(r=p=start; p.link!=end; r=p,p=p.link)
			{
				q=p.link;
				if(p.info > q.info)
				{
					p.link=q.link;
					q.link=p;
					if(p!=start)
						r.link=q;
					else
						start=q;
					temp=p;
					p=q;
					q=temp;
				}
			}
		}
		}
		
		public SingleLinkedList merge1(SingleLinkedList list)
		{
			SingleLinkedList mergeList = new SingleLinkedList();
			mergeList.start= merge1(start,list.start);
			return mergeList;
		}
		
		private Node merge1(Node p1,Node p2)
		{
			Node startM;
			
			if(p1.info<=p2.info)
			{
				startM = new Node(p1.info);
				p1=p1.link;
			}
			else
			{
				startM = new Node(p2.info);
				p2=p2.link;
			}
			
			Node pM=startM;
			
			while(p1!=null && p2 != null)
			{	
				if(p1.info<=p2.info)
				{
					pM.link=new Node(p1.info);
					p1=p1.link;
				}
				else
				{
					pM.link = new Node(p2.info);
					p2=p2.link;
				}
				pM=pM.link;
				
			}
			
			
			while(p1!=null)
			{
				pM.link = new Node(p1.info);
				p1=p1.link;
				pM=pM.link;
			}
			
			while(p2!=null)
			{
				pM.link = new Node(p2.info);
				p2=p2.link;
				pM=pM.link;
			}
			
			return startM;
		}
		
		public SingleLinkedList merge2(SingleLinkedList list)
		{
			SingleLinkedList mergeList = new SingleLinkedList();
			mergeList.start= merge2(start,list.start);
			return mergeList;
		}
		
		private Node merge2(Node p1,Node p2)
		{
			Node startM;
			
			if(p1.info<=p2.info)
			{
				startM = p1;
				p1=p1.link;
			}
			else
			{
				startM = p2;
				p2=p2.link;
			}
			
			Node pM=startM;
			
			while(p1!=null && p2 != null)
			{	
				if(p1.info<=p2.info)
				{
					pM.link=p1;
					pM=pM.link;
					p1=p1.link;
				}
				else
				{
					pM.link = p2;
					pM=pM.link;
					p2=p2.link;
				}
				pM=pM.link;
				
			}
		
			if(p1==null)
				pM.link=p2;
			else
				pM.link=p1;
			return startM;
			
		}
		
		public void mergeSort()
		{
			start = mergeSortRec(start);
		}
		
		private Node mergeSortRec(Node listStart)
		{
				if(listStart == null || listStart.link==null)
					return listStart;
				
				Node start1 = listStart;
				Node start2 = divideList(listStart);
				start1 = mergeSortRec(start1);
				start2 = mergeSortRec(start2);
				Node startM = merge2(start1,start2);
				return startM;
				
		}
		
		private Node divideList(Node p)
		{
			Node q=p.link.link;
			while(q!=null && q.link != null)
			{
				p=p.link;
				q=q.link.link;
				
			}
			
			Node start2 = p.link;
			p.link = null;
			return start2;
		}
		
		public boolean hasCycle()
		{
			if(findCycle()==null)
				return false;
			else
				return true;
			
		}
		
		public Node findCycle()
		{
			if(start==null||start.link==null)
				return null;
			
			Node slowR=start, fastR = start;
			
			while(fastR!=null && fastR.link!=null)
			{
				slowR = slowR.link;
				fastR = fastR.link.link;
				if(slowR==fastR)
					return slowR;
			}
			return null;
		}
	    
		public void removeCycle()
		{
			Node c = findCycle();
			if(c==null)
				return;
			System.out.println("Node at which the cycle was detected is: "+c.info);
			
			Node p = c, q =c;
			int lenCycle=0;
			do
			{
				lenCycle++;
				q=q.link;
					
			}while(p!=q);
				System.out.println("Length of cycle is : "+lenCycle);
			
			int lenRemList = 0;
			p=start;
			while(p!=q)
			{
				lenRemList++;
				p=p.link;
				q= q.link;
				
			}
			
			System.out.println("Number of nodes not included in cycle are : "+lenRemList);
			
			int lengthList = lenCycle + lenRemList;
			
			System.out.println("length of the list is : "+ lengthList);
			
			p=start;
			for(int i=1;i<=lengthList-1; i++)
			   p = p.link;
			p.link=null;
			
		}
		
		public void insertCycle(int x)
		{
			if(start==null)
				return;
			Node p=start, px=null,prev =null;
			
			while(p!=null)
			{
				if(p.info==x)
					px=p;
				prev=p;
				p=p.link;
			}
			if(px!=null)
			    prev.link=px;
			else
				System.out.println(x+ " not present in the list");
			
		}
}
	 
