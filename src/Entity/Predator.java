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

//         todo: Разбить этот метод на простые !!!


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

//        todo: сделать регулировку скорости: если 3кл\сек недоступно - сделать 2кл\сек, и тд


//        Coordinates next = path.getFirst();


        if (path.size() > step) {
            map.moveCreature(coordinates, path.get(step));
            System.out.println("УСКОРЕНИЕ");
        }
        else {
            map.moveCreature(coordinates, path.getLast());
            System.out.println("БЕЗ УСКОРЕНИЯ");
        }


    }


    public void setAttackPower(double attackPowerPercent) {
        this.attackPower = attackPowerPercent;
    }

    public double getAttackPower() {
        return attackPower;
    }
}
