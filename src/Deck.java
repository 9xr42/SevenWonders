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

    public Deck() throws IOException {
        ArrayList<Card> tempArrayList = new ArrayList<Card>();
        String[] tempArray;
        Scanner textFileScan = new Scanner(new File("age1Cards.txt"));

        while(textFileScan.hasNextLine()) {
            tempArray = textFileScan.nextLine().split("-");
            if(tempArray[0].equals("gray")) {
                tempArrayList.add(new GrayCard(tempArray[0], tempArray[1], tempArray[2]));
            }
            //Done
            else if(tempArray[0].equals("brown")) {
                String color = tempArray[0];
                String name = tempArray[1];
                int cost = Integer.parseInt(tempArray[3]);

                ArrayList<String> resources = new ArrayList<String>();
                tempArray = tempArray[2].split(",");
                for(int i = 0 ; i < tempArray.length; i++)
                    resources.add(tempArray[i]);

                tempArrayList.add(new BrownCard(color, name, cost, resources));
            }
            //Done
            else if(tempArray[0].equals("green")) {
                String color = tempArray[0];
                String name = tempArray[1];
                String science = tempArray[2];
                String chain1 = tempArray[4];
                String chain2 = tempArray[5];

                ArrayList<String> cost = new ArrayList<String>();
                tempArray = tempArray[3].split(",");
                for(int i = 0 ; i < tempArray.length; i++)
                    cost.add(tempArray[i]);

                tempArrayList.add(new GreenCard(color, name, cost, science, chain1, chain2));
            }
            //Done
            else if(tempArray[0].equals("red")) {
                String color = tempArray[0];
                String name = tempArray[1];
                int military = Integer.parseInt(tempArray[2]);
                String chain = tempArray[4];

                ArrayList<String> cost = new ArrayList<String>();
                tempArray = tempArray[3].split(",");
                for(int i = 0 ; i < tempArray.length; i++)
                    cost.add(tempArray[i]);

                tempArrayList.add(new RedCard(color, name, cost, military, chain));
            }
            //Done
            else if(tempArray[0].equals("yellow")) {
                String color = tempArray[0];
                String name = tempArray[1];
                String chain = tempArray[3];

                String[] tempArray2 = tempArray[2].split(",");
                ArrayList<String> cost = new ArrayList<String>();
                for(int i = 0 ; i < tempArray.length; i++)
                    cost.add(tempArray[i]);

                tempArray = tempArray[2].split(",");
                String action = tempArray[0];

                if(action.equals("discount")) {
                    ArrayList<String> resources = new ArrayList<String>();
                    tempArray = tempArray[1].split(",");
                    for (String resource : tempArray)
                        resources.add(resource);

                    boolean left = false;
                    if (tempArray[2].equals("true"))
                        left = true;
                    boolean right = false;
                    if (tempArray[3].equals("true"))
                        right = true;

                    tempArrayList.add(new YellowCard(color, name, cost, action, resources, left, right, chain));
                }
                //Done
                else if(action.equals("resource")) {
                    ArrayList<String> resources = new ArrayList<String>();
                    tempArray = tempArray[1].split(",");
                    for (String resource : tempArray)
                        resources.add(resource);

                    tempArrayList.add(new YellowCard(color, name, cost, action, resources, chain));
                }
                //Done
                else if(action.equals("guild")) {

                }
            }
            else if(tempArray[0].equals("blue")) {
                String color = tempArray[0];
                String name = tempArray[1];
                int victoryPoints = Integer.parseInt(tempArray[2]);
                String chain = tempArray[4];

                ArrayList<String> cost = new ArrayList<String>();
                tempArray = tempArray[3].split(",");
                for(int i = 0; i < tempArray.length; i++)
                    cost.add(tempArray[i]);

                tempArrayList.add(new BlueCard(color, name, cost, victoryPoints, chain));
            }
            //Done

            // "/" for "or"
            // "," for "and"
        }
        Collections.shuffle(tempArrayList);
        cards = new HashMap<Integer, ArrayList<Card>>();

        ArrayList<Card> tempHand = new ArrayList<Card>();
        for(int i = 0; i < 7; i++)
            tempHand.add(tempArrayList.get(i));
        cards.put(1, tempHand);
        tempHand = new ArrayList<Card>();
        for(int i = 7; i < 14; i++)
            tempHand.add(tempArrayList.get(i));
        cards.put(2, tempHand);
        tempHand = new ArrayList<Card>();
        for(int i = 14; i < 20; i++)
            tempHand.add(tempArrayList.get(i));
        cards.put(3, tempHand);

        discard = new ArrayList<Card>();
    }

    public ArrayList<Card> getHand(int val) {
        return cards.get(val);
    }
    public ArrayList<Card> getDiscard() {
        return discard;
    }

    public void discard(Card card) {
        discard.add(card);
    }
    public void incrementAge(int age) throws IOException {
        Scanner textFileScan;
        if(age == 2) {
            textFileScan = new Scanner(new File("age2Cards.txt"));
        }
        else {
            textFileScan = new Scanner(new File("age3Cards.txt"));
        }

        ArrayList<Card> tempArrayList = new ArrayList<Card>();
        String[] tempArray;
        while(textFileScan.hasNextLine()) {
            tempArray = textFileScan.nextLine().split("-");
            if(tempArray[0].equals("gray")) {
                tempArrayList.add(new GrayCard(tempArray[0], tempArray[1], tempArray[2]));
            }
            else if(tempArray[0].equals("brown")) {
                String color = tempArray[0];
                String name = tempArray[1];
                int cost = Integer.parseInt(tempArray[3]);

                ArrayList<String> resources = new ArrayList<String>();
                tempArray = tempArray[2].split(",");
                for(String resource : tempArray)
                    resources.add(resource);

                tempArrayList.add(new BrownCard(color, name, cost, resources));
            }
            else if(tempArray[0].equals("green")) {
                String color = tempArray[0];
                String name = tempArray[1];
                String science = tempArray[2];
                String chain1 = tempArray[4];
                String chain2 = tempArray[5];

                ArrayList<String> cost = new ArrayList<String>();
                tempArray = tempArray[3].split(",");
                for(String resource: tempArray)
                    cost.add(resource);

                tempArrayList.add(new GreenCard(color, name, cost, science, chain1, chain2));
            }
            else if(tempArray[0].equals("red")) {
                String color = tempArray[0];
                String name = tempArray[1];
                int military = Integer.parseInt(tempArray[2]);
                String chain = tempArray[4];

                ArrayList<String> cost = new ArrayList<String>();
                tempArray = tempArray[3].split(",");
                for(String resource : tempArray)
                    cost.add(resource);

                tempArrayList.add(new RedCard(color, name, cost, military, chain));
            }
            else if(tempArray[0].equals("yellow")) {
                String color = tempArray[0];
                String name = tempArray[1];
                String chain = tempArray[3];

                ArrayList<String> cost = new ArrayList<String>();

                tempArray = tempArray[2].split(",");
                String action = tempArray[0];

                if(action.equals("discount")) {
                    boolean left = false;
                    if (tempArray[2].equals("true"))
                        left = true;
                    boolean right = false;
                    if (tempArray[3].equals("true"))
                        right = true;

                    ArrayList<String> resources = new ArrayList<String>();
                    tempArray = tempArray[1].split(".");
                    for (String resouce : tempArray)
                        resources.add(resouce);

                    tempArrayList.add(new YellowCard(color, name, cost, action, resources, left, right, chain);
                }
                else if(action.equals("resource")) {

                }
                else if(action.equals("guild")) {

                }
            }
            else if(tempArray[0].equals("blue")) {
                String color = tempArray[0];
                String name = tempArray[1];
                int victoryPoints = Integer.parseInt(tempArray[2]);
                String chain = tempArray[4];

                ArrayList<String> cost = new ArrayList<String>();
                tempArray = tempArray[3].split("&");
                for(int i = 0; i < tempArray.length; i++)
                    cost.add(tempArray[i]);

                tempArrayList.add(new BlueCard(color, name, cost, victoryPoints, chain));
            }
        }
    }
    public String toString() {
        String output = "";
        for(int x = 1; x <= 3; x++)
            for(int y = 0; y < 7; y++)
                output += getHand(x).get(y) + "\n";
        return output;
    }
}