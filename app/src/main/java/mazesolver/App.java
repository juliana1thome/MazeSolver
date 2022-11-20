package mazesolver;

import java.io.IOException;

public class App {
    private static boolean isCellValid(int x, int y, int N) {
        return !(x < 0 || y < 0 || x >= N || y >= N);
    }

    private static int pathCounter(int[][] maze, int startX, int startY, int exitX, int exitY,
                                  boolean visited[][])
    {
        // If the start is the exit
        if (startX == exitX && startY == exitY) {
            return 1;
        }

        // Storing number of paths from start to exit
        int count = 0;

        // Mark all cells that were visited
        visited[startX][startY] = true;

        int mazeSize = maze.length;

        // If this cell is valid go over it
        if (isCellValid(startX, startY, mazeSize) && maze[startX][startY] == 0)
        {
            // Down
            if (startX + 1 < mazeSize && !visited[startX + 1][startY]) {
                count += pathCounter(maze, startX + 1, startY, exitX, exitY, visited);
            }

            // Up
            if (startX - 1 >= 0 && !visited[startX - 1][startY]) {
                count += pathCounter(maze, startX - 1, startY, exitX, exitY, visited);
            }

            // Right
            if (startY + 1 < mazeSize && !visited[startX][startY + 1]) {
                count += pathCounter(maze, startX, startY + 1, exitX, exitY, visited);
            }

            // Left
            if (startY - 1 >= 0 && !visited[startX][startY - 1]) {
                count += pathCounter(maze, startX, startY - 1, exitX, exitY, visited);
            }
        }

        // Backtrack from on the path, and remove it from the possible paths with false
        visited[startX][startY] = false;

        return count;
    }

    public static int findCount(int[][] maze, int startX, int startY, int exitX, int exitY)
    {
        // No Paths
        if (maze == null || maze.length == 0 || maze[startX][startY] == 1 || maze[exitX][exitY] == 1) {
            return 0;
        }

        int mazeSize = maze.length;

        // Keeping track of of the path already walked
        boolean[][] visited = new boolean[mazeSize][mazeSize];

        // Start from mazer start and end on maze exit
        return pathCounter(maze, startX, startY, exitX, exitY, visited);
    }

    public static void main(String[] args) throws IOException {
        
        // Create a matrix from file
        Matrix matrix = new Matrix();
        int[][] maze = matrix.createFromFile("app/src/main/java/mazesolver/maze.txt");

        // Find amount of paths and print it
        int count = App.findCount(maze, matrix.getEntranceX(),matrix.getEntranceY(),matrix.getExitX(),matrix.getExitY());
        System.out.println("The total number of unique paths are " + count);
    }
}
