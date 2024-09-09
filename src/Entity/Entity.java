package Entity;
import MapSetting.*;

abstract public class Entity {

    public Coordinates coordinates;
    public final Types type;
    public boolean isStatic;

    public Entity(Coordinates coordinates, Types type, boolean isStatic) {
        this.coordinates = coordinates;
        this.type = type;
        this.isStatic = isStatic;
    }

    public Types getType() {
        return type;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }
}

