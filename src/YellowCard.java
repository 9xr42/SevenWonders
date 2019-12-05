import java.util.ArrayList;

public class YellowCard extends Card {
    private ArrayList<String> cost;//Discount, Resource, Guild
    private String action;//Discount, Resource, Guild
    private ArrayList<String> resources;//Discount, Resource
    private boolean left;//Discount, Resource, Guild
    private boolean right;//Discount, Resource, Guild
    private boolean self; //Resource, Resource, Guild
    private int coins; // Guild
    private int victoryPoints; //Guild
    private String awardColor; //Guild
    private String chain; //Discount, Resource, Guild

    public YellowCard(String color, String name, ArrayList<String> cost, String action, ArrayList<String> resources, boolean left, boolean right, String chain) {
        super(color, name);
        this.cost = cost;
        this.action = action;
        this.resources = resources;
        this.left = left;
        this.right = right;
        this.chain = chain;
    } //Discount

    public YellowCard(String color, String name, ArrayList<String> cost, String action, ArrayList<String> resources, String chain) {
        super(color, name);
        this.cost = cost;
        this.action = action;
        this.resources = resources;
        this.chain = chain;
    }
    //Resource

    public YellowCard(String color, String name, ArrayList<String> cost, String action, boolean left, boolean right, boolean self, int coins, int victoryPoints, String chain, String awardColor) {
        super(color, name);
        this.cost = cost;
        this.action = action;
        this.left = left;
        this.right = right;
        this.self = self;
        this.coins = coins;
        this.victoryPoints = victoryPoints;
        this.chain = chain;
        this.awardColor = awardColor;
    }
    //Guild


    public ArrayList<String> getCost() {
        return cost;
    }
    public String getAction() {
        return action;
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
    public boolean isSelf() {
        return self;
    }
    public int getCoins() {
        return coins;
    }
    public int getVictoryPoints() {
        return victoryPoints;
    }
    public String getChain() {
        return chain;
    }
}