public class GrayCard extends Card {
    private String resource;

    public GrayCard(String color, String name, String resource) {
        super(color, name);
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
//Done