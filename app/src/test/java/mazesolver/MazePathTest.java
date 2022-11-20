package mazesolver;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MazePathTest {

    @Test void calculatesCorrectNumberOfSteps() {
        boolean[][] visited =
        {
            { true, true, true, true },
            { false, false, false, true },
            { false, false, false, true },
            { false, false, false, false }
        };

        MazePath mazePath = new MazePath(visited, 0, 0, 0, 0);

        assertEquals(7, mazePath.getSteps());
    }
}