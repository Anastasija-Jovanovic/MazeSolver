package maze;

public class Cell {

    private int[] walls = {1, 1, 1, 1}; // gore, desno, dole, levo

    private int x;
    private int y;

    //gleda da li su svi zidovi tu ili ne
    public boolean checkWalls() {
        if (walls[0] == 1 && walls[1] == 1 && walls[2] == 1 && walls[3] == 1) {
            return true;
        } else {
            return false;
        }
    }

    public int[] getWalls() {
        return walls;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
