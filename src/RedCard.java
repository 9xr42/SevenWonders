import java.util.ArrayList;

public class RedCard extends Card {
    private ArrayList<String> cost;
    private int military;
    private String chain1;
    private String chain2;

    public RedCard(String color, String name, ArrayList<String> cost, int military, String chain1, String chain2) {
        super(color, name);
        this.cost = cost;
        this.military = military;
        this.chain1 = chain1;
        this.chain2 = chain2;
    }

    public ArrayList<String> getCost() {
        return cost;
    }
    public int getMilitary() {
        return military;
    }
    public String getChain1() {
        return chain1;
    }
    public String getChain2() {
        return chain2;
    }
}