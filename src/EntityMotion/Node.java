package EntityMotion;

import MapSetting.Coordinates;

public class Node implements Comparable<Node> {
    Coordinates coordinates;
    Node parent;
    double g;
    double h;

    public Node(Coordinates coordinates, Node parent, double g, double h) {
        this.coordinates = coordinates;
        this.parent = parent;
        this.g = g;
        this.h = h;
    }

    public double getF() {
        return h + g;
    }

    @Override
    public String toString() {
        return coordinates.toString();
    }

    @Override
    public int compareTo(Node o) {
        return Double.compare(this.getF(), o.getF());
    }
}
