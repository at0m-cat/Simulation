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
        this.motionCounter = 0;
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


//        System.out.println(hp);

        if (isPepful(satiety)) {
            return;
        }

        if (target.getHp() <= attackPower) {
            target.setHp(0);
            Murder reproductionToDead = new Murder(gameMap, target.getCoordintes());
            reproductionToDead.execute(gameMap);
            satiety = 100;
            return;
        }

        satiety += 2;


        target.setHp(target.getHp() - attackPower);

        super.contactToTarget(entityTarget, gameMap);
    }

    @Override
    public boolean isDead() {
        return this.hp <= 0;
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
        motionCounter++;
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
