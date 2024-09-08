package Entity;
import EntityMotion.aStar;
import MapSetting.*;

import java.time.chrono.HijrahDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Predator extends Creature {

    // Хищник
    // - переместиться (в сторону травоядного - к жертве)
    // - атаковать травоядное. ХП травоядного уменьшается на силу атаки хищника,
    // если значение ХП травоядного уменьшается до 0, то травоядное исчезает.

    private double attackPower;

    public Predator(Coordinates coordinates, double speed, double hp, double attackPower) {
        super(coordinates, Types.Predator, speed, hp);
        this.attackPower = attackPower;
    }

    public void setPosition(Coordinates newCoordinates) {
        this.coordinates = newCoordinates;
    }

    public Set<CoordinatesShift> getCreatureMoves(){
        return null;
    }


    @Override
    public void makeMove(GameMap map, List<Creature> creatures) {
        List<Creature> allCreatures = map.getAllCreatures();

        List<Creature> herbivores = new ArrayList<>();
        for (Creature c : allCreatures) {
            if (c instanceof Herbivore) {
                herbivores.add(c);
            }
        }

        if (!herbivores.isEmpty()) {
            Creature nearestHerbivore = findNearestGoal(herbivores);
            if (nearestHerbivore != null) {
                aStar pathfinder = new aStar();
                List<Coordinates> path = pathfinder.aStarSearch(map, this.coordinates, nearestHerbivore.getCoordinates());

                if (!path.isEmpty() && path.size() > 1) {
                    setPosition(path.get(1)); // Двигаемся к следующей позиции
                }
            }
        } else {
            System.out.println("Нет травоядных для преследования.");
        }
    }
}
