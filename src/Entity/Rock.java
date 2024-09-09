package Entity;
import MapSetting.*;

public class Rock extends Entity {

    public Rock(Coordinates coordinates) {
        super(coordinates, FamilyType.Rock, Target.NO, Static.YES);
    }
}
