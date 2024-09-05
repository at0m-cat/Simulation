package Entity;
import MapSetting.*;

public class Rock extends Entity {

    // статичный объект


    public Rock(Coordinates coordinates) {
        super(coordinates, Types.Rock, true);
    }
}
