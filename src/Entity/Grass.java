package Entity;
import MapSetting.*;

public class Grass extends Entity implements Comparable<Grass>{


    public Grass(Coordinates coordinates) {
        super(coordinates, FamilyType.Grass, TargetType.TargetForHerbivore, StaticType.YES);
    }

    public int compareTo(Grass o) {
        return Math.abs((coordinates.horizontal - o.coordinates.horizontal)
                + (coordinates.vertical - o.coordinates.vertical));
    }
}
