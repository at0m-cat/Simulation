package Entity.Objects;

import Entity.*;
import Entity.EnumType.FamilyType;
import Entity.EnumType.StaticType;
import Entity.EnumType.TargetType;
import GameMap.MapSetting.Coordinates;

public class DeadSouls extends Entity {

    public DeadSouls(Coordinates coordinates) {
        super(coordinates, FamilyType.DeadSouls, TargetType.NO, StaticType.YES);
    }
}
