import java.util.ArrayList;

public class YellowCard extends Card {
    private ArrayList<String> cost;//Discount, Resource
    private String action;//Discount, Resource
    private ArrayList<String> resources;//Discount, Resource
    private boolean left;//Discount, Resource
    private boolean right;//Discount, Resource
    private boolean self; //Resource, Resource
    private String chain; //Discount, Resource

    public YellowCard(String color, String name, ArrayList<String> cost, String action, ArrayList<String> resources, boolean left, boolean right, String chain) {
        super(color, name);
        this.cost = cost;
        this.action = action;
        this.resources = resources;
        this.left = left;
        this.right = right;
        this.chain = chain;
    } //Discount

    public YellowCard(String color, String name, ArrayList<String> cost, String action, ArrayList<String> resources, String chain) {
        super(color, name);
        this.cost = cost;
        this.action = action;
        this.resources = resources;
        this.chain = chain;
    }

    //Resource


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