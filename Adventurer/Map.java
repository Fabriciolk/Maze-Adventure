package MazeAdventurer.Adventurer;

import MazeAdventurer.Adventurer.Path.Path;
import MazeAdventurer.Environment.Maze;
import MazeAdventurer.Adventurer.Path.Step;

public class Map
{
    /*
        This class represents the map where the adventurer will check
        to go around the positions of maze, registering all kind of paths
        (shortest, longest, valuest and fastest).
    */

    private final Maze maze;
    public Path currPath;
    public Path shortest;
    public Path longest;
    public Path valuable;
    public Path fastest;

    public Map(Maze maze)
    {
        this.maze = maze;
        this.currPath = new Path(maze.getItems());
    }

    // This method returns a copy of a specific path, including all
    // steps and collected items taken.

    public Path copyOf(Path p)
    {
        Path copy = new Path();
        copy.items = p.items;
        copy.collectedItems = new boolean[p.items.length];

        copy.totalCollectedItems = p.totalCollectedItems;
        copy.totalValue = p.totalValue;

        Step aux = p.firstStep;

        while(aux != null)
        {
            copy.addStep(aux.getCoord()[0], aux.getCoord()[1]);

            for(int i = 0; i < p.items.length; i++)
            {
                if(p.items[i].getCoord()[0] == aux.getCoord()[0] && p.items[i].getCoord()[1] == aux.getCoord()[1])
                {
                    copy.totalWeight += p.items[i].getWeight();
                    copy.collectedItems[i] = true;
                }
            }

            aux = aux.next;
        }

        copy.totalTime--; // Decreases, because the initial position is not a step.
        return copy;
    }

    public Maze getMaze()
    {
        return maze;
    }
}
