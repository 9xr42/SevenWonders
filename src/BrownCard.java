import java.util.ArrayList;

public class BrownCard extends Card {
    private ArrayList<String> resources;
    private int cost;

    public BrownCard(String name, String color, ArrayList<String> resources, int cost) {
        super(name, color);
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