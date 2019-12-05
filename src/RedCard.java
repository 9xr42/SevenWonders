
import java.util.ArrayList;

public class RedCard extends Card {
    private ArrayList<String> cost;
    private int military;
    private String chain;

    public RedCard(String color, String name, ArrayList<String> cost, int military, String chain) {
        super(color, name);
        this.cost = cost;
        this.military = military;
        this.chain = chain;
    }

    public ArrayList<String> getCost() {
        return cost;
    }
    public int getMilitary() {
        return military;
    }
    public String getChain() {
        return chain;
    }
}
//Done