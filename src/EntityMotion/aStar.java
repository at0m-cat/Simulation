package EntityMotion;
import MapSetting.Coordinates;
import MapSetting.GameMap;
import java.util.*;

public class aStar {

    public int heuristic(Coordinates from, Coordinates to) {
        return Math.abs(from.horizontal - to.horizontal) + Math.abs(from.vertical - to.vertical);
    }

    public ArrayList<Coordinates> constructPath(Node node) {
        ArrayList<Coordinates> path = new ArrayList<>();
        while (node != null) {
            path.add(node.coordinates);
            node = node.parent;
        }
        Collections.reverse(path);
        path.remove(path.getFirst());
        return path;
    }

    public List<Coordinates> getNeighbours(Coordinates coordinates, GameMap map) {
        List<Coordinates> neighbours = new ArrayList<>();

        int[][] shifts = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] shift : shifts) {
            int newHorizontal = coordinates.horizontal + shift[0];
            int newVertical = coordinates.vertical + shift[1];
            Coordinates neighbor = new Coordinates(newHorizontal, newVertical);

            if (map.isSquareEmptyForMove(neighbor) ) {
                neighbours.add(neighbor);

            }
        }
        return neighbours;
    }

    public ArrayList<Coordinates> shortestPath(Coordinates from, Coordinates to, GameMap map) {

        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingDouble(Node::getF));
        Map<Coordinates, Double> gScore = new HashMap<>(); // Минимальная стоимость пути до каждой координаты
        Set<Coordinates> closedList = new HashSet<>();

        Node startNode = new Node(from, null, 0, heuristic(from, to));
        openList.add(startNode);
        gScore.put(from, 0.0);

        while (!openList.isEmpty()) {
            Node currentNode = openList.poll();
            Coordinates currentCoordinates = currentNode.coordinates;

            if (currentCoordinates.equals(to)) {
                return constructPath(currentNode);
            }

            closedList.add(currentCoordinates);

            for (Coordinates neighbor : getNeighbours(currentCoordinates, map)) {
                if (closedList.contains(neighbor)) {
                    continue;
                }

                double tentativeG = currentNode.g + 1;

                if (!gScore.containsKey(neighbor) || tentativeG < gScore.get(neighbor)) {
                    gScore.put(neighbor, tentativeG);
                    Node neighborNode = new Node(neighbor, currentNode, tentativeG, tentativeG + heuristic(neighbor, to));

                    if (!openList.contains(neighborNode)) {
                        openList.add(neighborNode);
                    } else {
                        openList.remove(neighborNode);
                        openList.add(neighborNode);
                    }
                }
            }
        }
        return new ArrayList<>();
    }

    private static class Node {
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

        public double getF() {
            return f;
        }
    }
}