import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Deck2 {
    private HashMap<Integer, ArrayList<Card2>> cards1;
    private HashMap<Integer, ArrayList<Card2>> cards2;
    private HashMap<Integer, ArrayList<Card2>> cards3;
    private ArrayList<Card2> discard;
    private int age;

    public Deck2() throws IOException {
        Scanner scan = new Scanner(new File("age1Cards.txt"));
        age = 1;

        cards1 = new HashMap<Integer,ArrayList<Card2>>();
        cards2 = new HashMap<Integer,ArrayList<Card2>>();
        cards3 = new HashMap<Integer,ArrayList<Card2>>();

        for(int i = 1; i < 4; i++) {
        	if(i == 2)
                scan = new Scanner(new File("age2Cards.txt"));
            else if(i == 3)
                scan = new Scanner(new File("age3Cards.txt"));

            ArrayList<Card2> arrayList = new ArrayList<Card2>();
            while(scan.hasNextLine()) {
                String[] array = scan.nextLine().split("--");

                String color = array[0];
                String name = array[1];
                ArrayList<String> resources;
                int coinCost;
                ArrayList<String> resourceCost;
                int victoryPoints;
                int military;
                String science;
                String action;
                boolean left;
                boolean right;
                boolean self;
                int coins;
                String awardColor;
                String chain1;
                String chain2;

                if(!array[2].equals("NA")) {
                    String[] resourcesArray = array[2].split("/");
                    resources = new ArrayList<String>();
                    for(int x = 0; x < resourcesArray.length; x++)
                        resources.add(resourcesArray[x]);
                }
                else {
                    resources = null;
                }
                if(!array[3].equals("NA")) {
                    coinCost = Integer.parseInt(array[3]);
                }
                else {
                    coinCost = 0;
                }
                if(!array[4].equals("NA")) {
                    resourceCost = new ArrayList<String>();
                    String[] resourceArray = array[4].split(",");
                    for(int x = 0; x < resourceArray.length; x++)
                        resourceCost.add(resourceArray[x]);
                }
                else {
                    resourceCost = null;
                }
                if(!array[5].equals("NA")) {
                    victoryPoints = Integer.parseInt(array[5]);
                }
                else {
                    victoryPoints = 0;
                }
                if(!array[6].equals("NA")) {
                    military = Integer.parseInt(array[6]);
                }
                else {
                    military = 0;
                }
                if(!array[7].equals("NA")) {
                    science = array[7];
                }
                else {
                    science = "";
                }
                if(!array[8].equals("NA")) {
                    action = array[8];
                }
                else {
                    action = "";
                }
                if(!array[9].equals("NA")) {
                    left = false;
                    if(array[9].equals("true"))
                        left = true;
                }
                else {
                    left = false;
                }
                if(!array[10].equals("NA")) {
                    right = false;
                    if(array[10].equals("true"))
                        right = true;
                }
                else {
                    right = false;
                }
                if(!array[11].equals("NA")) {
                    self = false;
                    if(array[11].equals("true"))
                        self = true;
                }
                else {
                    self = false;
                }
                if(!array[12].equals("NA")) {
                    coins = Integer.parseInt(array[12]);
                }
                else {
                    coins = 0;
                }
                if(!array[13].equals("NA")) {
                    awardColor = array[13];
                }
                else {
                    awardColor = "";
                }
                if(!array[14].equals("NA")) {
                    chain1 = array[14];
                }
                else {
                    chain1 = "";
                }
                if(!array[15].equals("NA")) {
                    chain2 = array[15];
                }
                else {
                    chain2 = "";
                }

                arrayList.add(new Card2(color, name, resources, coinCost, resourceCost, victoryPoints, military, science, action, left, right, self, coins, awardColor, chain1, chain2));
            }
            Collections.shuffle(arrayList);
            if(i == 1) {
                ArrayList<Card2> tempHand = new ArrayList<Card2>();
                for (int x = 0; x < 7; x++)
                    tempHand.add(arrayList.remove(0));
                cards1.put(0, tempHand);

                tempHand = new ArrayList<Card2>();
                for (int x = 7; x < 14; x++)
                    tempHand.add(arrayList.remove(0));
                cards1.put(1, tempHand);

                tempHand = new ArrayList<Card2>();
                for (int x = 14; x < 21; x++)
                    tempHand.add(arrayList.remove(0));
                cards1.put(2, tempHand);
            }
            else if(i == 2) {
                ArrayList<Card2> tempHand = new ArrayList<Card2>();
                for (int x = 0; x < 7; x++)
                    tempHand.add(arrayList.remove(0));
                cards2.put(0, tempHand);

                tempHand = new ArrayList<Card2>();
                for (int x = 7; x < 14; x++)
                    tempHand.add(arrayList.remove(0));
                cards2.put(1, tempHand);

                tempHand = new ArrayList<Card2>();
                for (int x = 14; x < 21; x++)
                    tempHand.add(arrayList.remove(0));
                cards2.put(2, tempHand);
            }
            else {
                ArrayList<Card2> tempHand = new ArrayList<Card2>();
                for (int x = 0; x < 7; x++)
                    tempHand.add(arrayList.remove(0));
                cards3.put(0, tempHand);

                tempHand = new ArrayList<Card2>();
                for (int x = 7; x < 14; x++)
                    tempHand.add(arrayList.remove(0));
                cards3.put(1, tempHand);

                tempHand = new ArrayList<Card2>();
                for (int x = 14; x < 21; x++)
                    tempHand.add(arrayList.remove(0));
                cards3.put(2, tempHand);
            }
        }

        discard = new ArrayList<Card2>();
    }
    public ArrayList<Card2> getHand(int val) {
        if(age == 1)
            return cards1.get(val);
        else if(age == 2)
            return cards2.get(val);
        return cards3.get(val);
    }
    public ArrayList<Card2> getDiscard() {
        return discard;
    }
    public int getAge() {
        return age;
    }

    public void discard(Card2 card) {
        discard.add(card);
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        String output = "";
        for(int x = 1; x <= 3; x++)
            for(int y = 0; y < 7; y++)
                output += getHand(x).get(y) + "\n";
        return output;
    }
    
    public void rotate()
    {
    	if(age==1)
    	{
    		//private HashMap<Integer, ArrayList<Card2>> cards1;
    		ArrayList<Card2> temp1 = getHand(0);
    		ArrayList<Card2> temp2 = getHand(1);
    		ArrayList<Card2> temp3 = getHand(2);
    		cards1.put(0, temp3);
    		cards1.put(1, temp1);
    		cards1.put(2, temp2);
    	}
    	else if(age==2)
    	{
    		ArrayList<Card2> temp1 = getHand(0);
    		ArrayList<Card2> temp2 = getHand(1);
    		ArrayList<Card2> temp3 = getHand(2);
    		cards2.put(0, temp2);
    		cards2.put(1, temp3);
    		cards2.put(2, temp1);
    	}
    	else if(age==3)
    	{
    		ArrayList<Card2> temp1 = getHand(0);
    		ArrayList<Card2> temp2 = getHand(1);
    		ArrayList<Card2> temp3 = getHand(2);
    		cards3.put(0, temp3);
    		cards3.put(1, temp1);
    		cards3.put(2, temp2);
    	}
    }
    public ArrayList<Card2> getAgeDeck(int age) {
		ArrayList<Card2> temp = new ArrayList<Card2>();
		if(age==1)
		{
			for(int i=0; i<=2; i++)
			{
				for(Card2 card: cards1.get(i))
					temp.add(card);
			}
		}
		else if(age==2)
		{
			for(int i=0; i<=2; i++)
			{
				for(Card2 card: cards2.get(i))
					temp.add(card);
			}
		}
		else if(age==3)
		{
			for(int i=0; i<=2; i++)
			{
				for(Card2 card: cards3.get(i))
					temp.add(card);
			}
		}
		return temp;
	}
}
