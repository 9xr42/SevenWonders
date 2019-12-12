import java.util.ArrayList;

public class PlayerBoard2 {
    private String name;
    private String resource;
    private Wonder2 wonder1;
    private Wonder2 wonder2;
    private Wonder2 wonder3;

    public PlayerBoard2(String name, Wonder2 wonder1, Wonder2 wonder2, Wonder2 wonder3, String resource) {
        this.name = name;
        this.wonder1 = wonder1;
        this.wonder2 = wonder2;
        this.wonder3 = wonder3;
        this.resource = resource;
    }

    public String getName() {
        return name;
    }
    public Wonder2 getWonder1() {
        return wonder1;
    }
    public Wonder2 getWonder2() {
        return wonder2;
    }
    public Wonder2 getWonder3() {
        return wonder3;
    }
    
    public ArrayList<String> wonderCost()
    {
    	if(!wonder1.isHasBeenBuilt())
    		return wonder1.getCost();
    	else if(!wonder2.isHasBeenBuilt())
    		return wonder2.getCost();
    	else
    		return wonder3.getCost();
    }
    
    public void buildWonder()
    {
    	if(!wonder1.isHasBeenBuilt())
    		wonder1.build();
    	else if(!wonder2.isHasBeenBuilt())
    		wonder2.build();
    	else if(!wonder3.isHasBeenBuilt())
    		wonder3.build();
    }
    
    public String getResource()
    {
    	return resource;
    }

    public int getPoints()
    {
        int points = 0;
        if(wonder1.isHasBeenBuilt())
            points += wonder1.getPoints();
        if(wonder2.isHasBeenBuilt())
            points += wonder2.getPoints();
       if(wonder3.isHasBeenBuilt())
           points +=wonder3.getPoints();
       return points;

    }

}
