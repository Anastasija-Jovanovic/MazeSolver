package controllers;

import algorithams.BestFirst;
import maze.MazeFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class FirstBestController extends AbstractAction {

    private MazeFrame mazeFrame;

    public FirstBestController(MazeFrame mazeFrame) {
        super("Best First");
        this.mazeFrame = mazeFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BestFirst bestFirst = new BestFirst(mazeFrame);
        mazeFrame.getMazePanel().setAlgoritham(bestFirst);
        mazeFrame.getMazePanel().getAlgoritham().findPath();
        mazeFrame.getFirstBestLbl().setText("Total: " + bestFirst.getVisitedPositions().size());
        mazeFrame.getMazePanel().repaint();
    }
}
