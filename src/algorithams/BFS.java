package algorithams;

import maze.Cell;
import maze.MazeFrame;
import maze.Vertex;

import java.util.*;

public class BFS implements Algoritham {

    private MazeFrame mazeFrame;
    private Cell[][] maze;
    private Set<Position> visitedPositions;
    private Queue<Position> queue;
    private Set<Vertex> usedVertexes;

    public BFS(MazeFrame mazeFrame) {
        this.mazeFrame = mazeFrame;
        maze = mazeFrame.getMazeGenerator().getCells();
    }


    @Override
    public void findPath() {
        visitedPositions = new HashSet<>();
        queue = new ArrayDeque<>();
        usedVertexes = new HashSet<>();

        Position currentPosition = new Position(0, 0);
        queue.add(currentPosition);

        int columns = mazeFrame.getMazeGenerator().getWidth();
        int rows = mazeFrame.getMazeGenerator().getHeight();

        while ((currentPosition.getX() != columns - 1 || currentPosition.getY() != rows - 1) && !queue.isEmpty()) {
            currentPosition = queue.poll();

            visitedPositions.add(currentPosition);

            if (currentPosition.getX() == columns - 1 && currentPosition.getY() == rows - 1)
                return;


            if (maze[currentPosition.getX()][currentPosition.getY()].getWalls()[0] == 0 && !visitedPositions.contains(new Position(currentPosition.getX(), currentPosition.getY() - 1))) {
                Position tmp = new Position(currentPosition.getX(), currentPosition.getY() - 1);
                queue.add(tmp);
                usedVertexes.add(new Vertex(currentPosition, tmp));
            }
            if (maze[currentPosition.getX()][currentPosition.getY()].getWalls()[1] == 0 && !visitedPositions.contains(new Position(currentPosition.getX() + 1, currentPosition.getY()))) {
                Position tmp = new Position(currentPosition.getX() + 1, currentPosition.getY());
                queue.add(tmp);
                usedVertexes.add(new Vertex(currentPosition, tmp));
            }
            if (maze[currentPosition.getX()][currentPosition.getY()].getWalls()[2] == 0 && !visitedPositions.contains(new Position(currentPosition.getX(), currentPosition.getY() + 1))) {
                Position tmp = new Position(currentPosition.getX(), currentPosition.getY() + 1);
                queue.add(tmp);
                usedVertexes.add(new Vertex(currentPosition, tmp));
            }
            if (maze[currentPosition.getX()][currentPosition.getY()].getWalls()[3] == 0 && !visitedPositions.contains(new Position(currentPosition.getX() - 1, currentPosition.getY()))) {
                Position tmp = new Position(currentPosition.getX() - 1, currentPosition.getY());
                queue.add(tmp);
                usedVertexes.add(new Vertex(currentPosition, tmp));
            }
        }
    }

    public List<Position> path() {
        List<Position> path = new ArrayList<>();

        int columns = mazeFrame.getMazeGenerator().getWidth();
        int rows = mazeFrame.getMazeGenerator().getHeight();

        path.add(new Position(columns - 1, rows - 1));

        while (!path.get(path.size() - 1).equals(new Position(0, 0))) {
            Position currentPosition = path.get(path.size() - 1);

            for (Vertex vertex : usedVertexes) {
                if (vertex.getX2() == currentPosition.getX() && vertex.getY2() == currentPosition.getY()) {
                    path.add(new Position(vertex.getX1(), vertex.getY1()));
                    break;
                }
            }
        }
        Collections.reverse(path);

        return path;
    }

    public Set<Position> getVisitedPositions() {
        return visitedPositions;
    }
}
