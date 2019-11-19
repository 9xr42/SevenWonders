import java.util.Scanner;
import java.io.File;
import java.io.IOException;


public class JavaLinkedListRunner {
	public static void main(String[] args) throws IOException {
		Scanner textFileScan = new Scanner(new File("JavaLinkedList.txt"));
		
		while(textFileScan.hasNextLine()) {
			JavaLinkedList linkedList = new JavaLinkedList(textFileScan.nextLine());
			linkedList.printSum();
			linkedList.printAverage();
			linkedList.printSmallest();
			linkedList.printLargest();
		}
	}
}
