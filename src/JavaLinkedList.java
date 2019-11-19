import java.util.LinkedList;

public class JavaLinkedList {
	private LinkedList<Integer> linkedList;
	
	public JavaLinkedList(String data) {
		linkedList = new LinkedList<Integer>();
		
		String[] tempArray = data.split(" ");
		for(String tempString : tempArray) 
			linkedList.add(Integer.parseInt(tempString));
	}
}
