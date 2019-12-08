import java.util.ArrayList;

public class Card {
    private String color; //0
    private String name; //1
    private ArrayList<String> resources; //2
    private int coinCost; //3
    private ArrayList<String> resourceCost; //4
    private int victoryPoints; //5
    private int military; //6
    private String science; //7

    private String action; //8
    private boolean left; //9
    private boolean right; //10
    private boolean self; //11
    private int coins; //12
    private String awardColor; //13

    private String chain1; //14
    private String chain2; //15

    public Card(String color, String name, ArrayList<String> resources, int coinCost, ArrayList<String> resourceCost, int victoryPoints, int military, String science, String action, boolean left, boolean right, boolean self, int coins, String awardColor, String chain1, String chain2) {
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

    public String toString() {
        return color + " " + name;
    }
}
