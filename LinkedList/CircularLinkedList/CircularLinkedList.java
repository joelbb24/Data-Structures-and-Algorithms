package circularLinkedList;

import java.util.Scanner;

public class CircularLinkedList 
{
	private Node last;
	
	public CircularLinkedList()
	{
		last = null;
	}
	
	public void displayList() {
		Node p;
		if(last==null)
		{
			System.out.println("The list is empty");
			return;
		}
		p=last.link;
		
		do
		{
			System.out.println(p.info+ " ");
			p=p.link;
		}while(p!=last.link);
		System.out.println();
	}
	
	public void insertInBeginning(int data)
	{
		Node temp = new Node(data);
		temp.link=last.link;
		last.link=temp;
		
		
	}
	
	public void insertInEmptyList(int data)
	{
		Node temp = new Node(data);
		last = temp;
		last.link = last;
	}	
	
	public void insertAtEnd(int data)
	{
		Node temp = new Node(data);
		temp.link = last.link;
		last.link = temp;
		last = temp;
	}
	
	public void createList()
	{
		int i,n,data;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the number of nodes.");
		n = scan.nextInt();
		
		if(n==0)
			return;
		System.out.println("Enter the first element to be inserted.");
		data = scan.nextInt();
		insertInEmptyList(data);
		
		for(i=2;i<=n;i++)
		{
			System.out.println("Enter the next element to be inserted.");
			data = scan.nextInt();
			insertAtEnd(data);	
		}

	}
	
	public void insertAfter(int data, int x)
	{
		Node p = last.link;
		do
		{
			if(p.info == x)
				break;
			p=p.link;
			
		}while(p!=last.link);
		
		if(p==last.link && p.info !=x)
			System.out.println(x+" not present in the list");
		else
		{
			Node temp = new Node(data);
			temp.link = p.link;
			p.link = temp;
			if(p==last)
				last = temp;
			
		}
	}
	
	public void deleteFirstNode()
	{
		if(last==null)
			return;
		if(last.link==last)
		{
			last = null;
			return;
		}
		last.link = last.link.link;
	}
	
	public void deleteLastNode()
	{
		if(last==null)
			return;
		if(last.link == last)
		{
			last = null;
			return;
			
		}
		Node p = last.link;
		while(p.link!=last)
			p=p.link;
		p.link = last.link;
		last = p;
		
	}
	
	public void deleteNode(int x)
	{
		if(last == null)
			return;
		
		if(last.link == last && last.info == x)
		{
			last = null;
			return;
		}
		
		if(last.link.info == x)
		{
			last.link = last.link.link;
			return;
		}
		
		Node p = last.link;
		while(p.link!=last.link)
		{
			if(p.link.info==x)
				break;
			p=p.link;
		}
		
		if(p.link == last.link)
			System.out.println(x+ " not found in the list");
		else
		{
			p.link = p.link.link;
			if(last.info==x)
				last = p;
			
		}
	}
	
	public void concatenate(CircularLinkedList list)
	{
		if(last==null)
		{
			last=list.last;
			return;
			
		}
		
		if(list.last==null)
			return;
		
		Node p = last.link;
		last.link = list.last.link;
		list.last.link = p;
		last = list.last;
	}
	
}

