package Entity.Objects;

import Actions.Murder;
import Entity.Creature;
import Entity.Entity;
import Entity.EnumType.FamilyType;
import Entity.EnumType.TargetType;
import GameMap.MapSetting.Coordinates;
import GameMap.MapSetting.GameMap;

public class Predator extends Creature {

    private double attackPower;


    public Predator(Coordinates coordinates) {

        super(coordinates, FamilyType.Predator, TargetType.NO);
        this.hp = 100;
        this.attackPower = 20;
        this.satiety = 100;
        this.speed = 1;

    }

    public void setAttackPower(double attackPowerPercent) {
        this.attackPower = attackPowerPercent;
    }

    public double getAttackPower() {
        return attackPower;
    }


    @Override
    protected void contactToTarget(Entity entityTarget, GameMap gameMap) {

        Creature target = (Creature) entityTarget;

        if (isPepful(satiety)) {
            return;
        }

        if (target.getHp() <= attackPower) {
            Murder murder = new Murder(gameMap, target.getCoordintes());
            murder.execute(gameMap);
            satiety += 20;
            return;
        }
        target.setHp(target.getHp() - attackPower);
        satiety += 2;


        super.contactToTarget(entityTarget, gameMap);
    }

    @Override
    public boolean isDead() {
        return this.hp <= 0;
    }

    @Override
    public boolean isFullHp() {
        return hp >= 100;
    }

    @Override
    public void makeMove(GameMap map) {
        becomeEnergetic();
        motionCounter();
        super.makeMove(map);
    }

    @Override
    public boolean isValidTarget(TargetType targetType) {
        return targetType == TargetType.TargetForPredator;
    }

    @Override
    public boolean isPepful(int satiety) {
        return satiety > 80;
    }

    @Override
    public void motionCounter() {
        satiety -= 5;
        this.hp -= 5;
    }

    @Override
    public void becomeEnergetic() {
        if (satiety < 10) {
            speed = 2;
            this.hp -= 5;
        } else {
            speed = 1;
        }
    }

    public int getSatiety() {
        return satiety;
    }
}
