import java.util.ArrayList;

public class Wonder {
    private boolean hasBeenBuilt;

    private ArrayList<String> cost;
    private int victoryPoints;
    private String resouce;
    private int coins;
    private int action;
    private int military;

    public Wonder(ArrayList<String> cost, int victoryPoints, String resouce, int coins, int action, int military) {
        this.cost = cost;
        this.victoryPoints = victoryPoints;
        this.resouce = resouce;
        this.coins = coins;
        this.action = action;
        this.military = military;
    }

    public boolean isHasBeenBuilt() {
        return hasBeenBuilt;
    }
    public ArrayList<String> getCost() {
        return cost;
    }
    public int getVictoryPoints() {
        return victoryPoints;
    }
    public String getResouce() {
        return resouce;
    }
    public int getCoins() {
        return coins;
    }
    public int getAction() {
        return action;
    }
    public int getMilitary() {
        return military;
    }

    public void build() {
        hasBeenBuilt = true;
    }
}
