package controllers;

import algorithams.AStar;
import maze.MazeFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AStarController extends AbstractAction {

    private MazeFrame mazeFrame;

    public AStarController(MazeFrame mazeFrame) {
        super("A*");
        this.mazeFrame = mazeFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AStar aStar = new AStar(mazeFrame);
        mazeFrame.getMazePanel().setAlgoritham(aStar);
        mazeFrame.getMazePanel().getAlgoritham().findPath();
        mazeFrame.getaStarLbl().setText("Total: " + aStar.getVisitedPositions().size());
        mazeFrame.getMazePanel().repaint();
    }
}
