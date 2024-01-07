package maze;

import algorithams.*;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MazePanel extends JPanel {

    private MazeFrame mazeFrame;
    private int offsetX = 10;
    private int offsetY = 10;
    private int cellSize;
    private Algoritham algoritham;

    public MazePanel(int cellSize, MazeFrame mazeFrame) {
        this.cellSize = cellSize;
        this.mazeFrame = mazeFrame;
    }

    private void doDrawing(Graphics graphics) {
        Graphics2D g2D = (Graphics2D) graphics;

        Dimension size = getSize();
        Insets insets = getInsets();

        int width = size.width - insets.left - insets.right;
        int height = size.height - insets.top - insets.bottom;

        g2D.setColor(Color.BLACK);
        g2D.clearRect(0, 0, width, height);

        int x, y;
        for (int i = 0; i < mazeFrame.getMazeGenerator().getWidth(); i++) {
            x = i * cellSize + offsetX;

            for (int j = 0; j < mazeFrame.getMazeGenerator().getHeight(); j++) {
                y = j * cellSize + offsetY;

                if (mazeFrame.getMazeGenerator().getCells()[i][j].getWalls()[0] == 1) {
                    g2D.drawLine(x, y, x + cellSize, y);
                }
                if (mazeFrame.getMazeGenerator().getCells()[i][j].getWalls()[1] == 1) {
                    g2D.drawLine(x + cellSize, y, x + cellSize, y + cellSize);
                }
                if (mazeFrame.getMazeGenerator().getCells()[i][j].getWalls()[2] == 1) {
                    g2D.drawLine(x, y + cellSize, x + cellSize, y + cellSize);
                }
                if (mazeFrame.getMazeGenerator().getCells()[i][j].getWalls()[3] == 1) {
                    g2D.drawLine(x, y, x, y + cellSize);
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);

        Font font = new Font(Font.MONOSPACED, 1, 15);

        if (algoritham != null) {
            ArrayList<Position> path = new ArrayList<>();
            Set<Position> visitedPositions = new HashSet<>();

            if (algoritham instanceof DFS) {
                path = new ArrayList<>();

                if (((DFS) algoritham).getCurrentPath() != null)
                    path = new ArrayList<>(((DFS) algoritham).getCurrentPath());

                visitedPositions = ((DFS) algoritham).getVisitedPositions();

            } else if (algoritham instanceof BFS) {
                path = new ArrayList<>();

                if (((BFS) algoritham).path() != null)
                    path = new ArrayList<>(((BFS) algoritham).path());

                visitedPositions = ((BFS) algoritham).getVisitedPositions();


            } else if (algoritham instanceof AStar) {
                path = new ArrayList<>();

                if (((AStar) algoritham).path() != null)
                    path = new ArrayList<>(((AStar) algoritham).path());

                visitedPositions = ((AStar) algoritham).getVisitedPositions();

            } else if (algoritham instanceof BestFirst) {
                path = new ArrayList<>();

                if (((BestFirst) algoritham).path() != null)
                    path = new ArrayList<>(((BestFirst) algoritham).path());

                visitedPositions = ((BestFirst) algoritham).getVisitedPositions();
            }

            Graphics2D g2 = (Graphics2D) g;

            for (Position pos : visitedPositions) {
                g2.setFont(font);
                g2.setColor(Color.BLACK);
                g2.drawString(".", offsetX + pos.getX() * cellSize + cellSize / 2, offsetY + pos.getY() * cellSize + cellSize / 2);
            }
            g2.setColor(Color.RED);
            Path2D path2D = new Path2D.Double();
            path2D.moveTo(offsetX + cellSize / 2.0, offsetY + cellSize / 2.0);

            for (Position pos : path) {
                path2D.lineTo(offsetX + pos.getX() * cellSize + cellSize / 2.0, offsetY + pos.getY() * cellSize + cellSize / 2.0);
            }
            g2.draw(path2D);
        }
    }


    public int getCellSize() {
        return cellSize;
    }

    public Algoritham getAlgoritham() {
        return algoritham;
    }

    public void setAlgoritham(Algoritham algoritham) {
        this.algoritham = algoritham;
    }
}

