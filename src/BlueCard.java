import java.util.ArrayList;

public class BlueCard extends Card
{
    private ArrayList<String> cost;
    private String prerequisite;
    private ArrayList<String> chains;
    private int victoryPoints;

    public BlueCard(String name, String color, ArrayList<String> cost, String prerequisite, ArrayList<String> chains, int victoryPoints) {
        super(name, color);
        this.cost = cost;
        this.prerequisite = prerequisite;
        this.chains = chains;
        this.victoryPoints = victoryPoints;
    }

    public ArrayList<String> getCost() {
        return cost;
    }
    public String getPrerequisite() {
        return prerequisite;
    }
    public ArrayList<String> getChains() {
        return chains;
    }
    public int getVictoryPoints() {
        return victoryPoints;
    }
}