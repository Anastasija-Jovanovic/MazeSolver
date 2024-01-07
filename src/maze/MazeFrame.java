package maze;

import controllers.*;

import javax.swing.*;
import java.awt.*;

public class MazeFrame extends JFrame {
    private MazeGenerator mazeGenerator;
    private MazePanel mazePanel;
    private JLabel dfsLbl = new JLabel("DFS");
    private JLabel bfsLbl = new JLabel("BFS");
    private JLabel aStarLbl = new JLabel("A*");
    private JLabel firstBestLbl = new JLabel("First Best");


    public MazeFrame(int mazeWidth, int mazeHeight, int cellSize) {
        mazeGenerator = new MazeGenerator(mazeWidth, mazeHeight);
        mazePanel = new MazePanel(cellSize, this);
        init();
    }

    private void init() {
        System.out.println(getMazePanel());

        setTitle("Maze");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        setSize(mazeGenerator.getWidth() * mazePanel.getCellSize() + 150, mazeGenerator.getHeight() * mazePanel.getCellSize() + 70);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

        mainPanel.setBackground(Color.WHITE);
        mainPanel.add(mazePanel);

        JPanel algorithmsPanel = new JPanel();
        algorithmsPanel.setLayout(new BoxLayout(algorithmsPanel, BoxLayout.Y_AXIS));
        algorithmsPanel.setPreferredSize(new Dimension(120, 500));

        dfsLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton dfsButton = new JButton("DFS");
        dfsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        dfsButton.setAction(new DFSController(this));

        bfsLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton bfsButton = new JButton("BFS");
        bfsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        bfsButton.setAction(new BFSController(this));

        aStarLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton aStarButton = new JButton("A*");
        aStarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        aStarButton.setAction(new AStarController(this));

        firstBestLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton firstBestButton = new JButton("Best First");
        firstBestButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstBestButton.setAction(new FirstBestController(this));

        JButton newMazeBtn = new JButton("New Maze");
        newMazeBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        newMazeBtn.setAction(new MazeGeneratorController(this));


        algorithmsPanel.add(aStarButton);
        algorithmsPanel.add(aStarLbl);
        algorithmsPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        algorithmsPanel.add(dfsButton);
        algorithmsPanel.add(dfsLbl);
        algorithmsPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        algorithmsPanel.add(bfsButton);
        algorithmsPanel.add(bfsLbl);
        algorithmsPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        algorithmsPanel.add(firstBestButton);
        algorithmsPanel.add(firstBestLbl);

        algorithmsPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        algorithmsPanel.add(newMazeBtn);


        algorithmsPanel.setBackground(Color.WHITE);
        mainPanel.add(algorithmsPanel);

        add(mainPanel);
        setLocationRelativeTo(null);

    }

    public MazeGenerator getMazeGenerator() {
        return mazeGenerator;
    }

    public MazePanel getMazePanel() {
        return mazePanel;
    }

    public JLabel getDfsLbl() {
        return dfsLbl;
    }

    public JLabel getBfsLbl() {
        return bfsLbl;
    }

    public JLabel getaStarLbl() {
        return aStarLbl;
    }

    public JLabel getFirstBestLbl() {
        return firstBestLbl;
    }
}
