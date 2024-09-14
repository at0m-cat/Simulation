package Entity;

import Entity.EnumType.FamilyType;
import Entity.EnumType.StaticType;
import Entity.EnumType.TargetType;
import Entity.Objects.Grass;
import Entity.Objects.Herbivore;
import Entity.Objects.Predator;
import GameMap.PathToTarget.PathToTarget;
import GameMap.PathToTarget.aStar;
import Entity.EntityMotion.MotionController;
import GameMap.MapSetting.Coordinates;
import GameMap.MapSetting.GameMap;

import java.util.*;

abstract public class Creature extends Entity implements MotionController {

    protected int speed; // клетки в секунду
    protected double hp; // здоровье

    protected int motionCounter;
    protected int satiety;

    public Creature(Coordinates coordinates, FamilyType type, TargetType target, int speed, double hp) {
        super(coordinates, type, target, StaticType.NO);
        this.speed = speed;
        this.hp = hp;
    }

    protected void toEat(Entity target) {

//        // если сожрали -> dead -> renderer череп (FamilyType DeadEntity)
//
//        TargetType target = target.target;
//
//        switch (target) {
//            case TargetType.TargetForPredator -> {
//                System.out.println(this + " съел " + target);
//            }
//
//            case TargetType.TargetForHerbivore -> {
//                System.out.println(this + " съел " + target);
//            }
//
//        }

    }

    protected void makeMove(GameMap map) {

        if (!isTargetAlive(map)) {
            return;
        }

//        if (!isPath(map)) {
//            return;
//        }

        PathToTarget pathToTarget = new PathToTarget(map, coordinates);
        ArrayList<Coordinates> path = pathToTarget.getPath();

        if (path.isEmpty()){
            return;
        }

        System.out.println("new path");

//        ArrayList<Coordinates> path = getPathToTarget(map);

        if (path.size() > speed + 1) {
            map.moveCreature(coordinates, path.get(speed));
        } else {

            // пересмотреть структуру

            if (isTargetEat(map, path.getLast())){
                toEat(map.getEntityCoordinate(path.getLast()));
                map.moveCreature(coordinates, path.getLast());
            }
        }

    }

    private boolean isTargetEat(GameMap map, Coordinates coordinates) {
        return map.getEntityCoordinate(coordinates) != null;
    }

//    private ArrayList<Coordinates> getPathToTarget(GameMap map) {
//
//        // пересмотреть структуру
//        // перенести в PathToTarget
//
//        if (map.getEntityCoordinate(coordinates) == null) {
//            return new ArrayList<>();
//        }
//
//        FamilyType type = map.getEntityCoordinate(coordinates).type;
//        aStar star = new aStar(type);
//        ArrayList<Coordinates> path = new ArrayList<>();
//
//        if (this instanceof Predator) {
//            ArrayList<Herbivore> targets = getTargets(map);
//            path = star.shortestPath(coordinates, targets.getFirst().coordinates, map);
//        } else if (this instanceof Herbivore) {
//            ArrayList<Grass> targets = getTargets(map);
//            path = star.shortestPath(coordinates, targets.getFirst().coordinates, map);
//        }
//
//        return path;
//    }

//    private <T extends Entity> ArrayList<T> getTargets(GameMap map) {
//        ArrayList<T> targets = new ArrayList<>();
//
//        if (this instanceof Predator) {
//            targets = (ArrayList<T>) map.getAllHerbivore();
//
//        } else if (this instanceof Herbivore) {
//            targets = (ArrayList<T>) map.getAllGrass();
//        }
//        targets.sort(Comparator.comparingDouble(t -> coordinates.distanceTo(t)));
//
//        return targets;
//    }

//    private boolean isPath(GameMap map) {
//        return !getPathToTarget(map).isEmpty();
//    }

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
