package EntityMotion;

import MapSetting.*;

import java.util.*;

public class aStar {

    private double calculateDistance(Coordinates start, Coordinates end) {
        return Math.abs(start.horizontal - end.horizontal) + Math.abs(start.vertical - end.vertical);
    }

    private List<Coordinates> constructPath(Node node) {
        List<Coordinates> path = new ArrayList<>();
        while (node != null) {
            path.add(node.coordinates);
            node = node.parent;
        }
        Collections.reverse(path);
        return path;
    }

    private List<Coordinates> getNeighbors(Coordinates coordinates, GameMap map) {
        List<Coordinates> neighbors = new ArrayList<>();
        int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] delta : deltas) {
            int newHorizontal = coordinates.horizontal + delta[0];
            int newVertical = coordinates.vertical + delta[1];

            Coordinates neighbor = new Coordinates(newHorizontal, newVertical);

            if (map.isValidCoordinate(neighbor) && !map.isSquareEmpty(neighbor)) {
                neighbors.add(neighbor);
            }
        } return neighbors;
    }


    public List<Coordinates> aStarSearch(GameMap map, Coordinates start, Coordinates goal) {
        PriorityQueue<Node> openList = new PriorityQueue<>();
        Set<Coordinates> closedList = new HashSet<>();

        Node startNode = new Node(start, null, 0, calculateDistance(start, goal));
        openList.add(startNode);

        while (!openList.isEmpty()) {
            Node currentNode = openList.poll();
            Coordinates currentCoordinates = currentNode.coordinates;

            if (currentCoordinates.equals(goal)) {
                return constructPath(currentNode);
            }
            closedList.add(currentCoordinates);

            for (Coordinates neighbor : getNeighbors(currentCoordinates, map)) {
                if (closedList.contains(neighbor)) {
                    continue;
                }
                double tentativeG = currentNode.g + 1;
                Node neighborNode = new Node(neighbor, currentNode, tentativeG, calculateDistance(neighbor, goal));
                if (!openList.contains(neighborNode)) {
                    openList.add(neighborNode);
                } else {
                    for (Node node : openList) {
                        if (node.coordinates.equals(neighbor) && tentativeG < node.g) {
                            node.parent = currentNode;
                            node.g = tentativeG;
                        }
                    }
                }
            }
        } return Collections.emptyList();
    }



}
