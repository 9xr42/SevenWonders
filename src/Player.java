import java.util.ArrayList;

public class Player {
    private PlayerBoard playerBoard;
    private ArrayList<Card> hand;
    private int money;
    private int playerNumber;
    private int positiveWarPoints;
    private int negativeWarPoints;

    public Player(PlayerBoard playerBoard, ArrayList<Card> hand, int money, int playerNumber) {
        this.playerBoard = playerBoard;
        this.hand = hand;
        this.money = money;
        this.playerNumber = playerNumber;
        positiveWarPoints = 0;
        negativeWarPoints = 0;
    }

    public PlayerBoard getPlayerBoard() {
        return playerBoard;
    }
    
    public String getBoard()
    {
    	return playerBoard.getName();
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

    public int getNegativeWarPoints()
    {
        return negativeWarPoints;
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

    public void playCard(int card)
    {

    }


    public int getScore() {
        int score = 0;
        score += getPositiveWarPoints();
        score-= getNegativeWarPoints();
        score += getMoney()/3;
        score += getPlayerBoard().getPoints();
        ArrayList<BlueCard> blue = new ArrayList<BlueCard>();
        ArrayList<GreenCard> green = new ArrayList<GreenCard>();
        ArrayList<YellowCard> yellow = new ArrayList<YellowCard>();
        ArrayList<PurpleCard> purple = new ArrayList<PurpleCard>();
        for(Card card: hand)
        {
            if(card.getColor().equals("blue"))
                blue.add((BlueCard)card);
            else if(card.getColor().equals("green"))
                green.add((GreenCard)card);
            else if(card.getColor().equals("yellow"))
                yellow.add((YellowCard)card);
            else if(card.getColor().equals("purple"))
                purple.add((PurpleCard)card);
        }

        for(BlueCard card: blue)
            score += card.getVictoryPoints();
        for(GreenCard card: green)
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
        for(YellowCard card: yellow)
            score += card.getVictoryPoints();
        for(PurpleCard card: purple)
            score += card.getVictoryPoints();

        return score;
    }
}
