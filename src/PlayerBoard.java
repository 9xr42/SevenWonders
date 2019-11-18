public class PlayerBoard {
    private String name;
    private Wonder wonder1;
    private Wonder wonder2;
    private Wonder wonder3;

    public PlayerBoard(String name, Wonder wonder1, Wonder wonder2, Wonder wonder3) {
        this.name = name;
        this.wonder1 = wonder1;
        this.wonder2 = wonder2;
        this.wonder3 = wonder3;
    }

    public String getName() {
        return name;
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
}