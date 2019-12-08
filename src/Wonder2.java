import java.util.ArrayList;

public class Wonder2 {
    private boolean hasBeenBuilt;
    private int points;
    private ArrayList<String> cost;
    private String effect;

    public Wonder2(boolean hasBeenBuilt, String cost, int points, String effect)
    {
        this.hasBeenBuilt = hasBeenBuilt;
        String[] str = cost.split(" ");
        this.cost = new ArrayList<String>();
        for(String i: str)
            this.cost.add(i);
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
    
    public void build()
    {
    	hasBeenBuilt = true;
    }

    public String toString()
    {
        if(hasBeenBuilt)
            return cost + " - built";
        return cost + " - not built";
    }
}