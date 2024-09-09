package Entity;
import EntityMotion.aStar;
import MapSetting.*;
import java.util.*;

public class Predator extends Creature {

    private double attackPower;

    public Predator(Coordinates coordinates, double speed, double hp, double attackPower) {
        super(coordinates, Types.Predator, speed, hp);
        this.attackPower = attackPower;
    }

    public void setPosition(Coordinates newCoordinates) {
        this.coordinates = newCoordinates;
    }

    @Override
    public ArrayList<Coordinates> getAvailableMoves(GameMap map) {
        return super.getAvailableMoves(map);
    }

    @Override
    public void makeMove(GameMap map) {
        List<Coordinates> availableMoves = getAvailableMoves(map);
        ArrayList<Herbivore> herbivores = map.getAllHerbivore();
        Collections.sort(herbivores);

        // Проверить какая цель ближайшая
        // Создать отдельный класс, отправить туда массив целей
        // - посчитать расстояние до цели
        // - учесть препятствия
        // - вернуть шаг в сторону цели
    }

}
