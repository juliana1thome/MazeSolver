package mazesolver;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, InvalidMazeException {
                
        Maze maze = MazeBuilder.createFromFile("app/src/main/resources/maze.txt");
        
        MazeSolver mazeSolver = new MazeSolver(maze.getMatrix(), maze.getStartY(),maze.getStartX(),maze.getExitY(),maze.getExitX());

        System.out.println("Number of paths: " + mazeSolver.findTotalPaths().size());
        System.out.println("Shortest path: " + mazeSolver.findShortestPath().getSteps());
        System.out.println("Longest path: " + mazeSolver.findLongestPath().getSteps());
    }
}