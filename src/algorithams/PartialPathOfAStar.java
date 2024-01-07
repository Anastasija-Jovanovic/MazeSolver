package algorithams;

import java.util.ArrayList;
import java.util.List;

public class PartialPathOfAStar implements Comparable<PartialPathOfAStar> {

    private List<Position> path;
    private int f;

    public PartialPathOfAStar() {
        path = new ArrayList<>();
        f = 0;
    }


    @Override
    public String toString() {
        return "PartialPathOfAStar{" +
                "path=" + path +
                ", f=" + f +
                '}';
    }

    @Override
    public int compareTo(PartialPathOfAStar o) {
        return Integer.compare(f, o.f);
    }


    public List<Position> getPath() {
        return path;
    }

    public void setF(int f) {
        this.f = f;
    }
}
