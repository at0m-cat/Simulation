package Entity.Objects;

import Actions.Reborn;
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
    protected void contactToTarget(Entity entityTarget, GameMap gameMap) {


        if (!isPepful(satiety)){
            Reborn reborn  = new Reborn(gameMap);
            reborn.rebornGrass();
            return;
        }
        this.hp += 10;
        this.satiety += 2;
        super.contactToTarget(entityTarget, gameMap);
    }


    @Override
    public void makeMove(GameMap map) {
        becomeEnergetic();
        super.makeMove(map);
    }

    @Override
    public boolean isValidTarget(TargetType targetType) {
        return targetType == TargetType.TargetForHerbivore;
    }

    @Override
    public boolean isPepful(int satiety) {
        return satiety > 70;
    }

    @Override
    public void motionCounter() {


    }

    @Override
    public void becomeEnergetic() {
        this.hp -= this.speed * 2;

    }

    @Override
    public int compareTo(Herbivore o) {
        return Math.abs((coordinates.horizontal - o.coordinates.horizontal)
                + (coordinates.vertical - o.coordinates.vertical));
    }
}
