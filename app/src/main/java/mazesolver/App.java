package mazesolver;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, InvalidMazeException {
                
        Maze matrix = MazeBuilder.createFromFile("app/src/main/java/mazesolver/maze.txt");
        
        MazeSolver mazeSolver = new MazeSolver(matrix.getMatrix(), matrix.getStartY(),matrix.getStartX(),matrix.getExitY(),matrix.getExitX());

        System.out.println("Number of paths: " + mazeSolver.findTotalPaths().size());
        System.out.println("Shortest path: " + mazeSolver.findShortestPath().getSteps());
        System.out.println("Longest path: " + mazeSolver.findLongestPath().getSteps());
    }
}