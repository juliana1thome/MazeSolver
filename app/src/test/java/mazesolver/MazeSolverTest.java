package mazesolver;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MazeSolverTest {
    @Test void calculatesAllUniquePaths() throws InvalidMazeException {
        int[][] maze =
            {
                { 0, 0, 0, 0 },
                { 0, 1, 0, 0 },
                { 0, 1, 0, 0 },
                { 0, 0, 0, 0 }
            };

        MazeSolver mazeSolver = new MazeSolver(maze, 0, 0, 3, 3);

        assertEquals(12, mazeSolver.findTotalPaths().size());
    }

    @Test void calculatesCorrectShortestPath() throws InvalidMazeException {
        int[][] maze =
            {   
                { 0, 0, 0, 0 },
                { 0, 1, 0, 0 },
                { 0, 1, 0, 0 },
                { 0, 0, 0, 0 }
            };

        MazeSolver mazeSolver = new MazeSolver(maze, 0, 0, 3, 3);

        assertEquals(7, mazeSolver.findShortestPath().getSteps());
    }
    
    @Test void calculatesCorrectLongestPath() throws InvalidMazeException {
        int[][] maze =
            {
                { 0, 0, 0, 0 },
                { 0, 1, 0, 0 },
                { 0, 1, 0, 0 },
                { 0, 0, 0, 0 }
            };

        MazeSolver mazeSolver = new MazeSolver(maze, 0, 0 ,3 , 3);

        assertEquals(13, mazeSolver.findLongestPath().getSteps());
    }

    @Test void invalidMaze() throws InvalidMazeException {
        int[][] maze =
            {
                { 0, 0, 0, 0 },
                { 0 },
            };

        Exception exception = assertThrows(InvalidMazeException.class, () -> {
            new MazeSolver(maze, 0, 0, 0, 0);
        });

        assertTrue(exception.getMessage().contains("is invalid"));
    }

    @Test void startStopPointsNotWalkable() throws InvalidMazeException {
        int[][] maze =
            {
                { 1 }
            };

        Exception exception = assertThrows(InvalidMazeException.class, () -> {
            new MazeSolver(maze, 0, 0, 0, 0);
        });

        assertTrue(exception.getMessage().contains("points are not walkable"));
    }

    @Test void invalidStartStopPoints() throws InvalidMazeException {
        int[][] maze =
            {
                { 0 }
            };

        Exception exception = assertThrows(InvalidMazeException.class, () -> {
            new MazeSolver(maze, 10, 0, 0, 0);
        });

        assertTrue(exception.getMessage().contains("Invalid start or exit positions"));
    }
}
