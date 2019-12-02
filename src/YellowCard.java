import java.util.ArrayList;

public class YellowCard extends Card {
    private ArrayList<String> cost;//
    private String action;//
    private ArrayList<String> resources;//
    private boolean left;//
    private boolean right;//
    private String chain; //

    public YellowCard(String color, String name, ArrayList<String> cost, String action, ArrayList<String> resources, boolean left, boolean right, String chain) {
        super(color, name);
        this.cost = cost;
        this.action = action;
        this.resources = resources;
        this.left = left;
        this.right = right;
        this.chain = chain;
    }

    public ArrayList<String> getCost() {
        return cost;
    }
    public String getAction() {
        return action;
    }
    public ArrayList<String> getResources() {
        return resources;
    }
    public boolean isLeft() {
        return left;
    }
    public boolean isRight() {
        return right;
    }
    public String getChain() {
        return chain;
    }
}