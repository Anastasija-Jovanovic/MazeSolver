package algorithams;

import maze.Cell;
import maze.MazeFrame;

import java.util.*;

public class AStar implements Algoritham {

    private MazeFrame mazeFrame;
    private Cell[][] maze;
    private List<PartialPathOfAStar> partialPaths;
    private Set<Position> visitedPositions;

    public AStar(MazeFrame mazeFrame) {
        this.mazeFrame = mazeFrame;
        maze = mazeFrame.getMazeGenerator().getCells();
    }

    @Override
    public void findPath() {

        partialPaths = new ArrayList<>();
        visitedPositions = new HashSet<>();

        Position currentPosition = new Position(0, 0);
        PartialPathOfAStar partialPath = new PartialPathOfAStar();

        partialPath.getPath().add(currentPosition);
        partialPaths.add(partialPath);

        int columns = mazeFrame.getMazeGenerator().getWidth();
        int rows = mazeFrame.getMazeGenerator().getHeight();

        visitedPositions.add(currentPosition);

        while (!partialPaths.isEmpty()) {
            PartialPathOfAStar currentPartialPath = partialPaths.get(0);
            currentPosition = currentPartialPath.getPath().get(currentPartialPath.getPath().size() - 1);

            if (currentPosition.getX() == columns - 1 && currentPosition.getY() == rows - 1)
                return;

            partialPaths.remove(currentPartialPath);

            if (maze[currentPosition.getX()][currentPosition.getY()].getWalls()[0] == 0 && !visitedPositions.contains(new Position(currentPosition.getX(), currentPosition.getY() - 1))) {
                Position tmpPosition = new Position(currentPosition.getX(), currentPosition.getY() - 1);
                visitedPositions.add(tmpPosition);
                PartialPathOfAStar newPartialPath = new PartialPathOfAStar();
                newPartialPath.getPath().addAll(currentPartialPath.getPath());
                newPartialPath.getPath().add(tmpPosition);
                newPartialPath.setF(newPartialPath.getPath().size() + hManhattan(tmpPosition.getX(), tmpPosition.getY(), columns - 1, rows - 1));
                partialPaths.add(newPartialPath);
            }
            if (maze[currentPosition.getX()][currentPosition.getY()].getWalls()[1] == 0 && !visitedPositions.contains(new Position(currentPosition.getX() + 1, currentPosition.getY()))) {
                Position tmpPosition = new Position(currentPosition.getX() + 1, currentPosition.getY());
                visitedPositions.add(tmpPosition);
                PartialPathOfAStar newPartialPath = new PartialPathOfAStar();
                newPartialPath.getPath().addAll(currentPartialPath.getPath());
                newPartialPath.getPath().add(tmpPosition);
                newPartialPath.setF(newPartialPath.getPath().size() + hManhattan(tmpPosition.getX(), tmpPosition.getY(), columns - 1, rows - 1));
                partialPaths.add(newPartialPath);
            }
            if (maze[currentPosition.getX()][currentPosition.getY()].getWalls()[2] == 0 && !visitedPositions.contains(new Position(currentPosition.getX(), currentPosition.getY() + 1))) {
                Position tmpPosition = new Position(currentPosition.getX(), currentPosition.getY() + 1);
                visitedPositions.add(tmpPosition);
                PartialPathOfAStar newPartialPath = new PartialPathOfAStar();
                newPartialPath.getPath().addAll(currentPartialPath.getPath());
                newPartialPath.getPath().add(tmpPosition);
                newPartialPath.setF(newPartialPath.getPath().size() + hManhattan(tmpPosition.getX(), tmpPosition.getY(), columns - 1, rows - 1));
                partialPaths.add(newPartialPath);
            }
            if (maze[currentPosition.getX()][currentPosition.getY()].getWalls()[3] == 0 && !visitedPositions.contains(new Position(currentPosition.getX() - 1, currentPosition.getY()))) {
                Position tmpPosition = new Position(currentPosition.getX() - 1, currentPosition.getY());
                visitedPositions.add(tmpPosition);
                PartialPathOfAStar newPartialPath = new PartialPathOfAStar();
                newPartialPath.getPath().addAll(currentPartialPath.getPath());
                newPartialPath.getPath().add(tmpPosition);
                newPartialPath.setF(newPartialPath.getPath().size() + hManhattan(tmpPosition.getX(), tmpPosition.getY(), columns - 1, rows - 1));
                partialPaths.add(newPartialPath);
            }

            partialPaths.sort(Comparator.naturalOrder());

        }

    }

    private int hManhattan(int x, int y, int endX, int endY) {
        return Math.abs(x - endX) + Math.abs(y - endY);
    }

    public List<Position> path() {
        List<Position> finalPath = new ArrayList<>();

        if (!partialPaths.isEmpty())
            finalPath = partialPaths.get(0).getPath();

        return finalPath;
    }

    public Set<Position> getVisitedPositions() {
        return visitedPositions;
    }
}
