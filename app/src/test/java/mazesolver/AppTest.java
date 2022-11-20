/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package mazesolver;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class AppTest {
    @Test void useFile() throws IOException, InvalidMazeException {
        Maze matrix = MazeBuilder.createFromFile("small-maze.txt");

        MazeSolver mazeSolver = new MazeSolver(matrix.getMatrix(), matrix.getStartY(),matrix.getStartX(),matrix.getExitY(),matrix.getExitX());

        assertEquals(1, mazeSolver.findTotalPaths().size());
        assertEquals(0, matrix.getStartX());
        assertEquals(0, matrix.getStartY());
        assertEquals(3, matrix.getExitX());
        assertEquals( 3, matrix.getExitY());
    }

    @Test void useFile12Paths() throws IOException, InvalidMazeException {

        Maze matrix = MazeBuilder.createFromFile("maze-12-paths.txt");

        MazeSolver mazeSolver = new MazeSolver(matrix.getMatrix(), matrix.getStartY(),matrix.getStartX(),matrix.getExitY(),matrix.getExitX());

        assertEquals(1, mazeSolver.findTotalPaths().size());
        assertEquals(2, matrix.getStartX());
        assertEquals(1, matrix.getStartY());
        assertEquals(3, matrix.getExitX());
        assertEquals(2, matrix.getExitY());
    }

    @Test void useOriginalFile() throws IOException, InvalidMazeException {
        Maze matrix = MazeBuilder.createFromFile("maze.txt");

        MazeSolver mazeSolver = new MazeSolver(matrix.getMatrix(), matrix.getStartY(),matrix.getStartX(),matrix.getExitY(),matrix.getExitX());

        assertEquals(12, mazeSolver.findTotalPaths().size());
        assertEquals(0, matrix.getStartX());
        assertEquals(1, matrix.getStartY());
        assertEquals(40, matrix.getExitX());
        assertEquals(39, matrix.getExitY());
    }

    @Test void mazeNoPaths() throws IOException, InvalidMazeException {
        Maze matrix = MazeBuilder.createFromFile("maze-no-paths.txt");

        MazeSolver mazeSolver = new MazeSolver(matrix.getMatrix(), matrix.getStartY(),matrix.getStartX(),matrix.getExitY(),matrix.getExitX());

        assertEquals(0, mazeSolver.getTotalPaths());
        assertEquals(0, matrix.getStartX());
        assertEquals(0, matrix.getStartY());
        assertEquals(3, matrix.getExitX());
        assertEquals(3, matrix.getExitY());
    }
}