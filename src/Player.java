import java.util.ArrayList;
import java.util.TreeMap;

public class Player {
    private PlayerBoard playerBoard;
    private ArrayList<Card> hand;
    private int money;
    private int playerNumber;
    private int positiveWarPoints;
    private int negativeWarPoints;

    public Player(PlayerBoard playerBoard, int playerNumber) {
        this.playerBoard = playerBoard;
        this.hand = new ArrayList<Card>();
        this.money = 5;
        this.playerNumber = playerNumber;
        this.positiveWarPoints = 0;
        this.negativeWarPoints = 0;
    }

    public PlayerBoard getPlayerBoard() {
        return playerBoard;
    }
    public ArrayList<Card> getHand() {
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
    public int getNegativeWarPoints() {
        return negativeWarPoints;
    }

    public ArrayList<Card> getColorCards(String color)
    {
        ArrayList<Card> colorCards = new ArrayList<Card>();
        for(Card card: hand) {
            if(card.getColor().equals(color))
                colorCards.add(card);
        }
        return colorCards;
    }
    public TreeMap<String, Integer> getResources()
    {
        TreeMap<String, Integer> resources = new TreeMap<String, Integer>();
        ArrayList<String> temp = new ArrayList<String>();
        for(Card card: getColorCards("brown"))
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

        for(Card card: getColorCards("gray"))
            temp.add(card.getResources().get(0));
        temp.add(playerBoard.getResource());

        for(String i: temp)
        {
            if(resources.get(i)==null)
                resources.put(i,1);
            else
                resources.put(i, resources.get(i)+1);
        }
        return resources;
    }

    public void addCard(Card card) {
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

    public int getScore() {
        int score = 0;
        score += getPositiveWarPoints();
        score -= getNegativeWarPoints();
        score += getMoney()/3;
        score += getPlayerBoard().getVictoryPoints();
        ArrayList<Card> blue = new ArrayList<Card>();
        ArrayList<Card> green = new ArrayList<Card>();
        ArrayList<Card> yellow = new ArrayList<Card>();
        ArrayList<Card> purple = new ArrayList<Card>();
        for(Card card: hand)
        {
            if(card.getColor().equals("blue"))
                blue.add(card);
            else if(card.getColor().equals("green"))
                green.add(card);
            else if(card.getColor().equals("yellow")) {
                if(card.getAction().equals("guild"))
                    yellow.add(card);
            }
            else if(card.getColor().equals("purple"))
                purple.add(card);
        }

        for(Card card: blue)
            score += card.getVictoryPoints();

        int gear = 0;
        int compass = 0;
        int tablet = 0;
        for(Card card: green)
        {
            if(card.getScience().equals("gear"))
                gear++;
            else if(card.getScience().equals("compass"))
                compass++;
            else
                tablet++;
        }
        score += gear*gear + compass*compass + tablet*tablet;

        for(Card card: yellow) {
            score += getColorCards(card.getAwardColor()).size() * card.getVictoryPoints();
        }
        for(Card card: purple)
            score += getColorCards(card.getAwardColor()).size() * card.getVictoryPoints();

        return score;
    }
}
