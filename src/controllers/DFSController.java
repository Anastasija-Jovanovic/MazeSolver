package controllers;

import algorithams.DFS;
import maze.MazeFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DFSController extends AbstractAction {

    private MazeFrame mazeFrame;

    public DFSController(MazeFrame mazeFrame) {
        super("DFS");
        this.mazeFrame = mazeFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DFS dfs = new DFS(mazeFrame);
        mazeFrame.getMazePanel().setAlgoritham(dfs);
        mazeFrame.getMazePanel().getAlgoritham().findPath();
        mazeFrame.getDfsLbl().setText("Total: " + dfs.getVisitedPositions().size());
        mazeFrame.getMazePanel().repaint();

    }
}
