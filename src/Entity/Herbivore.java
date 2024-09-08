package Entity;
import MapSetting.*;

import java.util.Set;


public class Herbivore extends Creature {

    // травоядное
    // стремятся найти ресурс (траву)
    // могут сделать ход в сторону травы, либо на ее поглощение

    public Herbivore(Coordinates coordinates, double speed, double hp) {
        super(coordinates, Types.Herbivore, speed, hp);
    }

    public Set<CoordinatesShift>getAvailableMove(){
        return null;
    }

}
