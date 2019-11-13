import java.util.ArrayList;

public class BlueCard extends Card{
    private ArrayList<String> cost;
    private int victoryPoints;
    private String chain1;
    private String chain2;

    public BlueCard(String color, String name, ArrayList<String> cost, int victoryPoints, String chain1, String chain2) {
        super(color, name);
        this.cost = cost;
        this.victoryPoints = victoryPoints;
        this.chain1 = chain1;
        this.chain2 = chain2;
    }

    public ArrayList<String> getCost() {
        return cost;
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