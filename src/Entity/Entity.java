package Entity;
import Entity.EnumType.FamilyType;
import Entity.EnumType.StaticType;
import Entity.EnumType.TargetType;
import GameMap.MapSetting.Coordinates;

abstract public class Entity {

    // to private final !

    protected Coordinates coordinates;
    public final FamilyType TYPE;
    public final TargetType TARGET_TYPE;
    public final StaticType STATIC_TYPE;

    public Entity(Coordinates coordinates, FamilyType type, TargetType target, StaticType staticEntity) {
        this.coordinates = coordinates;
        this.TYPE = type;
        this.TARGET_TYPE = target;
        this.STATIC_TYPE = staticEntity;
    }

    public Coordinates getCoordintes() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    @Override
    public String toString() {
        return TYPE.toString();
    }
}

