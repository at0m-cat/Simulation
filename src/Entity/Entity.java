package Entity;
import MapSetting.*;

abstract public class Entity {
    // Корневой АБСТРАКТНЫЙ класс для всех существ
    // нельзя создавать объект на основе этого класса, только наследовать

    public Coordinates coordinates;
    public final Types type;
    public boolean isStatic;

    public Entity(Coordinates coordinates, Types type, boolean isStatic) {
        this.coordinates = coordinates;
        this.type = type;
        this.isStatic = isStatic;
    }

    public double distanceTo(Coordinates goal) {
        return Math.abs(coordinates.vertical - goal.vertical) + Math.abs(coordinates.horizontal - goal.horizontal);
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }
}

