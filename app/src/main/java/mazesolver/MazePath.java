package mazesolver;

public class MazePath {
    
    private int startX;
    private int startY;
    private int exitX;
    private int exitY;
    private boolean visited[][];
    // The last step is never counted, so it will start with 1
    private Integer steps = 1;
    
    public MazePath(boolean[][] visited, int startX, int startY, int exitX, int exitY) {
        this.visited = visited;
        this.startX = startX;
        this.startY = startY;
        this.exitX = exitX;
        this.exitY = exitY;
        this.steps = calculateSteps();
    }

    public Integer calculateSteps(){
        
        for(int visitedX = 0; visitedX < visited[0].length; visitedX++) {
            for(int visitedY = 0; visitedY < visited[0].length; visitedY++) {
                if (visited[visitedX][visitedY] == true) {
                    steps++;
                }
            }
        }

        return steps;
    }
    
    public int getSteps() {
        return steps;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public void setVisited(boolean[][] visited) {
        this.visited = visited;
    }
    
    public boolean[][] getVisited() {
        return visited;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getExitX() {
        return exitX;
    }

    public void setExitX(int exitX) {
        this.exitX = exitX;
    }

    public int getExitY() {
        return exitY;
    }
    
    public void setExitY(int exitY) {
        this.exitY = exitY;
    }
}