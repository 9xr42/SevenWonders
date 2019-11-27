import java.util.ArrayList;

public class Wonder {
    private boolean hasBeenBuilt;
    private int points;
    private ArrayList<String> cost;

    public Wonder(boolean hasBeenBuilt, ArrayList<String> cost)
    {
        this.hasBeenBuilt = hasBeenBuilt;
        this.cost = cost;
    }

    public int getPoints()
    {
        return points;
    }


    public ArrayList<String> getCost() {
        return cost;
    }

    public boolean isHasBeenBuilt() {
        return hasBeenBuilt;
    }

    public String toString()
    {
        if(hasBeenBuilt)
            return cost + " - built";
        return cost + " - not built";
    }
}
