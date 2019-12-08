public class PlayerBoard {
    private String name;
    private String resource;
    private Wonder wonder1;
    private Wonder wonder2;
    private Wonder wonder3;

    public PlayerBoard(String name, String resource, Wonder wonder1, Wonder wonder2, Wonder wonder3) {
        this.name = name;
        this.resource = resource;
        this.wonder1 = wonder1;
        this.wonder2 = wonder2;
        this.wonder3 = wonder3;
    }

    public String getName() {
        return name;
    }
    public String getResource() {
        return resource;
    }
    public Wonder getWonder1() {
        return wonder1;
    }
    public Wonder getWonder2() {
        return wonder2;
    }
    public Wonder getWonder3() {
        return wonder3;
    }

    public int getVictoryPoints()
    {
        int points = 0;
        if(wonder1.isHasBeenBuilt())
            points += wonder1.getVictoryPoints();
        if(wonder2.isHasBeenBuilt())
            points += wonder2.getVictoryPoints();
        if(wonder3.isHasBeenBuilt())
            points +=wonder3.getVictoryPoints();
        return points;

    }
}
