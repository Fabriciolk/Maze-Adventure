# Maze-Adventurer
A trial and error approach in a maze 

### What is it about

This program is about a adventurer that explore a maze from a initial to a final position, finding all best paths, according to an attribute, and collecting valuable items. There are the shortest, longest, most valuable and fastest paths, which shortest and longest means the minimum and maximum number of steps to reach the final position.

### How it works

As mentioned, the adventurer will explore que maze in a trial and error approach, where each position (coordinate) of the matrix that represent the maze will use recursion for each direction (left, up, right, down). The adventurer will have a backpack and a map which he/she could put the items along the currently path and write which steps was taken, so that each item contain a weight and the time to take one step is increased. Once reached the final position, the adventurer will register all steps taken and give back the item according to the item's coordinate (backtracking) and trying another path.

### How to use

To create the maze and all items and your attribute, a text file is given (terminal argument: java MazeAdventure file.txt). The file has a default format that consist in a line that contain the number of line and the number of columns of matrix, n lines below that represents the matrix itself, where '.' is a free position and 'X' is a wall, a line that contain a single number, representing the number of items in maze, m lines below for each item, following the format (coordinateX) (coordinteY) (value) (name). Finally, two lines that represent the initial and final positions (coodinates), respectivly, following the format (coordinateX) (coordinteY). Created the text file, just put it on directory MazeAdventurer\Environment\Maps and change the argument on terminal. The default file is below:

```
7 5
.....
.X.X.
.X.X.
.....
.X.X.
.X.X.
.....
3
4 0 4 Yellow
3 2 1 Red
2 0 8 Green
6 2
0 2
```

### Result

Ater tried all possible paths in maze, the program will print on screen (terminal) all best paths, in order shortest, longest, most valuable and fastest. Each impression is a matrix where the inicial position is a char 'I', the final position is a char 'F' and tha path is represented as a sequence of chars 'o'. The result for the default file is below:

```
Shortest path:
Steps: 6; Value: 7; Weight: 1; Time: 6.63

. . F . .
. X o X . 
. X o X . 
. . o . . 
. X o X . 
. X o X . 
. . I . . 

Longest path: 
Steps: 14; Value: 14; Weight: 5; Time: 25.63

. . F o o 
. X . X o 
. X . X o 
o o o o o 
o X . X . 
o X . X . 
o o I . . 

Most valuable path: 
Steps: 10; Value: 14; Weight: 12; Time: 27.28

o o F . . 
o X . X . 
o X . X . 
o . . . . 
o X . X . 
o X . X . 
o o I . . 

Fastest path: 
Steps: 6; Value: 7; Weight: 1; Time: 6.63

. . F . . 
. X o X . 
. X o X . 
. . o . . 
. X o X . 
. X o X . 
. . I . . 
```
