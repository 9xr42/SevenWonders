/**
 * The Gray Cards are the Manufactured Material cards of the game. There are only 3 in the game.
 * They only provide one resource
 */

public class GrayCard extends Card
{
    private String resource;

    public GrayCard(String name, String color, String resource)
    {
        super(name, color);
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}