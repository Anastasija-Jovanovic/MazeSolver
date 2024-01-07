package maze;

import algorithams.Position;

public class Vertex {

    public Vertex() {
    }

    public Vertex(Position pos1, Position pos2) {
        this.x1 = pos1.getX();
        this.y1 = pos1.getY();
        this.x2 = pos2.getX();
        this.y2 = pos2.getY();
    }

    // kordinate prve tacke u maze-u
    private int x1;
    private int y1;


    //kordinate druge tacke u maze-u
    //tacke su na rastojanju od 1
    private int x2;
    private int y2;

    private int wall1;  // koji zid u tacki 1 kada se skloni bi povezao prvu i drugu tacku
    private int wall2; // isto samo koji zid bi povezao za drugu i prvu tacku

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getWall1() {
        return wall1;
    }

    public void setWall1(int wall1) {
        this.wall1 = wall1;
    }

    public int getWall2() {
        return wall2;
    }

    public void setWall2(int wall2) {
        this.wall2 = wall2;
    }
}
