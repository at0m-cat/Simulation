package GameMap.EntityMotion;

import GameMap.MapSetting.Coordinates;

class Node {
    Coordinates coordinates;
    Node parent;
    double g;
    double f;

    public Node(Coordinates coordinates, Node parent, double g, double f) {
        this.coordinates = coordinates;
        this.parent = parent;
        this.g = g;
        this.f = f;
    }

    double getF() {
        return f;
    }
}