import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Deck {
    private HashMap<Integer, ArrayList<Card>> cards1;
    private HashMap<Integer, ArrayList<Card>> cards2;
    private HashMap<Integer, ArrayList<Card>> cards3;
    private ArrayList<Card> discard;
    private int age;

    public Deck() throws IOException {
        Scanner scan = new Scanner(new File("age1Cards.txt"));

        cards1 = new HashMap<Integer,ArrayList<Card>>();
        cards2 = new HashMap<Integer,ArrayList<Card>>();
        cards3 = new HashMap<Integer,ArrayList<Card>>();

        for(int i = 1; i < 4; i++) {
            if(i == 2)
                scan = new Scanner(new File("age2Cards.txt"));
            else if(i == 3)
                scan = new Scanner(new File("age3Cards.txt"));

            ArrayList<Card> arrayList = new ArrayList<Card>();
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
                    String[] resourcesArray = array[2].split(",");
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

                arrayList.add(new Card(color, name, resources, coinCost, resourceCost, victoryPoints, military, science, action, left, right, self, coins, awardColor, chain1, chain2));
            }
            Collections.shuffle(arrayList);

            if(i == 1) {
                ArrayList<Card> tempHand = new ArrayList<Card>();
                for (int x = 0; x < 7; x++)
                    tempHand.add(arrayList.get(x));
                cards1.put(0, tempHand);

                tempHand = new ArrayList<Card>();
                for (int x = 7; x < 14; x++)
                    tempHand.add(arrayList.get(x));
                cards1.put(1, tempHand);

                tempHand = new ArrayList<Card>();
                for (int x = 14; x < 21; x++)
                    tempHand.add(arrayList.get(x));
                cards1.put(2, tempHand);
            }
            else if(i == 2) {
                ArrayList<Card> tempHand = new ArrayList<Card>();
                for (int x = 0; x < 7; x++)
                    tempHand.add(arrayList.get(x));
                cards2.put(0, tempHand);

                tempHand = new ArrayList<Card>();
                for (int x = 7; x < 14; x++)
                    tempHand.add(arrayList.get(x));
                cards2.put(1, tempHand);

                tempHand = new ArrayList<Card>();
                for (int x = 14; x < 21; x++)
                    tempHand.add(arrayList.get(x));
                cards2.put(2, tempHand);
            }
            else {
                ArrayList<Card> tempHand = new ArrayList<Card>();
                for (int x = 0; x < 7; x++)
                    tempHand.add(arrayList.get(x));
                cards3.put(0, tempHand);

                tempHand = new ArrayList<Card>();
                for (int x = 7; x < 14; x++)
                    tempHand.add(arrayList.get(x));
                cards3.put(1, tempHand);

                tempHand = new ArrayList<Card>();
                for (int x = 14; x < 21; x++)
                    tempHand.add(arrayList.get(x));
                cards3.put(2, tempHand);
            }
        }
        discard = new ArrayList<Card>();
        age = 1;
    }

    public ArrayList<Card> getCards(int hand) {
        if(age == 1)
            return cards1.get(hand);
        else if(age == 2)
            return cards2.get(hand);
        return cards3.get(hand);
    }
    public ArrayList<Card> getDiscard() {
        return discard;
    }
    public int getAge() {
        return age;
    }

    public void removeCard(int hand, int index) {
        if(age == 1)
            cards1.get(hand).remove(index);
        else if(age == 2)
            cards2.get(hand).remove(index);
        else
            cards3.get(hand).remove(index);
    }
    public void discard(Card card) {
        discard.add(card);
    }
    public void incrementAge() {
        age += 1;
    }
}
