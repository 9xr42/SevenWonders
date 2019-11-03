import java.util.ArrayList;

public class PurpleCard {
    private ArrayList<String> cost;
    private boolean isScience;
    private boolean leftAndRight;
    private boolean incluesSelf;
    private ArrayList<String> sciences;
    private int victoryPoints;

    public PurpleCard(ArrayList<String> cost, boolean isScience, boolean leftAndRight, boolean incluesSelf, ArrayList<String> sciences, int victoryPoints) {
        this.cost = cost;
        this.isScience = isScience;
        this.leftAndRight = leftAndRight;
        this.incluesSelf = incluesSelf;
        this.sciences = sciences;
        this.victoryPoints = victoryPoints;
    }

    public ArrayList<String> getCost() {
        return cost;
    }
    public boolean isScience() {
        return isScience;
    }
    public boolean isLeftAndRight() {
        return leftAndRight;
    }
    public boolean isIncluesSelf() {
        return incluesSelf;
    }
    public ArrayList<String> getSciences() {
        return sciences;
    }
    public int getVictoryPoints() {
        return victoryPoints;
    }
}