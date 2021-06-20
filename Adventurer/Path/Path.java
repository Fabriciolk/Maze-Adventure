package MazeAdventurer.Adventurer.Path;

import MazeAdventurer.Adventurer.Items.Item;

public class Path
{
    /*
        This class represents all steps taken on a specific path make by
        the adventurer, organized in a doubly linked list. Further, it contains
        all the collected items by the adventurer until at moment and access all
        existing items on maze.
    */

    public Item[] items;
    public boolean[] collectedItems;
    public int totalCollectedItems;

    public double totalTime;
    public int totalValue;
    public int totalWeight;
    public int totalSteps;

    public Step firstStep;
    public Step lastStep;

    public Path(Item[] items)
    {
        this.items = items;
        this.collectedItems = new boolean[items.length];
    }

    public Path()
    {
        this.items = null;
    }

    // Add a new step on path's final

    public void addStep(int x, int y)
    {
        Step step = new Step(x, y);

        if(firstStep == null)
        {
            firstStep = step;
            lastStep = step;
            step.previous = firstStep;
        }
        else
        {
            step.previous = lastStep;
            lastStep.next = step;
            lastStep = step;
        }

        totalSteps++;
        totalTime += Math.pow(1 + totalWeight/10.0, 2);
    }

    // Remove the last step taken from the path

    public void removeStep()
    {
        if(firstStep != null)
        {
            if(firstStep.next == null)
            {
                firstStep = null;
                lastStep = null;
            }
            else
            {
                lastStep = lastStep.previous;
                lastStep.next = null;
            }
        }

        totalSteps--;
        totalTime -= Math.pow(1 + totalWeight/10.0, 2);
    }

    // Add a item on collected items list if there is a item on coordinate (x, y).

    public void addItem(Item item)
    {
        if(item != null)
        {
            totalCollectedItems++;
            totalValue += item.getValue();
            totalWeight += item.getWeight();

            for(int i = 0; i < items.length; i++)
            {
                if(items[i] == item)
                {
                    collectedItems[i] = true;
                }
            }
        }
    }

    // Remove a item from collected items list if there is a item on coordinate (x, y)

    public void removeItem(int x, int y)
    {
        for(int i = 0; i < items.length; i++)
        {
            if(items[i].getCoord()[0] == x && items[i].getCoord()[1] == y)
            {
                totalCollectedItems--;
                totalValue -= items[i].getValue();
                totalWeight -= items[i].getWeight();
                collectedItems[i] = false;
            }
        }
    }
}