package Entity;

import MapSetting.*;


public class Herbivore extends Creature implements Comparable<Herbivore> {


    public Herbivore(Coordinates coordinates, int speed, double hp) {
        super(coordinates, FamilyType.Herbivore, Target.YES, speed, hp);
    }


    @Override
    public int compareTo(Herbivore o) {
        return Math.abs((coordinates.horizontal - o.coordinates.horizontal)
                + (coordinates.vertical - o.coordinates.vertical));
    }


    @Override
    public void makeMove(GameMap map) {

        // написать логику

    }
}
