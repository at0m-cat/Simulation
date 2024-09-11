package Entity;

import EntityMotion.aStar;
import MapSetting.*;

import java.util.*;

public class Predator extends Creature {

    private double attackPower;


    public Predator(Coordinates coordinates, int speed, double hp, double attackPower) {
        super(coordinates, FamilyType.Predator, Target.NO, speed, hp);
        this.attackPower = attackPower;
    }

    @Override
    public ArrayList<Coordinates> getAvailableMoves(GameMap map) {
        return super.getAvailableMoves(map);
    }

    @Override
    public void makeMove(GameMap map) {

        // привязать значение скорости к передвижению
        int step = 0;

        if (speed != 0){
            step = speed - 1;
        }


        ArrayList<Herbivore> herbivores = map.getAllHerbivore();
        if (herbivores.isEmpty()) {
            System.out.println("Нет доступных травоядных для перемещения.");
            return;
        }

        Collections.sort(herbivores); // Сортируем по расстоянию до хищника
        aStar star = new aStar();

        // ! написать сортировку по целям
        ArrayList<Coordinates> path = star.shortestPath(coordinates, herbivores.get(0).coordinates, map);

        if (path.isEmpty()) {
            System.out.println("Нет доступного пути до цели");
            return;
        }


        Coordinates next = path.getFirst();

        if (path.size() <= step) {
            System.out.println("Движение с ускорением невозможно");
            map.moveCreature(coordinates, next);
            return;
        }
        Coordinates nextSpeed = path.get(step);

        if (getAvailableMoves(map).contains(nextSpeed)) {
            System.out.println("Перемещение к " + nextSpeed);
            map.moveCreature(coordinates, nextSpeed);
        } else {

            System.out.println("Следующий шаг заблокирован");
            map.moveCreature(coordinates, next);
        }

    }


    public void setAttackPower(double attackPowerPercent) {
        this.attackPower = attackPowerPercent;
    }

    public double getAttackPower() {
        return attackPower;
    }
}
