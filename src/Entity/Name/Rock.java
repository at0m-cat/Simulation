package Entity.Name;
import Entity.Entity;
import Entity.EnumType.FamilyType;
import Entity.EnumType.StaticType;
import Entity.EnumType.TargetType;
import GameMap.MapSetting.Coordinates;

public class Rock extends Entity {

    public Rock(Coordinates coordinates) {
        super(coordinates, FamilyType.Rock, TargetType.NO, StaticType.YES);
    }
}
