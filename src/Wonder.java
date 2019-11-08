import java.util.ArrayList;

public class Wonder 
{
	private boolean hasBeenBuilt=false;
	private ArrayList<String>cost;
	private int victoryPoints;
	private int military;
	private ArrayList<String>resources;
	private int coins;
	private ArrayList<String>sciences;
	private String action;
	
	public Wonder(ArrayList<String>arr1,int i,int j,ArrayList<String>arr2,int k,ArrayList<String>arr3,String str)
	{
		cost=arr1;
		victoryPoints=i;
		military=j;
		resources=arr2;
		coins=k;
		sciences=arr3;
		action=str;
	}
	
	public void build()
	{
		hasBeenBuilt=true;
	}
	
	public boolean getHasBeenBuilt()
	{
		return hasBeenBuilt;
	}
	
	public ArrayList<String> getCost()
	{
		return cost;
	}
	
	public int getVictoryPoints()
	{
		return victoryPoints;
	}
	
	public int getMilitary()
	{
		return military;
	}
	
	public ArrayList<String> getResources()
	{
		return resources;
	}
	
	public int getCoins()
	{
		return coins;
	}
	
	public ArrayList<String> getSciences()
	{
		return sciences;
	}
	
	public String getAction()
	{
		return action;
	}
}
