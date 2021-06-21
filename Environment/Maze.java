package Environment;

import Adventurer.Items.Gem;
import Adventurer.Items.Item;

import java.io.*;
import java.util.Scanner;

public class Maze
{
    /*
        This class represents the maze itself. It contains the matrix of booleans which
        True is a valid position and False a invalid position (wall), and the start and
        end positions.
    */

    private final String defaultMapFile = "Environment/Maps/mapDefault.txt";
    private final int[] start = new int[2];
    private final int[] end = new int[2];
    private boolean[][] maze;
    private Item[] items;

    public Maze(String nameFile)
    {
        try
        {
            initLab("MazeAdventurer/Environment/Maps/" + nameFile);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("The provided text file was not found. The default file will be used.");
            initLab();
        }
        catch (NullPointerException e)
        {
            System.out.println("No text file chosen. The default file will be used.");
            initLab();
        }
    }

    // This method uses a map text file given to create the maze and its items

    private void initLab(String nameFile) throws FileNotFoundException, NullPointerException
    {
        File labData = new File(nameFile);
        Scanner reader = new Scanner(labData);
        extractMazeData(reader);
    }

    // This method uses the default map text file to create the maze and its items

    private void initLab()
    {
        try
        {
            File labData = new File(defaultMapFile);
            Scanner reader = new Scanner(labData);
            extractMazeData(reader);
        }
        catch (Exception e)
        {
            System.out.println("Default map file was not found.");
        }
    }


    // This method extract all data from a scanner, creating the matrix of booleans
    // and registering all existing item and yours attributes.

    private void extractMazeData(Scanner reader)
    {
        while(reader.hasNext())
        {
            maze = new boolean[reader.nextInt()][reader.nextInt()];

            for(int i = 0; i < maze.length; i++)
            {
                char[] lineMaze = reader.next().toCharArray();

                for(int j = 0; j < maze[0].length; j++)
                {
                    maze[i][j] = lineMaze[j] != '.';
                }
            }

            items = new Gem[reader.nextInt()];

            for(int i = 0; i < items.length; i++)
            {
                int coordX = reader.nextInt();
                int coordY = reader.nextInt();
                int weight = reader.nextInt();
                String color = reader.next();
                Item newItem = new Gem(coordX, coordY, weight, color);
                items[i] = newItem;
            }

            start[0] = reader.nextInt();
            start[1] = reader.nextInt();
            end[0] = reader.nextInt();
            end[1] = reader.nextInt();
        }
    }

    public int[] getStart()
    {
        return start;
    }

    public int[] getEnd()
    {
        return end;
    }

    public boolean[][] getMaze()
    {
        return maze;
    }

    public Item[] getItems()
    {
        return items;
    }
}
