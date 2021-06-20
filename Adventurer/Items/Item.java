package MazeAdventurer.Adventurer.Items;

public class Item
{
    private final int[] coord = new int[2];
    private final int weight;

    Item(int line, int column, int weight)
    {
        this.coord[0] = line;
        this.coord[1] = column;
        this.weight = weight;
    }

    public int[] getCoord()
    {
        return coord;
    }

    public int getValue()
    {
        return 0;
    }

    public int getWeight()
    {
        return weight;
    }
}
