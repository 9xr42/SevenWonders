import java.util.ArrayList;

public class Player {
    private PlayerBoard playerBoard;
    private ArrayList<Card> hand;
    private int money;
    private int playerNumber;
    private int positiveWarPoints;
    private int negativeWarPoints;

    public Player(PlayerBoard playerBoard, ArrayList<Card> hand, int money, int playerNumber, int positiveWarPoints) {
        this.playerBoard = playerBoard;
        this.hand = hand;
        this.money = money;
        this.playerNumber = playerNumber;
        this.positiveWarPoints = positiveWarPoints;
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
        return -1;
    }
}
