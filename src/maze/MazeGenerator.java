package maze;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeGenerator {

    private int width; // sizeX
    private int height; //sizeY
    private Cell[][] cells;


    public MazeGenerator(int width, int height) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        initCells();
        generateMaze();

    }

    public void createNewMaze() {
        initCells();
        generateMaze();
    }


    //pravi cellove prazne
    private void initCells() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j] = new Cell();
                cells[i][j].setX(i);
                cells[i][j].setY(j);
            }
        }
    }

    private void generateMaze() {

        Random random = new Random();
        int x = random.nextInt(width);
        int y = random.nextInt(height);

        Stack<Cell> cellStack = new Stack<Cell>();
        int totalCells = width * height;
        int visitedCells = 1;
        Cell curentCell = cells[x][y];

        ArrayList<Vertex> neighborCellList = new ArrayList<Vertex>();
        Vertex tmpVertex;

        while (visitedCells < totalCells) {
            neighborCellList.clear();

            tmpVertex = new Vertex(); // prani sve atribute u vertex
            // mozemo da idemo na gore i svi walls su up tj da li je cell bio posecen
            if (y - 1 >= 0 && cells[x][y - 1].checkWalls()) {  // potencijalna opcija za secenje zida izmedju polja i polja iznad njega
                tmpVertex.setX1(x);
                tmpVertex.setY1(y);
                tmpVertex.setX2(x);
                tmpVertex.setY2(y - 1);
                tmpVertex.setWall1(0);
                tmpVertex.setWall2(2);
                neighborCellList.add(tmpVertex);
            }

            // moze da ide na dole =||=
            tmpVertex = new Vertex(); // prani sve atribute u vertex
            if (y + 1 < height && cells[x][y + 1].checkWalls()) {
                tmpVertex.setX1(x);
                tmpVertex.setY1(y);
                tmpVertex.setX2(x);
                tmpVertex.setY2(y + 1);
                tmpVertex.setWall1(2);
                tmpVertex.setWall2(0);
                neighborCellList.add(tmpVertex); // dodaje neigbora na listu
            }

            // moze da ide na levo =||=
            tmpVertex = new Vertex(); // prani sve atribute u vertex
            if (x - 1 >= 0 && cells[x - 1][y].checkWalls()) {
                tmpVertex.setX1(x);
                tmpVertex.setY1(y);
                tmpVertex.setX2(x - 1);
                tmpVertex.setY2(y);
                tmpVertex.setWall1(3);
                tmpVertex.setWall2(1);
                neighborCellList.add(tmpVertex); // dodaje neigbora na listu
            }
            // moze da ide na desno =||=
            tmpVertex = new Vertex(); // prani sve atribute u vertex
            if (x + 1 < width && cells[x + 1][y].checkWalls()) {
                tmpVertex.setX1(x);
                tmpVertex.setY1(y);
                tmpVertex.setX2(x + 1);
                tmpVertex.setY2(y);
                tmpVertex.setWall1(1);
                tmpVertex.setWall2(3);
                neighborCellList.add(tmpVertex); // dodaje neigbora na listu
            }

            //da li je barem jedan od suseda bio ne posecen
            if (neighborCellList.size() >= 1) {
                // random bira jednog od suseda
                int rand1 = random.nextInt(neighborCellList.size());
                tmpVertex = neighborCellList.get(rand1);

                //sece zodove od izabranog suseda
                cells[tmpVertex.getX1()][tmpVertex.getY1()].getWalls()[tmpVertex.getWall1()] = 0;
                cells[tmpVertex.getX2()][tmpVertex.getY2()].getWalls()[tmpVertex.getWall2()] = 0;

                cellStack.push(curentCell);

                curentCell = cells[tmpVertex.getX2()][tmpVertex.getY2()];

                visitedCells++;

            } else {
                // vracamo se za jedan u nazad
                curentCell = cellStack.pop();
            }

            x = curentCell.getX();
            y = curentCell.getY();

        }


//        cells[0][0].getWalls()[3] = 0;
//        cells[width-1][height-1].getWalls()[1] = 0;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Cell[][] getCells() {
        return cells;
    }
}
