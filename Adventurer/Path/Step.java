package MazeAdventurer.Adventurer.Path;

public class Step
{
    /*
        This class represents the step taken by the adventurer on maze.
    */

    private final int[] coord = new int[2];
    public Step previous;
    public Step next;

    Step(int x, int y)
    {
        coord[0] = x;
        coord[1] = y;
    }

    public int[] getCoord()
    {
        return coord;
    }
}
