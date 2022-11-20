package mazesolver;

public class Maze {

    private int[][] matrix;
    private int startX;
    private int startY;
    private int exitX;
    private int exitY;

    public Maze(int[][] matrix, int startX, int startY, int exitX, int exitY) {
        this.matrix = matrix;
        this.startX = startX;
        this.startY = startY;
        this.exitX = exitX;
        this.exitY = exitY;
    }
    
    public int[][] getMatrix() {
        return matrix;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getExitX() {
        return exitX;
    }

    public int getExitY() {
        return exitY;
    }
}