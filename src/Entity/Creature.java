package Entity;

import Entity.EnumType.FamilyType;
import Entity.EnumType.StaticType;
import Entity.EnumType.TargetType;
import Entity.Objects.Grass;
import Entity.Objects.Herbivore;
import Entity.Objects.Predator;
import GameMap.EntityMotion.aStar;
import GameMap.MapSetting.Coordinates;
import GameMap.MapSetting.GameMap;

import java.util.*;

abstract public class Creature extends Entity {

    protected int speed; // клетки в секунду
    protected double hp; // здоровье

    public Creature(Coordinates coordinates, FamilyType type, TargetType target, int speed, double hp) {
        super(coordinates, type, target, StaticType.NO);
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

        ArrayList<Coordinates> path = getPathToTarget(map);

        if (path.size() > speed) {
            map.moveCreature(coordinates, path.get(speed));
        } else {
            map.moveCreature(coordinates, path.getLast());
        }

    }

    private ArrayList<Coordinates> getPathToTarget(GameMap map) {
        if (map.getEntityCoordinate(coordinates) == null) {
            return new ArrayList<>();
        }

        FamilyType type = map.getEntityCoordinate(coordinates).type;
        aStar star = new aStar(type);
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
