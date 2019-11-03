/**
 * The Brown Cards are the raw material cards of the game
 * They build the structures that allow for the procurement of materials.
 * Ex: Wood
 */

import java.util.ArrayList;

public class BrownCard extends Card
{
    private ArrayList<String> resources; // what resources they give; usually 1-2
    private int cost;   // all brown cards cost only coin money

    public BrownCard(String name, String color, ArrayList<String> resources, int cost)
    {
        super(name, color);
        this.resources = resources;
        this.cost = cost;
    }

    public ArrayList<String> getResources()
    {
        return resources;
    }
    public int getCost()
    {
        return cost;
    }
}