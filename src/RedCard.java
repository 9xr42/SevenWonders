import java.util.ArrayList;

public class RedCard extends Card {
    private ArrayList<String> cost;
    private ArrayList<String> chains;
    private int military;

    public RedCard(String name, String color, ArrayList<String> cost, ArrayList<String> chains, int military) {
        super(name, color);
        this.cost = cost;
        this.prerequisite = prerequisite;
        this.chains = chains;
        this.military = military;
    }

    public ArrayList<String> getCost() {
        return cost;
    }
    public ArrayList<String> getChains() {
        return chains;
    }
    public int getMilitary() {
        return military;
    }
}
