package algorithams;

public class HierarchyOfBestFirst implements Comparable<HierarchyOfBestFirst> {

    private HierarchyOfBestFirst parent;
    private int h;
    private Position position;

    public HierarchyOfBestFirst(HierarchyOfBestFirst parent, int h, Position position) {
        this.parent = parent;
        this.h = h;
        this.position = position;
    }

    @Override
    public int compareTo(HierarchyOfBestFirst o) {
        return Integer.compare(h, o.h);
    }

    public HierarchyOfBestFirst getParent() {
        return parent;
    }


    public Position getPosition() {
        return position;
    }

}
