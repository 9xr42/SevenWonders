import java.util.ArrayList;

public class YellowCard extends Card {
    private ArrayList<String> cost;
    private String action;
    private String cardColor;
    private int coins;
    private int victoryPoints;
    private ArrayList<String> resources;
    private boolean left;
    private boolean right;
    String chain1 = "";
    String chain2 = "";

    public YellowCard(String color, String name, ArrayList<String> cost, String action, String cardColor, int coins, int victoryPoints, ArrayList<String> resources, boolean left, boolean right, String chain1, String chain2) {
        super(color, name);
        this.cost = cost;
        this.action = action;
        this.cardColor = cardColor;
        this.coins = coins;
        this.victoryPoints = victoryPoints;
        this.resources = resources;
        this.left = left;
        this.right = right;
        this.chain1 = chain1;
        this.chain2 = chain2;
    }

    public ArrayList<String> getCost() {
        return cost;
    }
    public String getAction() {
        return action;
    }
    public String getCardColor() {
        return cardColor;
    }
    public int getCoins() {
        return coins;
    }
    public int getVictoryPoints() {
        return victoryPoints;
    }
    public ArrayList<String> getResources() {
        return resources;
    }
    public boolean isLeft() {
        return left;
    }
    public boolean isRight() {
        return right;
    }
    public String getChain1() {
        return chain1;
    }
    public String getChain2() {
        return chain2;
    }
}