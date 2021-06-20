package MazeAdventurer.Adventurer.Items;

public class Gem extends Item
{
    private static final int space = 4;
    protected static int value = 7;
    private final String color;

    public Gem(int line, int column, int weight, String color)
    {
        super(line, column, weight);
        this.color = color;
    }

    public int getSpace()
    {
        return space;
    }

    public int getValue()
    {
        return value;
    }

    public String getColor()
    {
        return color;
    }
}
