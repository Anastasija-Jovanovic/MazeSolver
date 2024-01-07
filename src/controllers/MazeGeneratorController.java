package controllers;

import maze.MazeFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MazeGeneratorController extends AbstractAction {

    private MazeFrame mazeFrame;


    public MazeGeneratorController(MazeFrame mazeFrame) {
        super("New Maze");
        this.mazeFrame = mazeFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mazeFrame.getMazePanel().setAlgoritham(null);
        mazeFrame.getMazeGenerator().createNewMaze();
        mazeFrame.getDfsLbl().setText("DFS");
        mazeFrame.getBfsLbl().setText("BFS");
        mazeFrame.getaStarLbl().setText("A*");
        mazeFrame.getFirstBestLbl().setText("Best First");
        mazeFrame.getMazePanel().repaint();
    }
}
