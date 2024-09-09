package Entity;

//import EntityMotion.aStar;
import MapSetting.*;

import java.util.*;

abstract public class Creature extends Entity {

    protected double speed; // клетки в секунду
    protected double hp; // здоровье

    public Creature(Coordinates coordinates, Types type, double speed, double hp) {
        super(coordinates, type, false);
        this.speed = speed;
        this.hp = hp;
    }


    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    private boolean isSquareAvailableForMove(Coordinates coordinates, GameMap map) {
        return map.isSquareEmpty(coordinates);
    }

    protected Set<CoordinatesShift> getCreatureMoves() {
        return new HashSet<>(Arrays.asList(
                new CoordinatesShift(1, 0),
                new CoordinatesShift(-1, 0),
                new CoordinatesShift(0, 1),
                new CoordinatesShift(0, -1)
        ));
    }

    public ArrayList<Coordinates> getAvailableMoves(GameMap map) {
//        Set<Coordinates> result = new HashSet<>();
        ArrayList<Coordinates> moves = new ArrayList<>();
        for (CoordinatesShift shift : getCreatureMoves()) {
            if (coordinates.canShift(shift)) {
                Coordinates newCoordinates = coordinates.shift(shift);

                if (isSquareAvailableForMove(newCoordinates, map)) {
//                    result.add(newCoordinates);
                    moves.add(newCoordinates);
                }
            }
        }

        return moves;
    }


    protected abstract void makeMove(GameMap map);

}
