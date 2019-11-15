import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class PreFix 
{
	public static void main(String[]args)throws IOException
	{
		Scanner scan=new Scanner(new File("PreFix.txt"));
		while(scan.hasNextLine())
		{
			String[]arr=scan.nextLine().split(" ");
			Stack<Double>stack=prefix(arr);
			print(arr,stack.peek());
		}
	}
	public static Stack<Double>prefix(String[]in)
	{
		Stack<Double>stack=new Stack<Double>();
		List<String>temp=Arrays.asList(in);
		ArrayList<String>list=new ArrayList<String>(temp);
		while(!(list.size()==0))
		{
			if(list.get(list.size()-1).equals("+"))
			{
				double i=stack.pop();
				double j=stack.pop();
				stack.push(i+j);
			}
			else if(list.get(list.size()-1).equals("-"))
			{
				double i=stack.pop();
				double j=stack.pop();
				stack.push(i-j);
			}
			else if(list.get(list.size()-1).equals("*"))
			{
				double i=stack.pop();
				double j=stack.pop();
				stack.push(i*j);
			}
			else if(list.get(list.size()-1).equals("/"))
			{
				double i=stack.pop();
				double j=stack.pop();
				stack.push(i/j);
			}
			else
				stack.push(Double.parseDouble(list.get(list.size()-1)));
			list.remove(list.size()-1);
		}
		return stack;
	}
	public static void print(String[]in,double num)
	{
		for(int i=0;i<in.length;i++)
			System.out.print(in[i]+" ");
		System.out.print("= "+num);
		System.out.println();
	}
}
