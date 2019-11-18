import java.util.ArrayList;

public class YellowCard extends Card {
    private ArrayList<String> cost;
    private String action;
    private ArrayList<String> resources;
    private int coins;
    private boolean left;
    private boolean right;
    private String awardColor;
    private int victoryPoints;
    private String chain1;
    private String chain2;

    public YellowCard(String color, String name, ArrayList<String> cost, String action, ArrayList<String> resources, int coins, boolean left, boolean right, String awardColor, int victoryPoints, String chain1, String chain2) {
        super(color, name);
        this.cost = cost;
        this.action = action;
        this.resources = resources;
        this.coins = coins;
        this.left = left;
        this.right = right;
        this.awardColor = awardColor;
        this.victoryPoints = victoryPoints;
        this.chain1 = chain1;
        this.chain2 = chain2;
    }

    public YellowCard(String color, String name, String action, ArrayList<String> resources, int coins, boolean left, boolean right, String chain1) {
        super(color, name);
        this.action = action;
        this.resources = resources;
        this.coins = coins;
        this.left = left;
        this.right = right;
        this.chain1 = chain1;

        cost = new ArrayList<String>();
        awardColor = "";
        victoryPoints = 0;
        chain2 = "";
    }

    public ArrayList<String> getCost() {
        return cost;
    }
    public String getAction() {
        return action;
    }
    public ArrayList<String> getResources() {
        return resources;
    }
    public int getCoins() {
        return coins;
    }
    public boolean isLeft() {
        return left;
    }
    public boolean isRight() {
        return right;
    }
    public String getAwardColor() {
        return awardColor;
    }
    public int getVictoryPoints() {
        return victoryPoints;
    }
    public String getChain1() {
        return chain1;
    }
    public String getChain2() {
        return chain2;
    }
}