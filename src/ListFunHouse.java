import static java.lang.System.*;

public class ListFunHouse
{
	//this method will print the entire list on the screen
   public static void print(ListNode list) {
	   while(list.getNext() != null) {
		   System.out.println(list);
		   list = list.getNext();
	   }
   }		
	
	//this method will return the number of nodes present in list
	public static int nodeCount(ListNode list) {
		int counter = 0;
		while(list.getNext() != null) {
			counter++;
			list = list.getNext();
		}
		return counter;
	}

	//this method will create a new node with the same value as the first node and add this
	//new node to the list.  Once finished, the first node will occur twice.
	public static void doubleFirst(ListNode list) { //
		ListNode add = new ListNode(list.getValue(), list);
	}

	//this method will create a new node with the same value as the last node and add this
	//new node at the end.  Once finished, the last node will occur twice.
	public static void doubleLast(ListNode list) {
   		while(list.getNext() != null) {
   			list = list.getNext();
   		}
   		ListNode duplicate = new ListNode(list.getValue(), null);
   		list.setNext(duplicate);
	}
		
	//method skipEveryOther will remove every other node
	public static void skipEveryOther(ListNode list) {
		while(list.getNext() != null) {
				ListNode remove = list.getNext();
				list.setNext(remove.getNext());
				remove.setNext(null);
				
				list = list.getNext();
		}
	}

	//this method will set the value of every xth node in the list
	public static void setXthNode(ListNode list, int x, Comparable value) {
		while(list.getNext() != null) {
			
		}
	}	

	//this method will remove every xth node in the list
	public static void removeXthNode(ListNode list, int x)
	{
	
	}
	
	//this method will add a node at the end of the list
	public static ListNode add(ListNode list, Comparable val) {
		return null;
	}
}