package mazesolver;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Matrix {
    int entranceX;
    int entranceY;
    int exitX;
    int exitY;

    public int getEntranceX() {
        return entranceX;
    }

    public int getEntranceY() {
        return entranceY;
    }

    public int getExitX() {
        return exitX;
    }

    public int getExitY() {
        return exitY;
    }

    public int[][] createFromFile(String filename) throws IOException {
        Path mazeFile = Paths.get(filename);
        List<String> allLines = Files.readAllLines(mazeFile, StandardCharsets.UTF_8);
        int[][] finalArray = new int[allLines.size()][allLines.size()];

        // going over the lines
        for (int i = 0; i < allLines.size(); i++) {
            String line = allLines.get(i);
            String[] cells = line.split("");

            // for each line, go over the characters
            for (int j = 0; j < cells.length; j++) {

                if (cells[j].equals("S")) {
                    finalArray[j][i] = 0;
                    entranceX = j;
                    entranceY = i;
                } else if (cells[j].equals("E")) {
                    finalArray[j][i] = 0;
                    exitX = j;
                    exitY = i;
                } else {
                    finalArray[j][i] = Integer.parseInt(cells[j]);
                }
            }
        }
        
        return finalArray;
    }
}
