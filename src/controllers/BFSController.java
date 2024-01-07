package controllers;

import algorithams.BFS;
import maze.MazeFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BFSController extends AbstractAction {

    private MazeFrame mazeFrame;

    public BFSController(MazeFrame mazeFrame) {
        super("BFS");
        this.mazeFrame = mazeFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BFS bfs = new BFS(mazeFrame);
        mazeFrame.getMazePanel().setAlgoritham(bfs);
        mazeFrame.getMazePanel().getAlgoritham().findPath();
        mazeFrame.getBfsLbl().setText("Total: " + bfs.getVisitedPositions().size());
        mazeFrame.getMazePanel().repaint();

    }
}
