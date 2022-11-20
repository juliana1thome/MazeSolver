package mazesolver;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Arrays;

public class MazeBuilderTest {
    @Test void hasCorrectArrayRepresentation() throws IOException {
        int[][] expectedMatrix =
        {
            { 0, 0, 0, 0 },
            { 1, 1, 1, 0 },
            { 1, 1, 1, 0 },
            { 1, 1, 1, 0 }
        };

        Maze maze = MazeBuilder.createFromFile("src/test/resources/small-maze.txt");

        assertEquals(Arrays.deepEquals(expectedMatrix, maze.getMatrix()), true);
    }

    @Test void hasCorrectStartExitPositions() throws IOException {
        int startX = 0;
        int startY = 0;
        int exitX = 3;
        int exitY = 3;

        Maze matrix = MazeBuilder.createFromFile("src/test/resources/small-maze.txt");

        assertEquals(startX, matrix.getStartX());
        assertEquals(startY, matrix.getStartY());
        assertEquals(exitX, matrix.getExitX());
        assertEquals(exitY, matrix.getExitY());
    }
}