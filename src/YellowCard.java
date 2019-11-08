import java.util.ArrayList;

public class YellowCard extends Card {
    private ArrayList<String> cost;
    private ArrayList<String> chains;
    private String action;
    private String cardColor;
    private int coins;
    private int victoryPoints;
    private ArrayList<String> resources;
    private boolean left;
    private boolean right;

    public YellowCard(String name, String color, ArrayList<String> cost, ArrayList<String> chains, String action, String cardColor, int coins, int victoryPoints, ArrayList<String> resources, boolean left, boolean right) {
        super(name, color);
        this.cost = cost;
        this.chains = chains;
        this.action = action;
        this.cardColor = cardColor;
        this.coins = coins;
        this.victoryPoints = victoryPoints;
        this.resources = resources;
        this.left = left;
        this.right = right;
    }

    public ArrayList<String> getCost() {
        return cost;
    }
    public ArrayList<String> getChains() {
        return chains;
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
}