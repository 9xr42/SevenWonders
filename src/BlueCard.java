import java.util.ArrayList;

public class BlueCard extends Card{
    private ArrayList<String> cost;
    private int victoryPoints;
    private String chain;

    public BlueCard(String color, String name, ArrayList<String> cost, int victoryPoints, String chain) {
        super(color, name);
        this.cost = cost;
        this.victoryPoints = victoryPoints;
        this.chain = chain;
    }

    public ArrayList<String> getCost() {
        return cost;
    }
    public int getVictoryPoints() {
        return victoryPoints;  
    }
    public String getChain() {
        return chain; 
    }
}

//hi
