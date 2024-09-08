package Entity;

import EntityMotion.aStar;
import MapSetting.*;

import java.util.List;
import java.util.Set;

abstract public class Creature extends Entity {

    protected double speed; // клетки в секунду
    protected double hp; // здоровье

    public Creature(Coordinates coordinates, Types type, double speed, double hp) {
        super(coordinates, type, false);
        this.speed = speed;
        this.hp = hp;
    }



    private void setPosition(Coordinates newCoordinates) {
        this.coordinates = newCoordinates;
    }

    protected abstract Set<CoordinatesShift> getCreatureMoves();


    public void makeMove(GameMap map, List<Creature> creatures) {
        Creature nearestTarget = findNearestGoal(creatures);

        if (nearestTarget == null) {
            System.out.println("Нет доступной цели для движения.");
            return;
        }

        aStar pathfinder = new aStar();
        List<Coordinates> path = pathfinder.aStarSearch(map, this.coordinates, nearestTarget.coordinates);

        if (!path.isEmpty() && path.size() > 1) {
            setPosition(path.get(1));
        }
    }

    public Creature findNearestGoal(List<Creature> creatures) {
        Creature nearest = null;
        double minDistance = Double.MAX_VALUE;
        for (Creature creature : creatures) {
            double distance = distanceTo(creature.getCoordinates());
            if (distance < minDistance) {
                minDistance = distance;
                nearest = creature;
            }
        }
        return nearest;
    }
}
