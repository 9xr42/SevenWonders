import java.util.ArrayList;

public class BlueCard extends Card
{
    private ArrayList<String> cost;
    private ArrayList<String> chains;
    private int victoryPoints;

    public BlueCard(String name, String color, ArrayList<String> cost, ArrayList<String> chains, int victoryPoints) {
        super(name, color);
        this.cost = cost;
        this.chains = chains;
        this.victoryPoints = victoryPoints;
    }

    public ArrayList<String> getCost() {
        return cost;
    }
    public ArrayList<String> getChains() {
        return chains;
    }
    public int getVictoryPoints() {
        return victoryPoints;
    }
}
