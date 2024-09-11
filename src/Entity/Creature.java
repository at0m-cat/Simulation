package Entity;

//import EntityMotion.aStar;
import EntityMotion.aStar;
import MapSetting.*;

import java.util.*;

abstract public class Creature extends Entity {

    protected int speed; // клетки в секунду
    protected double hp; // здоровье

    public Creature(Coordinates coordinates, FamilyType type, Target target, int speed, double hp) {
        super(coordinates, type, target, Static.NO );
        this.speed = speed;
        this.hp = hp;
    }

    private boolean isSquareAvailableForMove(Coordinates coordinates, GameMap map) {
        return map.isSquareEmptyForMove(coordinates);
    }


    protected Set<CoordinatesShift> getCreatureMoves(int speed) {

        Set<CoordinatesShift> moves = new HashSet<>();
        int[][] deltas = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for (int[] delta : deltas) {
            for (int i = 1; i <= speed; i++){
                moves.add(new CoordinatesShift(delta[0]*i, delta[1]*i));
            }
        }


//            new CoordinatesShift()



//        for (int i = 0)

        // написать цикл по установке шагов, включить параметр скорости = shift * speed




//        return new HashSet<>(Arrays.asList(
//                new CoordinatesShift(1, 0),
//                new CoordinatesShift(-1, 0),
//                new CoordinatesShift(0, 1),
//                new CoordinatesShift(0, -1)
//        ));
        return moves;
    }

    public ArrayList<Coordinates> getAvailableMoves(GameMap map) {

        // проверяет возможность хода

        // todo: Пересмотреть сдвиги координат


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

    protected abstract void makeMove(GameMap map);

}
