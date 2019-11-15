import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Deck {
    private HashMap<Integer, ArrayList<Card>> cards;
    private ArrayList<Card> discard;

    public Deck() throws IOException {
        ArrayList<Card> tempArrayList = new ArrayList<Card>();
        Scanner textFileScan = new Scanner(new File("age1Cards.txt"));
        String[] tempArray = new String[7];

        discard = new ArrayList<Card>();

        while(textFileScan.hasNextLine()) {
            tempArray = textFileScan.nextLine().split("|");
            if(tempArray[0].equals("gray")) {
                tempArrayList.add(new GrayCard(tempArray[0], tempArray[1], tempArray[2]));
            }
            else if(tempArray[0].equals("brown")) {
                String color = tempArray[0];
                String name = tempArray[1];
                int cost = Integer.parseInt(tempArray[3]);
                ArrayList<String> resources = new ArrayList<String>();
                resources.add(tempArray[2]);
                tempArrayList.add(new BrownCard(color, name, cost, resources));
            }
            else if(tempArray[0].equals("green")) {
                String color = tempArray[0];
                String name = tempArray[1];
                String science = tempArray[2];
                ArrayList<String> cost = new ArrayList<String>();
                cost.add(tempArray[3]);
                String chain1 = tempArray[4];
                String chain2 = tempArray[5];

                tempArrayList.add(new GreenCard(color, name, cost, science, chain1, chain2));
            }
            else if(tempArray[0].equals("red")) {
                String color = tempArray[0];
                String name = tempArray[1];
                int military = Integer.parseInt(tempArray[3]);
                String chain1 = tempArray[5];
                String chain2 = tempArray[6];

                ArrayList<String> cost = new ArrayList<String>();
                tempArray = tempArray[3].split("&");
                for(int i = 0; i < tempArray.length; i++)
                    cost.add(tempArray[i]);

                tempArrayList.add(new RedCard(color, name, cost, military, chain1, chain2));
            }
            else if(tempArray[0].equals("yellow")) {

            }
            else if(tempArray[0].equals("blue")) {
                String color = tempArray[0];
                String name = tempArray[1];
                int victoryPoints = Integer.parseInt(tempArray[3]);
                String chain1 = tempArray[5];
                String chain2 = tempArray[6];

                ArrayList<String> cost = new ArrayList<String>();
                tempArray = tempArray[3].split("&");
                for(int i = 0; i < tempArray.length; i++)
                    cost.add(tempArray[i]);

                tempArrayList.add(new BlueCard(color, name, cost, victoryPoints, chain1, chain2));
            }
        }
    }

    public HashMap<Integer, ArrayList<Card>> getCards() {
        return cards;
    }
    public ArrayList<Card> getDiscard() {
        return discard;
    }

    public void discard(Card card) {
        discard.add(card);
    }
    public ArrayList<Card> getHand(int val) {
        return cards.get(val);
    }

    public void incrementAge() {

    }
}
