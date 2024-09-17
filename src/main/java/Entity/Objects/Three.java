package Entity.Objects;
import Entity.Entity;
import Entity.EnumType.FamilyType;
import Entity.EnumType.StaticType;
import Entity.EnumType.TargetType;
import GameMap.MapSetting.Coordinates;

public class Three extends Entity {

    public Three(Coordinates coordinates) {
        super(coordinates, FamilyType.Three, TargetType.NO, StaticType.YES);
    }
}
