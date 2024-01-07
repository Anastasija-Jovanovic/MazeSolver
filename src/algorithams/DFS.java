package algorithams;

import maze.Cell;
import maze.MazeFrame;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DFS implements Algoritham {

    private MazeFrame mazeFrame;
    private Cell[][] maze;
    private Set<Position> visitedPositions;
    private Stack<Position> currentPath;

    public DFS(MazeFrame mazeFrame) {
        this.mazeFrame = mazeFrame;
        maze = mazeFrame.getMazeGenerator().getCells();
    }


    @Override
    public void findPath() {
        currentPath = new Stack<>();
        visitedPositions = new HashSet<>();

        Position currentPosition = new Position(0, 0);
        visitedPositions.add(currentPosition);
        currentPath.push(currentPosition);

        int columns = mazeFrame.getMazeGenerator().getWidth();
        int rows = mazeFrame.getMazeGenerator().getHeight();

        while ((currentPosition.getX() != columns - 1 || currentPosition.getY() != rows - 1) && !currentPath.empty()) {

            if (maze[currentPosition.getX()][currentPosition.getY()].getWalls()[0] == 0 && !visitedPositions.contains(new Position(currentPosition.getX(), currentPosition.getY() - 1))) {
                currentPosition = new Position(currentPosition.getX(), currentPosition.getY() - 1);
                visitedPositions.add(currentPosition);
                currentPath.push(currentPosition);
                //   System.out.println("gore");
            } else if (maze[currentPosition.getX()][currentPosition.getY()].getWalls()[1] == 0 && !visitedPositions.contains(new Position(currentPosition.getX() + 1, currentPosition.getY()))) {
                currentPosition = new Position(currentPosition.getX() + 1, currentPosition.getY());
                visitedPositions.add(currentPosition);
                currentPath.push(currentPosition);
                //  System.out.println("desno");

            } else if (maze[currentPosition.getX()][currentPosition.getY()].getWalls()[2] == 0 && !visitedPositions.contains(new Position(currentPosition.getX(), currentPosition.getY() + 1))) {
                currentPosition = new Position(currentPosition.getX(), currentPosition.getY() + 1);
                visitedPositions.add(currentPosition);
                currentPath.push(currentPosition);
                //  System.out.println("dole");

            } else if (maze[currentPosition.getX()][currentPosition.getY()].getWalls()[3] == 0 && !visitedPositions.contains(new Position(currentPosition.getX() - 1, currentPosition.getY()))) {
                currentPosition = new Position(currentPosition.getX() - 1, currentPosition.getY());
                visitedPositions.add(currentPosition);
                currentPath.push(currentPosition);
                //  System.out.println("levo");
            } else {
                if (!currentPath.empty())
                    currentPath.pop();
                if (!currentPath.empty())
                    currentPosition = currentPath.peek();
                //    System.out.println("cosak");
            }

        }
    }

    public Stack<Position> getCurrentPath() {
        return currentPath;
    }

    public Set<Position> getVisitedPositions() {
        return visitedPositions;
    }
}
