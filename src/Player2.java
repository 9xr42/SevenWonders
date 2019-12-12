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
    private boolean olympiaEffect;
    private boolean halikEffect;
    private ArrayList<String> tempResources;
    //private 

    public Player2(PlayerBoard2 playerBoard, int playerNumber) {
        this.playerBoard = playerBoard;
        this.hand = new ArrayList<Card2>();
        this.money = 3;
        this.playerNumber = playerNumber;
        this.positiveWarPoints = 0;
        this.negativeWarPoints = 0;
        militaryPoints = 0;
        olympiaEffect = false;
        halikEffect = false;
        tempResources = new ArrayList<String>();
    }
    
    public boolean olympiaEffect()
    {
    	return olympiaEffect;
    }
    
    public void useOlympia()
    {
    	olympiaEffect = true;
    }
    
    public void resetOlympia()
    {
    	olympiaEffect = false;
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
    	//System.out.println("hi");
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
    		//System.out.println(card);
    		if(card.getResources().get(0).contains(","))
    		{
    			String[] temp2 = card.getResources().get(0).split(",");
    			for(String i: temp2)
    				temp.add(i);
    		}
    		else if(card.getResources().size()==1)
    			temp.add(card.getResources().get(0));
    		else
    		{
    			//System.out.println("hi2");
    			//String str = "";
    			for(String i: card.getResources())
    				temp.add(i);
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
    		if(card.getResources().get(0).contains(","))
    		{
    			String[] temp2 = card.getResources().get(0).split(",");
    			for(String i: temp2)
    				temp.add(i);
    		}
    		else if(card.getResources().size()==1)
    			temp.add(card.getResources().get(0));
    		else 
    		{
    			for(String i: card.getResources())
    				temp.add(i);
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
    	if(card.color.equals("red"))
    		militaryPoints+=card.getMilitary();
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
    		//addCard(card);
    		return true;
    	}
    		
    	else if(card.color.equals("brown"))
    	{
    		int cost = card.getCoinCost();
    		if(money>=cost)
    		{
    			money-=cost;
    			//addCard(card);
    			return true;
    		}
    	}
    	else 
    	{
    		if(card.getResourceCost()==null||chain(card))
    		{
    			//addCard(card);
    			return true;
    		}
    		else
    		{
    			ArrayList<String> cost = card.getResourceCost();
    			//ArrayList<String> temp = new ArrayList<String>(cost);
    			for(String i: getResourceList())
    			{
    				if(cost.contains(i))
    					cost.remove(i);
    			}
    			if(cost.size()==0)
    			{
    				//addCard(card);
    				//if(card.color.equals("red"))
    		    		//militaryPoints+=card.getMilitary();
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
    
    public TreeMap<String, String> getDiscounts()
    {
    	TreeMap<String, String> map = new TreeMap<String, String>();
    	String left = "";
    	String right = "";
    	for(Card2 card: getHand())
    	{
    		if(card.getAction().equals("discount"))
    		{
    			if(card.isLeft())
    			{
    				for(String i: card.getResources())
    					left+=i + " ";
    			}
    			else if(card.isRight())
    			{
    				for(String i: card.getResources())
    					right+=i + " ";
    			}
    		}
    	}
    	map.put("left", left);
    	map.put("right", right);
    	return map;
    	
    }
    
    public boolean buildWonder()
    {
    	ArrayList<String> temp = playerBoard.wonderCost();
    	for(String i: getResourceList())
		{
			if(temp.contains(i))
				temp.remove(i);
		}
		if(temp.size()==0)
		{
			//addCard(card);
			//if(card.color.equals("red"))
	    		//militaryPoints+=card.getMilitary();
			playerBoard.buildWonder();
			if(mostRecentWonder()==2)
			{
				String[] effect = playerBoard.getWonder2().getEffect().split(" ");
				if(effect[0].equals("military"))
					militaryPoints += Integer.parseInt(effect[1]);
				else if(effect[0].equals("coin"))
					money+=Integer.parseInt(effect[1]);
			}
			return true;
		}
		return false;
    	
    }
    
    public String getSpecialEffect()
    {
    	return playerBoard.getWonder2().getEffect();
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
        /*for(Card2 card: yellow)
            score += card.getVictoryPoints();
        for(Card2 card: purple)
            score += card.getVictoryPoints();


        purpleCards = purple;*/
        return score;
    }

    public int getGuildScore()
    {
        int thisScore = 0;
        ArrayList<Card2> purple = new ArrayList<Card2>();
        for(Card2 card: purple)
        {
            if(card.name.equals("philosophersguild"))
            {
                if(card.color.equals("green"))
                    thisScore++;
            }
            if(card.name.equals("magistratesguild"))
            {
                if(card.color.equals("blue"))
                    thisScore++;
            }
            if(card.name.equals("tradersguild"))
            {
                if(card.color.equals("yellow"))
                    thisScore++;
            }
            if(card.name.equals("craftsmensguild"))
            {
                if(card.color.equals("gray"))
                    thisScore+=2;
            }
            if(card.name.equals("workersguild"))
            {
                if(card.color.equals("brown"))
                    thisScore++;
            }
        }
        return thisScore;
    }

    public int setScore(int add)
    {
        return getScore()+add;
    }
}
