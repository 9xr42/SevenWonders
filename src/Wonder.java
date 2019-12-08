import java.util.ArrayList;

public class Wonder {
    private boolean hasBeenBuilt;

    private ArrayList<String> cost;
    private int victoryPoints;
    private String resource; //or science
    private int coins;
    private String action;
    private int military;

    public Wonder(String data) {
        String array[] = data.split("==");
        cost = new ArrayList<String>();
        resource = "";

        if(!array[0].equals("NA")) {
            String[] costArray = array[0].split(",");
            for(int i = 0; i < costArray.length; i++)
                cost.add(costArray[i]);
        }
        victoryPoints = Integer.parseInt(array[1]);
        if(!array[2].equals("NA"))
            resource = array[2];
        coins = Integer.parseInt(array[3]);
        action = array[4];
        military = Integer.parseInt(array[5]);
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
    public String getResource() {
        return resource;
    }
    public int getCoins() {
        return coins;
    }
    public String getAction() {
        return action;
    }
    public int getMilitary() {
        return military;
    }

    public void build() {
        hasBeenBuilt = true;
    }

    public String toString() {
        return action;
    }
}
