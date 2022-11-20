package mazesolver;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MazeBuilder {

    public static Maze createFromFile(String filename) throws IOException {
        
        Path mazeFile = Paths.get(filename);
        List<String> allLines = Files.readAllLines(mazeFile, StandardCharsets.UTF_8);
        int[][] mazeMatrix = new int[allLines.size()][allLines.size()];
        int mazeStartX = 0;
        int mazeStartY = 0;
        int mazeExitX = 0;
        int mazeExitY = 0;

        // Going over all lines
        for (int y = 0; y < allLines.size(); y++) {
            String line = allLines.get(y);
            String[] cells = line.split("");

            // For each line, go over the characters
            for (int x = 0; x < cells.length; x++) {

                if (cells[x].equals("S")) {
                    mazeMatrix[y][x] = 0;
                    mazeStartX = x;
                    mazeStartY = y;
                } else if (cells[x].equals("E")) {
                    mazeMatrix[y][x] = 0;
                    mazeExitX = x;
                    mazeExitY = y;
                } else {
                    mazeMatrix[y][x] = Integer.parseInt(cells[x]);
                }
            }
        }

        return new Maze(mazeMatrix, mazeStartX, mazeStartY, mazeExitX, mazeExitY);
    }
}