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



        int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // Вверх, вниз, влево, вправо

        for (int[] delta : deltas) {
            int newHorizontal = coordinates.horizontal + delta[0];
            int newVertical = coordinates.vertical + delta[1];
            Coordinates neighbor = new Coordinates(newHorizontal, newVertical);

            // Проверяем, что новая координата валидна и не является препятствием
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

        // Начальный узел
        Node startNode = new Node(from, null, 0, heuristic(from, to));
        openList.add(startNode);
        gScore.put(from, 0.0);

        while (!openList.isEmpty()) {
            Node currentNode = openList.poll();
            Coordinates currentCoordinates = currentNode.coordinates;

            // Если достигли цели, строим путь
            if (currentCoordinates.equals(to)) {
                return constructPath(currentNode);
            }

            closedList.add(currentCoordinates);

            // Получаем всех соседей
            for (Coordinates neighbor : getNeighbours(currentCoordinates, map)) {
                if (closedList.contains(neighbor)) {
                    continue;
                }

                double tentativeG = currentNode.g + 1; // Стоимость до текущей клетки + 1

                // Если нашли более короткий путь к соседу
                if (!gScore.containsKey(neighbor) || tentativeG < gScore.get(neighbor)) {
                    gScore.put(neighbor, tentativeG);
                    Node neighborNode = new Node(neighbor, currentNode, tentativeG, tentativeG + heuristic(neighbor, to));

                    // Обновляем или добавляем узел в openList
                    if (!openList.contains(neighborNode)) {
                        openList.add(neighborNode);
                    } else {
                        openList.remove(neighborNode);
                        openList.add(neighborNode);
                    }
                }
            }
        }
        return new ArrayList<>(); // Если путь не найден, возвращаем пустой список
    }

    private static class Node {
        Coordinates coordinates;
        Node parent;
        double g; // Стоимость пути от начальной точки
        double f; // Общая стоимость пути (g + эвристика)

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