package Entity.Objects;
import Entity.Entity;
import Entity.EnumType.FamilyType;
import Entity.EnumType.StaticType;
import Entity.EnumType.TargetType;
import GameMap.MapSetting.Coordinates;

public class Grass extends Entity implements Comparable<Grass>{


    public Grass(Coordinates coordinates) {
        super(coordinates, FamilyType.Grass, TargetType.TargetForHerbivore, StaticType.YES);
    }

    public int compareTo(Grass o) {
        return Math.abs((coordinates.horizontal - o.coordinates.horizontal)
                + (coordinates.vertical - o.coordinates.vertical));
    }
}
