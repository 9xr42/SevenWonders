/**
 * This is an abstract class with the basic properties included in all cards
 * Used to create a structure to organize the cards
 * Done by: Robert Way
 */

public abstract class Card
{
    private String name;
    private String color;

    public Card(String name, String color)
    {
        this.name = name;
        this.color = color;
    }

    public String getName()
    {
        return name;
    }

    public String getColor()
    {
        return color;
    }
}