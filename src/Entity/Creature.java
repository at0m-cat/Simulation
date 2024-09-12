package Entity;

//import EntityMotion.aStar;

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

    private boolean isSquareAvailableForMove(Coordinates coordinates, GameMap map) {
        return map.isSquareEmptyForMove(coordinates);
    }


    protected Set<CoordinatesShift> getCreatureMoves(int speed) {

        Set<CoordinatesShift> moves = new HashSet<>();
        int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] delta : deltas) {
            for (int i = 1; i <= speed; i++) {
                moves.add(new CoordinatesShift(delta[0] * i, delta[1] * i));
            }
        }

        return moves;
    }

    public ArrayList<Coordinates> getAvailableMoves(GameMap map) {
        ArrayList<Coordinates> moves = new ArrayList<>();

        for (CoordinatesShift shift : getCreatureMoves(speed)) {

            if (coordinates.canShift(shift)) {
                Coordinates newCoordinates = coordinates.shift(shift);

                if (isSquareAvailableForMove(newCoordinates, map)) {
                    moves.add(newCoordinates);
                }
            }
        }

        return moves;
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



    protected ArrayList<Coordinates> getPathToTarget(GameMap map) {
        aStar star = new aStar();
        ArrayList<Coordinates> path = new ArrayList<>();

        if (this instanceof Predator){
            ArrayList<Herbivore> targets = getCreatureTargets(map);
            path = star.shortestPath(coordinates, targets.getFirst().coordinates, map);
        }
        else if (this instanceof Herbivore){
            ArrayList<Herbivore> targets = getCreatureTargets(map);
            path = star.shortestPath(coordinates, targets.getFirst().coordinates, map);
        }

        return path;
    }

    protected int getStepMove(){
        int step = 1;

        if (speed > step){
            step = speed - 1;
            return step;
        }
        return step;
    }

    protected <T extends Entity> ArrayList<T> getCreatureTargets(GameMap map) {
        ArrayList<T> targets = new ArrayList<>();

        if (this instanceof Predator) {
            targets = (ArrayList<T>) map.getAllHerbivore();

        } else if (this instanceof Herbivore) {
            targets = (ArrayList<T>) map.getAllGrass();
        }
        targets.sort(Comparator.comparingDouble(t -> coordinates.distanceTo(t)));

        return targets;
    }

    protected boolean isPath(GameMap map){
        return !getPathToTarget(map).isEmpty();
    }

    protected boolean isMove(GameMap map) {

        if (this instanceof Predator) {
            return !map.getAllHerbivore().isEmpty();

        } else if (this instanceof Herbivore) {
            return !map.getAllGrass().isEmpty();
        }

        return false;
    }

    protected void makeMove(GameMap map){

        if (!isMove(map)){
            return;
        }

        if (!isPath(map)){
            return;
        }

        int step = getStepMove();
        ArrayList<Coordinates> path = getPathToTarget(map);

        if (path.size() > step) {
            map.moveCreature(coordinates, path.get(step));
            System.out.println("УСКОРЕНИЕ");
        }
        else {
            map.moveCreature(coordinates, path.getLast());
            System.out.println("БЕЗ УСКОРЕНИЯ");
        }

    }

}
