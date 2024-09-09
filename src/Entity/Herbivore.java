package Entity;

import MapSetting.*;


public class Herbivore extends Creature implements Comparable<Herbivore> {

    @Override
    public int compareTo(Herbivore o) {
        return Math.abs((coordinates.horizontal - o.coordinates.horizontal)
                + (coordinates.vertical - o.coordinates.vertical));
    }

    public Herbivore(Coordinates coordinates, double speed, double hp) {
        super(coordinates, Types.Herbivore, speed, hp);
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
