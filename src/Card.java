public abstract class Card {
    private String name;
    private String color;

    public Card(String color, String name) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}
//Done