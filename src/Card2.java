import java.util.ArrayList;

public class Card2 {
    private String color;
    private String name;
    private ArrayList<String> resources;
    private int coinCost;
    private ArrayList<String> resourceCost;
    private int victoryPoints;
    private int military;
    private String science;

    private String action;
    private boolean left;
    private boolean right;
    private boolean self;
    private int coins;
    private String awardColor;

    private String chain1;
    private String chain2;

    public Card2(String color, String name, ArrayList<String> resources, int coinCost, ArrayList<String> resourceCost, int victoryPoints, int military, String science, String action, boolean left, boolean right, boolean self, int coins, String awardColor, String chain1, String chain2) {
        this.color = color;
        this.name = name;
        this.resources = resources;
        this.coinCost = coinCost;
        this.resourceCost = resourceCost;
        this.victoryPoints = victoryPoints;
        this.military = military;
        this.science = science;
        this.action = action;
        this.left = left;
        this.right = right;
        this.self = self;
        this.coins = coins;
        this.awardColor = awardColor;
        this.chain1 = chain1;
        this.chain2 = chain2;
    }
}