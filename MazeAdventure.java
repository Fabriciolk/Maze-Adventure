import Adventurer.Adventurer;
import Adventurer.Backpack;
import Adventurer.Map;
import Environment.Maze;

public class MazeAdventure
{
    public static void main(String[] args) // arg: MazeAndItensfile.txt
    {
        Maze maze = new Maze(args[0]);
        Map map = new Map(maze);
        Backpack backpack = new Backpack(100, "Brown", maze.getItems().length);

        Adventurer adventurer = new Adventurer("Nick", maze.getStart()[0], maze.getStart()[1]);
        adventurer.map = map;
        adventurer.backpack = backpack;
        adventurer.exploreMaze();

        Result result = new Result(adventurer);
        result.computePaths();
        result.printResults();
    }
}
