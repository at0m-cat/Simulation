package GameMap.PathToTarget;
import Entity.Entity;
import Entity.EntityMotion.ShiftsCreature;
import GameMap.MapSetting.Coordinates;
import GameMap.MapSetting.GameMap;
import java.util.*;

public class aStar {

    Entity activeCreature;

    public aStar(Entity activeCreature) {
       this.activeCreature = activeCreature;
    }

    private int heuristic(Coordinates from, Coordinates to) {
        return Math.abs(from.HORIZONTAL - to.HORIZONTAL) + Math.abs(from.VERTICAL - to.VERTICAL);
    }

    private ArrayList<Coordinates> constructPath(Node node) {
        ArrayList<Coordinates> path = new ArrayList<>();
        while (node != null) {
            path.add(node.coordinates);
            node = node.parent;
        }
        Collections.reverse(path);
        return path;
    }

    private List<Coordinates> getNeighbours(Coordinates coordinates, GameMap map) {
        List<Coordinates> neighbours = new ArrayList<>();

        ShiftsCreature shiftsCreature = new ShiftsCreature();

        int[][] shifts = shiftsCreature.getShifts();

        for (int[] shift : shifts) {
            int newHorizontal = coordinates.HORIZONTAL + shift[0];
            int newVertical = coordinates.VERTICAL + shift[1];
            Coordinates neighbor = new Coordinates(newHorizontal, newVertical);

            if (map.isSquareEmptyForMove(neighbor, activeCreature) ) {
                neighbours.add(neighbor);
            }
        }
        return neighbours;
    }

    public ArrayList<Coordinates> shortestPath(Coordinates from, Coordinates to, GameMap map) {

        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingDouble(Node::getF));
        Map<Coordinates, Double> gScore = new HashMap<>();
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


}