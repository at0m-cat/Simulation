package Entity.Objects;

import Entity.Creature;
import Entity.Entity;
import Entity.EnumType.FamilyType;
import Entity.EnumType.TargetType;
import GameMap.MapSetting.Coordinates;
import GameMap.MapSetting.GameMap;


public class Herbivore extends Creature implements Comparable<Herbivore> {


    public Herbivore(Coordinates coordinates) {
        super(coordinates, FamilyType.Herbivore, TargetType.TargetForPredator);
        this.motionCounter = 0;
        this.satiety = 30;
        this.hp = 100;
        this.speed = 1;
    }

    @Override
    protected void contactToTarget(Entity entityTarget, GameMap gameMap) {

        if (isPepful(satiety)) {
            return;
        }

        gameMap.moveCreature(coordinates, entityTarget.getCoordinates());
        this.satiety += 10;
        this.hp += 10;


        super.contactToTarget(entityTarget, gameMap);
    }


    @Override
    public void makeMove(GameMap map) {

        becomeEnergetic();
        motionCounter();
        super.makeMove(map);
    }

    @Override
    public boolean isValidTarget(TargetType targetType) {
        return targetType == TargetType.TargetForHerbivore;
    }

    @Override
    public boolean isPepful(int satiety) {
        return satiety > 90;
    }

    @Override
    public boolean isDead() {
        return this.hp <= 0;
    }

    @Override
    public void motionCounter() {
        motionCounter++;
        this.satiety -= 1;
        this.hp -= 1;

    }

    @Override
    public void becomeEnergetic() {

        if (satiety < 10) {
            speed += 1;
            this.hp -= 2;
        } else {
            speed = 2;
        }

    }

    @Override
    public int compareTo(Herbivore o) {
        return Math.abs((coordinates.HORIZONTAL - o.coordinates.HORIZONTAL)
                + (coordinates.VERTICAL - o.coordinates.VERTICAL));
    }
}
