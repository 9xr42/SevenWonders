import java.util.ArrayList;
import java.util.TreeMap;

public class Player2 {
    private PlayerBoard2 playerBoard;
    private ArrayList<Card2> hand;
    private int money;
    private int playerNumber;
    private int positiveWarPoints;
    private int negativeWarPoints;
    private int militaryPoints;

    public Player2(PlayerBoard2 playerBoard, int playerNumber) {
        this.playerBoard = playerBoard;
        this.hand = new ArrayList<Card2>();
        this.money = 3;
        this.playerNumber = playerNumber;
        this.positiveWarPoints = 0;
        this.negativeWarPoints = 0;
        militaryPoints = 0;
    }

	public PlayerBoard2 getPlayerBoard() {
        return playerBoard;
    }
    
    public String getBoardName()
    {
    	return playerBoard.getName();
    }
    public ArrayList<Card2> getHand() {
        return hand;
    }
    public int getMoney() {
        return money;
    }
    public int getPlayerNumber() {
        return playerNumber;
    }
    public int getPositiveWarPoints() {
        return positiveWarPoints;
    }

    public int getNegativeWarPoints()
    {
        return negativeWarPoints;
    }
    
    public int getMilitaryPoints()
    {
    	return militaryPoints;
    }
    
    public void addMilitaryPoints(int num)
    {
    	militaryPoints+=num;
    }
    
    public ArrayList<Card2> getColorCards(String color)
    {
    	ArrayList<Card2> temp = new ArrayList<Card2>();
    	for(Card2 card: hand)
    	{
    		if(card.color.equals(color))
    			temp.add(card);
    	}
    	return temp;	
    }
    
    public TreeMap<String, Integer> getResources()
    {
    	TreeMap<String, Integer> resources = new TreeMap<String, Integer>();
    	resources.put("wood", 0);
    	resources.put("stone", 0);
    	resources.put("clay", 0);
    	resources.put("ore", 0);
    	resources.put("papyrus", 0);
    	resources.put("glass", 0);
    	resources.put("cloth",0);
    	ArrayList<String> temp = new ArrayList<String>();
    	for(Card2 card: getColorCards("brown"))
    	{
    		if(card.getResources().size()==1)
    			temp.add(card.getResources().get(0));
    		else
    		{
    			String str = "";
    			for(String i: card.getResources())
    				str+=i+ " ";
    			temp.add(str);
    		}
    	}
    		
    	for(Card2 card: getColorCards("gray"))
    	{
    		temp.add(card.getResources().get(0));
    	}
    	temp.add(playerBoard.getResource());
    	
    	for(String i: temp)
    	{
    		if(resources.containsKey(i))
    			resources.put(i, resources.get(i)+1);
    		else
    			resources.put(i, 1);
    	}
    	return resources;
    }
    public ArrayList<String> getResourceList()
    {
    	ArrayList<String> temp = new ArrayList<String>();
    	for(Card2 card: getColorCards("brown"))
    	{
    		if(card.getResources().size()==1)
    			temp.add(card.getResources().get(0));
    		else
    		{
    			String str = "";
    			for(String i: card.getResources())
    				str+=i+ " ";
    			temp.add(str);
    		}
    	}
    		
    	for(Card2 card: getColorCards("gray"))
    	{
    		temp.add(card.getResources().get(0));
    	}
    	temp.add(playerBoard.getResource());
    	
    	return temp;
    }

    public void addCard(Card2 card) {
    	
        hand.add(card);
    }
    public void changeMoney(int amount) {
        money += amount;
    }
    public void increasePositiveWarPoints(int amount) {
        positiveWarPoints += amount;
    }
    public void increaseNegativeWarPoints(int amount) {
        negativeWarPoints += amount;
    }
    
    public boolean buyCard(Card2 card)
    {
    	if(card.color.equals("gray"))
    	{
    		addCard(card);
    		return true;
    	}
    		
    	else if(card.color.equals("brown"))
    	{
    		int cost = card.getCoinCost();
    		if(money>=cost)
    		{
    			money-=cost;
    			addCard(card);
    			return true;
    		}
    	}
    	else 
    	{
    		if(card.getResourceCost()==null||chain(card))
    		{
    			addCard(card);
    			return true;
    		}
    		else
    		{
    			ArrayList<String> cost = card.getResourceCost();
    			ArrayList<String> temp = new ArrayList<String>(getResourceList());
    			for(String i: cost)
    			{
    				if(temp.contains(i))
    					temp.remove(i);
    			}
    			if(temp.size()>=1)
    			{
    				addCard(card);
    				if(card.color.equals("red"))
    		    		militaryPoints+=card.getMilitary();
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    public boolean chain(Card2 card)
    {
      for(int i=0;i<hand.size();i++)
      {
        if(hand.get(i).getChain1().equals(card.getName())||hand.get(i).getChain2().equals(card.getName()))
          return true;
      }
      return false;
    }
    
    public void buildWonder()
    {
    	playerBoard.buildWonder();
    }
    
    public int mostRecentWonder()
    {
    	if(playerBoard.getWonder3().isHasBeenBuilt())
    		return 3;
    	else if(playerBoard.getWonder2().isHasBeenBuilt())
    		return 2;
    	else if(playerBoard.getWonder1().isHasBeenBuilt())
    		return 1;
    	return 0;
    }
    public int getScore() {
        int score = 0;
        score += getPositiveWarPoints();
        score += getNegativeWarPoints();
        score += getMoney()/3;
        score += getPlayerBoard().getPoints();
        ArrayList<Card2> blue = new ArrayList<Card2>();
        ArrayList<Card2> green = new ArrayList<Card2>();
        ArrayList<Card2> yellow = new ArrayList<Card2>();
        ArrayList<Card2> purple = new ArrayList<Card2>();
        for(Card2 card: hand)
        {
            if(card.color.equals("blue"))
                blue.add(card);
            else if(card.color.equals("green"))
                green.add(card);
            else if(card.color.equals("yellow"))
                yellow.add(card);
            else if(card.color.equals("purple"))
                purple.add(card);
        }

        for(Card2 card: blue)
            score += card.getVictoryPoints();
        for(Card2 card: green)
        {
            int gear = 0;
            int compass = 0;
            int tablet = 0;
            if(card.getScience().equals("gear"))
                gear++;
            else if(card.getScience().equals("compass"))
                compass ++;
            else
                tablet++;
            score += gear*gear + compass*compass + tablet*tablet;
        }
        for(Card2 card: yellow)
            score += card.getVictoryPoints();
        for(Card2 card: purple)
            score += card.getVictoryPoints();

        return score;
    }
}
