import java.util.ArrayList;

public class PlayerBoard 
{
	private String name;
	private Wonder wonder1;
	private Wonder wonder2;
	private Wonder wonder3;
	
	public PlayerBoard(String str)
	{
		name=str;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Wonder getWonder1()
	{
		return wonder1;
	}
	
	public void setWonder1(ArrayList<String>arr1,int i,int j,ArrayList<String>arr2,int k,ArrayList<String>arr3,String str)
	{
		wonder1=new Wonder(arr1,i,j,arr2,k,arr3,str);
	}
	
	public Wonder getWonder2()
	{
		return wonder2;
	}
	
	public void setWonder2(ArrayList<String>arr1,int i,int j,ArrayList<String>arr2,int k,ArrayList<String>arr3,String str)
	{
		wonder2=new Wonder(arr1,i,j,arr2,k,arr3,str);
	}
	
	public Wonder getWonder3()
	{
		return wonder3;
	}
	
	public void setWonder3(ArrayList<String>arr1,int i,int j,ArrayList<String>arr2,int k,ArrayList<String>arr3,String str)
	{
		wonder3=new Wonder(arr1,i,j,arr2,k,arr3,str);
	}
}
