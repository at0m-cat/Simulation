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

    protected boolean isMove(GameMap map) {

        switch (getClass().getSimpleName()) {
            case "Predator" -> {
                ArrayList<Herbivore> herbivores = map.getAllHerbivore();
                if (herbivores.isEmpty()) {
                    return false;
                }
            }

            case "Herbivore" -> {
                ArrayList<Grass> grasses = map.getAllGrass();
                if (grasses.isEmpty()) {
                    return false;
                }
            }
            default -> {
                return false;
            }
        }
        return true;
    }

    protected abstract void makeMove(GameMap map);

}
