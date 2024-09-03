package Entity;
import MapSetting.*;


public class Herbivore extends Creature {

    // травоядное
    // стремятся найти ресурс (траву)
    // могут сделать ход в сторону травы, либо на ее поглощение

    private static int numbersType;

    public Herbivore(Coordinates coordinates, double speed, double hp) {
        super(coordinates, Types.Herbivore, speed, hp);
    }

}
