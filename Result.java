
import Adventurer.Adventurer;
import Adventurer.Path.Path;
import Adventurer.Path.Step;

public class Result
{
    /*
        After adventurer explore the maze, this class organized those paths
        to print the original maze, where the initial position is a char 'I',
        final is a char 'F' and all steps is char 'o'.
    */

    public Adventurer adv;
    public char[][] shortestMatrix;
    public char[][] longestMatrix;
    public char[][] valuableMatrix;
    public char[][] fastestMatrix;

    public Result(Adventurer adv)
    {
        this.adv = adv;
        int widthMap = adv.map.getMaze().getMaze().length;
        int heightMap = adv.map.getMaze().getMaze()[0].length;

        shortestMatrix = new char[widthMap][heightMap];
        longestMatrix = new char[widthMap][heightMap];
        valuableMatrix = new char[widthMap][heightMap];
        fastestMatrix = new char[widthMap][heightMap];

        copyOriginalMaze(shortestMatrix);
        copyOriginalMaze(longestMatrix);
        copyOriginalMaze(valuableMatrix);
        copyOriginalMaze(fastestMatrix);
    }

    // This method make a copy of the maze's matrix

    private void copyOriginalMaze(char[][] map)
    {
        for(int i = 0; i < adv.map.getMaze().getMaze().length; i++)
        {
            for(int j = 0; j < adv.map.getMaze().getMaze()[0].length; j++)
            {
                if(adv.map.getMaze().getMaze()[i][j])
                {
                    map[i][j] = 'X';
                }
                else
                {
                    map[i][j] = '.';
                }
            }
        }

        map[adv.map.getMaze().getStart()[0]][adv.map.getMaze().getStart()[1]] = 'I';
        map[adv.map.getMaze().getEnd()[0]][adv.map.getMaze().getEnd()[1]] = 'F';
    }

    // This method insert 'o' chars on all kind of matrix

    public void computePaths()
    {
        writePathOnMatrix(adv.map.shortest, shortestMatrix);
        writePathOnMatrix(adv.map.longest, longestMatrix);
        writePathOnMatrix(adv.map.valuable, valuableMatrix);
        writePathOnMatrix(adv.map.fastest, fastestMatrix);
    }

    // This method insert 'o' in a specific matrix

    private void writePathOnMatrix(Path path, char[][] matrix)
    {
        Step auxStep = path.firstStep;
        int[] start = adv.map.getMaze().getStart();
        int[] end = adv.map.getMaze().getEnd();

        while(auxStep != null)
        {
            if((auxStep.getCoord()[0] != start[0] || auxStep.getCoord()[1] != start[1]) &&
               (auxStep.getCoord()[0] != end[0] || auxStep.getCoord()[1] != end[1]))
            {
                matrix[auxStep.getCoord()[0]][auxStep.getCoord()[1]] = 'o';
            }

            auxStep = auxStep.next;
        }
    }

    // This method print on screen all content of a matrix

    private void printMatrix(char[][] matrix)
    {
        for (char[] chars : matrix)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                System.out.print(chars[j] + " ");
            }

            System.out.println();
        }
    }

    // This method print all matrix

    public void printResults()
    {
        System.out.println("Shortest path:");
        System.out.println("Steps: " + (adv.map.shortest.totalSteps - 1) + "; Value: " + adv.map.shortest.totalValue + "; Weight: " + adv.map.shortest.totalWeight + "; Time: " + adv.map.shortest.totalTime + "\n");
        printMatrix(shortestMatrix);

        System.out.println("\nLongest path: ");
        System.out.println("Steps: " + (adv.map.longest.totalSteps - 1) + "; Value: " + adv.map.longest.totalValue + "; Weight: " + adv.map.longest.totalWeight + "; Time: " + adv.map.longest.totalTime + "\n");
        printMatrix(longestMatrix);

        System.out.println("\nMost valuable path: ");
        System.out.println("Steps: " + (adv.map.valuable.totalSteps - 1) + "; Value: " + adv.map.valuable.totalValue + "; Weight: " + adv.map.valuable.totalWeight + "; Time: " + adv.map.valuable.totalTime + "\n");
        printMatrix(valuableMatrix);

        System.out.println("\nFastest path: ");
        System.out.println("Steps: " + (adv.map.fastest.totalSteps - 1) + "; Value: " + adv.map.fastest.totalValue + "; Weight: " + adv.map.fastest.totalWeight + "; Time: " + adv.map.fastest.totalTime + "\n");
        printMatrix(fastestMatrix);
    }
}
