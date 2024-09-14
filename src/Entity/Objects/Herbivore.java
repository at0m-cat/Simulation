package Entity.Objects;

import Entity.Creature;
import Entity.Entity;
import Entity.EnumType.FamilyType;
import Entity.EnumType.TargetType;
import GameMap.MapSetting.Coordinates;
import GameMap.MapSetting.GameMap;


public class Herbivore extends Creature implements Comparable<Herbivore> {


    public Herbivore(Coordinates coordinates, int speed, double hp) {
        super(coordinates, FamilyType.Herbivore, TargetType.TargetForPredator, speed, hp);
        this.motionCounter = 0;
        this.satiety = 0;
    }

    @Override
    protected void toEat(Entity target) {
        System.out.println("Herbivore eat");
        super.toEat(target);
    }

    @Override
    public void makeMove(GameMap map) {
        energyСonsumption();
        super.makeMove(map);
    }


    @Override
    public int compareTo(Herbivore o) {
        return Math.abs((coordinates.horizontal - o.coordinates.horizontal)
                + (coordinates.vertical - o.coordinates.vertical));
    }

    @Override
    public boolean isPepful(int satiety) {
        return false;
    }

    @Override
    public void motionCounter() {


    }

    @Override
    public void energyСonsumption() {
        this.hp -= this.speed;

    }

    @Override
    public void stop() {

    }
}
