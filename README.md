# MazeSolver

INTRODUCTION
------------

This application is a maze solver. And it creates a Matrix Mazes from any text file that has these elements:

* Equal quantity of elements in X and Y (Square Matrix)
* 0 -> Hallways
* 1 -> Walls
* S -> Start
* E -> Exit

COMPONENTS
------------

There are 6 components in this application, and their functionalities are:

* Maze.java -> Maze is a new data type that envisions creating an int[][] matrixes with the additional parameters that constitues a maze: private int startX (X Starting coordinates), private int startY (Y Starting coordinates), private int exitX (X Exit coordinates), private int exitY (Y Exit coordinates).

* MazeBuilder.java -> It creates a matrix from a txt file that contains the before-mentioned items [Introduction](#Introduction) and sets the Start coordinates and the Exit coordinates.

* MazePath.java -> MazePath is another datatype that has the purpose of allowing each maze to have many paths with steps and visited path checks.

* MazeSolver.java -> MazeSolver, like its name suggests, it solves the maze created, and it does that by finding all paths (inside a list). To later find which path is the shortest (denpending the amount of steps) and which path is the longest (denpending the amount of steps). It also checks if a cell in the maze is valid to go over and sets the visited ones.

* InvalidMazeException.java -> A simple exception class.

* App.java -> App is the java file where the main is found and the main contains the implementation of all before-mentioned files. And such implementation consists in performing the Maze Challenge, which consists in finding all possible paths leading to the exit, finding the shortest path (number of steps), and finding the longest path (number of steps).
     
TESTS
------------

There are 4 test files in this application:

* AppTest (Integration)
* MazeBuilderTest (Unit Test)
* MazePathTest (Unit Test)
* MazeSolverTest (Unit Test)

REQUIREMENTS
------------

This application requires the following:

 * [Gradle version "7.3"](https://services.gradle.org/distributions/)
 * [JDK version "17.0.5"](https://www.oracle.com/java/technologies/javase/17-0-5-relnotes.html)