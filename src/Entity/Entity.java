package Entity;
import Entity.EnumType.FamilyType;
import Entity.EnumType.StaticType;
import Entity.EnumType.TargetType;
import GameMap.MapSetting.Coordinates;

abstract public class Entity {

    // to private final !

    protected Coordinates coordinates;
    public final FamilyType type;
    public final TargetType target;
    public final StaticType staticEntity;

    public Entity(Coordinates coordinates, FamilyType type, TargetType target, StaticType staticEntity) {
        this.coordinates = coordinates;
        this.type = type;
        this.target = target;
        this.staticEntity = staticEntity;
    }

    public FamilyType getType() {
        return type;
    }

    public Coordinates getCoordintes() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public TargetType getTarget() {
        return target;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    @Override
    public String toString() {
        return type.toString();
    }
}

