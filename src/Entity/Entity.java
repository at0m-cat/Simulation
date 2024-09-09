package Entity;
import MapSetting.*;

abstract public class Entity {

    public Coordinates coordinates;
    public final FamilyType type;
    public final Target target;
    public final Static staticEntity;

    public Entity(Coordinates coordinates, FamilyType type, Target target, Static staticEntity) {
        this.coordinates = coordinates;
        this.type = type;
        this.target = target;
        this.staticEntity = staticEntity;
    }

    public FamilyType getType() {
        return type;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }
}

