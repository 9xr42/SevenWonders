public class GrayCard extends Card {
    private String resource;

    public GrayCard(String name, String color, String resource) {
        super(name, color);
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}