package algorithams;

import maze.Cell;
import maze.MazeFrame;

import java.util.*;

public class BestFirst implements Algoritham {
    private MazeFrame mazeFrame;
    private Cell[][] maze;
    private Set<Position> visitedPositions;
    private List<HierarchyOfBestFirst> toCheck;


    public BestFirst(MazeFrame mazeFrame) {
        this.mazeFrame = mazeFrame;
        maze = mazeFrame.getMazeGenerator().getCells();
    }


    @Override
    public void findPath() {

        visitedPositions = new HashSet<>();
        toCheck = new ArrayList<>();

        Position currentPosition = new Position(0, 0);

        toCheck.add(new HierarchyOfBestFirst(null, 0, currentPosition));

        int columns = mazeFrame.getMazeGenerator().getWidth();
        int rows = mazeFrame.getMazeGenerator().getHeight();

        while (!toCheck.isEmpty()) {
            currentPosition = toCheck.get(0).getPosition();

            if (currentPosition.getX() == columns - 1 && currentPosition.getY() == rows - 1)
                return;

            HierarchyOfBestFirst currentParent = toCheck.get(0);

            if (maze[currentPosition.getX()][currentPosition.getY()].getWalls()[0] == 0 && !visitedPositions.contains(new Position(currentPosition.getX(), currentPosition.getY() - 1))) {
                Position tmp = new Position(currentPosition.getX(), currentPosition.getY() - 1);
                toCheck.add(new HierarchyOfBestFirst(currentParent, hManhattan(tmp.getX(), tmp.getY(), columns - 1, rows - 1), tmp));
                visitedPositions.add(tmp);
            }
            if (maze[currentPosition.getX()][currentPosition.getY()].getWalls()[1] == 0 && !visitedPositions.contains(new Position(currentPosition.getX() + 1, currentPosition.getY()))) {
                Position tmp = new Position(currentPosition.getX() + 1, currentPosition.getY());
                toCheck.add(new HierarchyOfBestFirst(currentParent, hManhattan(tmp.getX(), tmp.getY(), columns - 1, rows - 1), tmp));
                visitedPositions.add(tmp);
            }
            if (maze[currentPosition.getX()][currentPosition.getY()].getWalls()[2] == 0 && !visitedPositions.contains(new Position(currentPosition.getX(), currentPosition.getY() + 1))) {
                Position tmp = new Position(currentPosition.getX(), currentPosition.getY() + 1);
                toCheck.add(new HierarchyOfBestFirst(currentParent, hManhattan(tmp.getX(), tmp.getY(), columns - 1, rows - 1), tmp));
                visitedPositions.add(tmp);
            }
            if (maze[currentPosition.getX()][currentPosition.getY()].getWalls()[3] == 0 && !visitedPositions.contains(new Position(currentPosition.getX() - 1, currentPosition.getY()))) {
                Position tmp = new Position(currentPosition.getX() - 1, currentPosition.getY());
                toCheck.add(new HierarchyOfBestFirst(currentParent, hManhattan(tmp.getX(), tmp.getY(), columns - 1, rows - 1), tmp));
                visitedPositions.add(tmp);
            }
            toCheck.remove(0);

            toCheck.sort(Comparator.naturalOrder());
        }

    }

    public List<Position> path() {
        List<Position> path = new ArrayList<>();
        HierarchyOfBestFirst parent = toCheck.get(0);

        while (parent != null) {
            path.add(parent.getPosition());
            parent = parent.getParent();
        }

        Collections.reverse(path);
        return path;
    }

    private int hManhattan(int x, int y, int endX, int endY) {
        return Math.abs(x - endX) + Math.abs(y - endY);
    }

    public Set<Position> getVisitedPositions() {
        return visitedPositions;
    }


}
