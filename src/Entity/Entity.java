package Entity;
import MapSetting.*;

abstract public class Entity {

    public Coordinates coordinates;
    public final FamilyType type;
    public final TargetType target;
    public final StaticType staticEntity;

    public Entity(Coordinates coordinates, FamilyType type, TargetType target, StaticType staticEntity) {
        this.coordinates = coordinates;
        this.type = type;
        this.target = target;
        this.staticEntity = staticEntity;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }
}

