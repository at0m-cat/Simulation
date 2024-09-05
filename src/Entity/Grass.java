package Entity;
import MapSetting.*;

import java.util.TreeMap;

public class Grass extends Entity{

    // ресурс для травоядных

    public Grass(Coordinates coordinates) {
        super(coordinates, Types.Grass, true);

    }
}
