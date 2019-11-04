import java.util.ArrayList;

public class GreenCard extends Card {
    private ArrayList<String> cost;
    private ArrayList<String> chains;
    private String scinece;

    public GreenCard(String name, String color, ArrayList<String> cost, ArrayList<String> chains, String scinece) {
        super(name, color);
        this.cost = cost;
        this.prerequisite = prerequisite;
        this.chains = chains;
        this.scinece = scinece;
    }

    public ArrayList<String> getCost() {
        return cost;
    }
    public ArrayList<String> getChains() {
        return chains;
    }
    public String getScinece() {
        return scinece;
    }
}
