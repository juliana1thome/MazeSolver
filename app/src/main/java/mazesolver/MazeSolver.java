package mazesolver;

import java.util.ArrayList;
import java.util.List;

public class MazeSolver {

    private List<MazePath> mazePaths = new ArrayList<>();
    private int[][] matrix;
    private int startX;
    private int startY;
    private int exitX;
    private int exitY;
    private int totalPaths;

    public MazeSolver(int[][] matrix, int startX, int startY, int exitX, int exitY) throws InvalidMazeException {
        this.matrix = matrix;
        this.startX = startX;
        this.startY = startY;
        this.exitX = exitX;
        this.exitY = exitY;
        findAllPaths();
    }

    public List<MazePath> getMazePaths() {
        return mazePaths;
    }

    public int getTotalPaths() {
        return totalPaths;
    }

    public void setMazePaths(List<MazePath> mazePaths) {
        this.mazePaths = mazePaths;
    }

    public void setTotalPaths(int totalPaths) {
        this.totalPaths = totalPaths;
    }

    private static boolean isCellValid(int x, int y, int size) {
        return !(x < 0 || y < 0 || x >= size || y >= size);
    }

    private void findPath(int[][] matrix, int startY, int startX, int exitY, int exitX, boolean visited[][])
    {
        // If the start is the exit
        if (startY == exitY && startX == exitX) {
            MazePath mazePath = new MazePath(visited, startX, startY, exitX, exitY);
            mazePaths.add(mazePath);
        }
        
        int mazeSize = matrix.length;

        // Mark all cells that were visited
        visited[startY][startX] = true;

        // If this cell is valid go over it
        if (isCellValid(startY, startX, mazeSize) && matrix[startY][startX] == 0)
        {
            // Down
            if (startY + 1 < mazeSize && !visited[startY + 1][startX]) {
                findPath(matrix, startY + 1, startX, exitY, exitX, visited);
            }

            // Up
            if (startY - 1 >= 0 && !visited[startY - 1][startX]) {
                findPath(matrix, startY - 1, startX, exitY, exitX, visited);
            }

            // Right
            if (startX + 1 < mazeSize && !visited[startY][startX + 1]) {
                findPath(matrix, startY, startX + 1, exitY, exitX, visited);
            }

            // Left
            if (startX - 1 >= 0 && !visited[startY][startX - 1]) {
                findPath(matrix, startY, startX - 1, exitY, exitX, visited);
            }
        }

        // Backtrack from on the path, and remove it from the possible paths with false
        visited[startY][startX] = false;
    }

    private void findAllPaths() throws InvalidMazeException
    {
        int mazeSize = matrix.length;

        // Invalid maze
        if (matrix == null || mazeSize == 0 || mazeSize != matrix[0].length) {
            throw new InvalidMazeException("Maze is invalid!");
        }

        // Invalid start or exit positions
        if (startX > mazeSize || startY > mazeSize || exitX > mazeSize || exitY > mazeSize) {
            throw new InvalidMazeException("Invalid start or exit positions!");
        }

        // No Paths
        if (matrix[startX][startY] == 1 || matrix[exitX][exitY] == 1) {
            throw new InvalidMazeException("Start or stop points are not walkable!");
        }

        // Keeping track of of the path already walked
        boolean[][] visited = new boolean[mazeSize][mazeSize];

        // Start from mazer start and end on maze exit
        findPath(matrix, startX, startY, exitX, exitY, visited);
    }
    
    public List<MazePath> findTotalPaths() {
        return mazePaths;
    }

    public MazePath findShortestPath(){

        MazePath shortest = mazePaths.get(0);

        for (MazePath mazePath : mazePaths) {
            if(mazePath.getSteps() < shortest.getSteps()){
                shortest = mazePath;
            }
        }

        return shortest;
    }

    public MazePath findLongestPath(){

        MazePath longest = mazePaths.get(0);

        for (MazePath mazePath : mazePaths) {
            if(mazePath.getSteps() > longest.getSteps()){
                longest = mazePath;
            }
        }

        return longest;
    }
}