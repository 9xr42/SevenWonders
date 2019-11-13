import java.util.ArrayList;

public class GreenCard extends Card {
    private ArrayList<String> cost;
    private String scinece;
    private String chain1;
    private String chain2;

    public GreenCard(String color, String name, ArrayList<String> cost, String scinece, String chain1, String chain2) {
        super(color, name);
        this.cost = cost;
        this.scinece = scinece;
        this.chain1 = chain1;
        this.chain2 = chain2;
    }

    public ArrayList<String> getCost() {
        return cost;
    }
    public String getScinece() {
        return scinece;
    }
    public String getChain1() {
        return chain1;
    }
    public String getChain2() {
        return chain2;
    }
}