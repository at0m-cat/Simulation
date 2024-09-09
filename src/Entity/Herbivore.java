package Entity;

import MapSetting.*;


public class Herbivore extends Creature implements Comparable<Herbivore> {


    public Herbivore(Coordinates coordinates, double speed, double hp) {
        super(coordinates, FamilyType.Herbivore, Target.YES, speed, hp);
    }


    @Override
    public int compareTo(Herbivore o) {
        return Math.abs((coordinates.horizontal - o.coordinates.horizontal)
                + (coordinates.vertical - o.coordinates.vertical));
    }


    @Override
    protected void makeMove(GameMap map) {

        // написать логику

    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getHp() {
        return hp;
    }
}
