package Entity;

import EntityMotion.aStar;
import MapSetting.*;

import java.util.*;

abstract public class Creature extends Entity {

    protected int speed; // клетки в секунду
    protected double hp; // здоровье

    public Creature(Coordinates coordinates, FamilyType type, Target target, int speed, double hp) {
        super(coordinates, type, target, Static.NO);
        this.speed = speed;
        this.hp = hp;
    }

    protected void makeMove(GameMap map) {

        if (!isTargetAlive(map)) {
            return;
        }

        if (!isPath(map)) {
            return;
        }

        int step = getStepMove();
        ArrayList<Coordinates> path = getPathToTarget(map);

        if (path.size() > step) {
            map.moveCreature(coordinates, path.get(step));
        } else {
            map.moveCreature(coordinates, path.getLast());
        }

    }

    private ArrayList<Coordinates> getPathToTarget(GameMap map) {
        aStar star = new aStar();
        ArrayList<Coordinates> path = new ArrayList<>();

        if (this instanceof Predator) {
            ArrayList<Herbivore> targets = getCreatureTargets(map);
            path = star.shortestPath(coordinates, targets.getFirst().coordinates, map);
        } else if (this instanceof Herbivore) {
            ArrayList<Grass> targets = getCreatureTargets(map);
            path = star.shortestPath(coordinates, targets.getFirst().coordinates, map);
        }

        return path;
    }

    private <T extends Entity> ArrayList<T> getCreatureTargets(GameMap map) {
        ArrayList<T> targets = new ArrayList<>();

        if (this instanceof Predator) {
            targets = (ArrayList<T>) map.getAllHerbivore();

        } else if (this instanceof Herbivore) {
            targets = (ArrayList<T>) map.getAllGrass();
        }
        targets.sort(Comparator.comparingDouble(t -> coordinates.distanceTo(t)));

        return targets;
    }

    private int getStepMove() {
        int step = 1;

        if (speed > step) {
            step = speed - 1;
            return step;
        }
        return step;
    }

    private boolean isPath(GameMap map) {
        return !getPathToTarget(map).isEmpty();
    }

    private boolean isTargetAlive(GameMap map) {

        if (this instanceof Predator) {
            return !map.getAllHerbivore().isEmpty();

        }
        if (this instanceof Herbivore) {
            return !map.getAllGrass().isEmpty();
        }

        return false;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

}
