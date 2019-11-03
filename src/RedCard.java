import java.util.ArrayList;

public class RedCard extends Card {
    private ArrayList<String> cost;
    private String prerequisite;
    private ArrayList<String> chains;
    private int military;

    public RedCard(String name, String color, ArrayList<String> cost, String prerequisite, ArrayList<String> chains, int military) {
        super(name, color);
        this.cost = cost;
        this.prerequisite = prerequisite;
        this.chains = chains;
        this.military = military;
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
    public int getMilitary() {
        return military;
    }
}