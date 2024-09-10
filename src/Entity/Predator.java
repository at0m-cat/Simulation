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



        ArrayList<Herbivore> herbivores = map.getAllHerbivore();
        if (herbivores.isEmpty()) {
            System.out.println("Нет доступных травоядных для перемещения.");
            return;
        }

        Collections.sort(herbivores); // Сортируем по расстоянию до хищника
        aStar star = new aStar();

        // ! написать сортировку по целям
        ArrayList<Coordinates> path = star.shortestPath(coordinates, herbivores.get(0).coordinates, map);

        if (path.isEmpty() || path.size() == 1) {
            System.out.println("Нет доступного пути до цели");
            return;
        }

        Coordinates nextStep = path.get(1);


        if (getAvailableMoves(map).contains(nextStep)) {
            System.out.println("Перемещение к " + nextStep);
            map.moveCreature(coordinates, nextStep);
        } else {
            System.out.println("Следующий шаг заблокирован");
        }
    }


    public void setAttackPower(double attackPowerPercent) {
        this.attackPower = attackPowerPercent;
    }

    public double getAttackPower() {
        return attackPower;
    }
}
