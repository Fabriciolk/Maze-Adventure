package Adventurer;

import Adventurer.Items.Item;

import java.util.Arrays;

public class Adventurer
{
    /*
        This class represents the adventurer. As long as he/she walks on maze,
        each step is registered and if there is a item on that position, he/she
        puts that on backpack, increasing its value and weigth and the time to walk
        to next position.
    */

    private final String name;
    private final int[] initCoord = new int[2];
    public Map map;
    public Backpack backpack;

    public Adventurer(String name, int initX, int initY)
    {
        this.name = name;
        this.initCoord[0] = initX;
        this.initCoord[1] = initY;
    }

    // This method starts the exploration on maze calling the recursive method exploreMapRecursive.

    public void exploreMaze()
    {
        if(map == null)
        {
            System.out.println("Adventure doesn't have a map to help on his exploration.");
            return;
        }

        exploreMapRecursive(map.getMaze().getMaze(), initCoord[0], initCoord[1]);
    }

    // This method runs on maze in a trial and error approach, where will use recursion for
    // all four directions (left, up, right, down) on each position. In this way, each recursion
    // means each step, verifying if there is a item, if will be the final position and if will
    // be a wall. Tried a specific path,

    private void exploreMapRecursive(boolean[][] maze, int x, int y)
    {
        // Register step-taken (True) and adds the item and the step itself on currently path.
        maze[x][y] = true;
        Item itemToAdd = checkItem(x, y);
        map.currPath.addStep(x, y);
        map.currPath.addItem(itemToAdd);
        backpack.addItem(itemToAdd);

        if(x == map.getMaze().getEnd()[0] && y == map.getMaze().getEnd()[1]) // Reached target coordinate
        {
            // Store all best paths until the moment
            if(map.shortest == null || map.currPath.totalSteps < map.shortest.totalSteps) map.shortest = map.copyOf(map.currPath);
            if(map.longest == null || map.currPath.totalSteps > map.longest.totalSteps) map.longest = map.copyOf(map.currPath);
            if(map.valuable == null || map.currPath.totalValue > map.valuable.totalValue) map.valuable = map.copyOf(map.currPath);
            if(map.fastest == null || map.currPath.totalTime < map.fastest.totalTime) map.fastest = map.copyOf(map.currPath);
        }
        else
        {
            // Go left
            if(y - 1 >= 0 && !maze[x][y - 1])
            {
                exploreMapRecursive(maze, x, y - 1);
                maze[x][y - 1] = false;
                map.currPath.removeItem(x, y - 1);
                map.currPath.removeStep();
                Item itemToRemove = checkItem(x, y - 1);
                backpack.removeItem(itemToRemove);
            }

            // Go up
            if(x - 1 >= 0 && !maze[x - 1][y])
            {
                exploreMapRecursive(maze, x - 1, y);
                maze[x - 1][y] = false;
                map.currPath.removeItem(x - 1, y);
                map.currPath.removeStep();
                Item itemToRemove = checkItem(x - 1, y);
                backpack.removeItem(itemToRemove);
            }

            // Go right
            if(y + 1 < maze[0].length && !maze[x][y + 1])
            {
                exploreMapRecursive(maze, x, y + 1);
                maze[x][y + 1] = false;
                map.currPath.removeItem(x, y + 1);
                map.currPath.removeStep();
                Item itemToRemove = checkItem(x, y + 1);
                backpack.removeItem(itemToRemove);
            }

            // Go down
            if(x + 1 < maze.length && !maze[x + 1][y])
            {
                exploreMapRecursive(maze, x + 1, y);
                maze[x + 1][y] = false;
                map.currPath.removeItem(x + 1, y);
                map.currPath.removeStep();
                Item itemToRemove = checkItem(x + 1, y);
                backpack.removeItem(itemToRemove);
            }
        }
    }

    // This method returns a item on coordinate (x, y)

    public Item checkItem(int x, int y)
    {
        for(int i = 0; i < map.getMaze().getItems().length; i++)
        {
            Item item = map.getMaze().getItems()[i];
            if(item.getCoord()[0] == x && item.getCoord()[1] == y) return item;
        }

        return null;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString() {
        return "Adventurer{" +
                "name='" + name + '\'' +
                ", initCoord=" + Arrays.toString(initCoord) +
                ", map=" + map +
                ", backpack=" + backpack +
                '}';
    }
}
