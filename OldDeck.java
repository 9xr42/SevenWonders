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
        String[] tempArray;

        Scanner textFileScan = new Scanner(new File("age1Cards.txt"));
        for(int x = 0; x < 3; x++) {
            if(x == 1)
                textFileScan = new Scanner(new File("age2Cards.txt"));
            else if(x == 2)
                textFileScan = new Scanner(new File("age3Cards.txt"));

            ArrayList<Card> tempArrayList = new ArrayList<Card>();

            while (textFileScan.hasNextLine()) {
                tempArray = textFileScan.nextLine().split("-");
                String color = tempArray[0];
                String name = tempArray[1];

                if (color.equals("gray")) {
                    tempArrayList.add(new GrayCard(tempArray[0], tempArray[1], tempArray[2]));
                }
                //Done
                else if (color.equals("brown")) {
                    int cost = Integer.parseInt(tempArray[3]);

                    ArrayList<String> resources = new ArrayList<String>();
                    tempArray = tempArray[2].split(",");
                    for (int i = 0; i < tempArray.length; i++)
                        resources.add(tempArray[i]);

                    tempArrayList.add(new BrownCard(color, name, cost, resources));
                }
                //Done
                else if (color.equals("green")) {
                    String science = tempArray[2];
                    String chain1 = tempArray[4];
                    String chain2 = tempArray[5];

                    ArrayList<String> cost = new ArrayList<String>();
                    tempArray = tempArray[3].split(",");
                    for (int i = 0; i < tempArray.length; i++)
                        cost.add(tempArray[i]);

                    tempArrayList.add(new GreenCard(color, name, cost, science, chain1, chain2));
                }
                //Done
                else if (color.equals("red")) {
                    int military = Integer.parseInt(tempArray[2]);
                    String chain = tempArray[4];

                    ArrayList<String> cost = new ArrayList<String>();
                    tempArray = tempArray[3].split(",");
                    for (int i = 0; i < tempArray.length; i++)
                        cost.add(tempArray[i]);

                    tempArrayList.add(new RedCard(color, name, cost, military, chain));
                }
                //Done
                else if (color.equals("yellow")) {
                    String chain = tempArray[3];

                    String[] tempArray2 = tempArray[2].split(",");
                    ArrayList<String> cost = new ArrayList<String>();
                    for (int i = 0; i < tempArray.length; i++) {
                        if(tempArray[i].equals("NA"))
                            break;
                        cost.add(tempArray[i]);
                    }

                    tempArray = tempArray[4].split(",");

                    String action = tempArray[0];

                    if (action.equals("discount")) {
                        String resource = tempArray[1];

                        boolean left = false;
                        if (tempArray[2].equals("true"))
                            left = true;
                        boolean right = false;
                        if (tempArray[3].equals("true"))
                            right = true;

                        tempArrayList.add(new YellowCard(color, name, cost, action, resource, left, right, chain));
                    }
                    //Done
                    else if (action.equals("resource")) {
                        ArrayList<String> resources = new ArrayList<String>();
                        String resource = tempArray[1];

                        tempArrayList.add(new YellowCard(color, name, cost, action, resource, chain));
                    }
                    else if (action.equals("guild")) {
                        boolean left = false;
                        if (tempArray[1].equals("true"))
                            left = true;
                        boolean right = false;
                        if (tempArray[2].equals("true"))
                            right = true;
                        boolean self = false;
                        if (tempArray[3].equals("true"))
                            self = true;

                        int coins = Integer.parseInt(tempArray[4]);
                        int victoryPoints = Integer.parseInt(tempArray[5]);
                        String awardColor = tempArray[6];

                        tempArrayList.add(new YellowCard(color, name, cost, action, left, right, self, coins, victoryPoints, chain, awardColor));
                    }
                }
                else if (color.equals("blue")) {
                    int victoryPoints = Integer.parseInt(tempArray[2]);
                    String chain = tempArray[4];

                    ArrayList<String> cost = new ArrayList<String>();
                    tempArray = tempArray[3].split(",");
                    for (int i = 0; i < tempArray.length; i++) {
                        if(tempArray[i].equals("NA"))
                            break;
                        cost.add(tempArray[i]);
                    }

                    tempArrayList.add(new BlueCard(color, name, cost, victoryPoints, chain));
                }
                //Done
                else if (color.equals("purple")) {
                    //Need to do
                }


                // "/" for "or"
                // "," for "and"
            }
            if(x == 0) {
                Collections.shuffle(tempArrayList);

                cards1 = new HashMap<Integer, ArrayList<Card>>();
                ArrayList<Card> tempHand = new ArrayList<Card>();
                for (int i = 0; i < 7; i++)
                    tempHand.add(tempArrayList.get(i));
                cards1.put(1, tempHand);

                System.out.println(cards1.get(1));

                tempHand = new ArrayList<Card>();
                for (int i = 7; i < 14; i++)
                    tempHand.add(tempArrayList.get(i));
                cards1.put(2, tempHand);

                System.out.println(cards1.get(2));

                tempHand = new ArrayList<Card>();
                for (int i = 14; i < 20; i++)
                    tempHand.add(tempArrayList.get(i));
                cards1.put(3, tempHand);

                System.out.println(cards1.get(3));
            }
            else if(x == 1) {
                Collections.shuffle(tempArrayList);

                cards2 = new HashMap<Integer, ArrayList<Card>>();
                ArrayList<Card> tempHand = new ArrayList<Card>();
                for (int i = 0; i < 7; i++)
                    tempHand.add(tempArrayList.get(i));
                cards2.put(1, tempHand);

                System.out.println(cards2.get(1));

                tempHand = new ArrayList<Card>();
                for (int i = 7; i < 14; i++)
                    tempHand.add(tempArrayList.get(i));
                cards2.put(2, tempHand);

                System.out.println(cards2.get(2));

                tempHand = new ArrayList<Card>();
                for (int i = 14; i < 20; i++)
                    tempHand.add(tempArrayList.get(i));
                cards2.put(3, tempHand);

                System.out.println(cards2.get(3));
            }
            else if(x == 2) {
                Collections.shuffle(tempArrayList);

                cards3 = new HashMap<Integer, ArrayList<Card>>();
                ArrayList<Card> tempHand = new ArrayList<Card>();
                for (int i = 0; i < 7; i++)
                    tempHand.add(tempArrayList.get(i));
                cards3.put(1, tempHand);

                System.out.println(cards3.get(1));

                tempHand = new ArrayList<Card>();
                for (int i = 7; i < 14; i++)
                    tempHand.add(tempArrayList.get(i));
                cards3.put(2, tempHand);

                System.out.println(cards3.get(2));

                tempHand = new ArrayList<Card>();
                for (int i = 14; i < 20; i++)
                    tempHand.add(tempArrayList.get(i));
                cards3.put(3, tempHand);

                System.out.println(cards3.get(3));
            }
            discard = new ArrayList<Card>();
        }
    }

    public ArrayList<Card> getHand(int val) {
        if(age == 1)
            return cards1.get(val);
        else if(age == 2)
            return cards2.get(val);
        return cards3.get(val);
    }
    public ArrayList<Card> getDiscard() {
        return discard;
    }
    public int getAge() {
        return age;
    }

    public void discard(Card card) {
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
}