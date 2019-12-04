import java.util.ArrayList;

public class BrownCard extends Card {
    private int cost;
    private ArrayList<String> resources;

    public BrownCard(String color, String name, int cost, ArrayList<String> resources) {
        super(color, name);
        this.cost = cost;
        this.resources = resources;
    }

    public int getCost() {
        return cost;
    }

    public ArrayList<String> getResources() {
        return resources;
    }
}
//done