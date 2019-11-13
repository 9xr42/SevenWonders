import java.util.ArrayList;

public class BrownCard extends Card {
    private ArrayList<String> resources;
    private int cost;

    public BrownCard(String color, String name, ArrayList<String> resources, int cost) {
        super(color, name);
        this.resources = resources;
        this.cost = cost;
    }

    public ArrayList<String> getResources() {
        return resources;
    }
    public int getCost() {
        return cost;
    }
}