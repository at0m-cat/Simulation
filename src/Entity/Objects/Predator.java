package Entity.Objects;

import Entity.Creature;
import Entity.Entity;
import Entity.EnumType.FamilyType;
import Entity.EnumType.TargetType;
import GameMap.MapSetting.Coordinates;
import GameMap.MapSetting.GameMap;

public class Predator extends Creature {

    private double attackPower;


    public Predator(Coordinates coordinates, int speed, double hp, double attackPower) {
        super(coordinates, FamilyType.Predator, TargetType.NO, speed, hp);
        this.attackPower = attackPower;
        this.motionCounter = 0;
        this.satiety = 0;

    }

    public void setAttackPower(double attackPowerPercent) {
        this.attackPower = attackPowerPercent;
    }

    public double getAttackPower() {
        return attackPower;
    }

    @Override
    protected void toEat(Entity target) {
        System.out.println("Predator Eat");
        super.toEat(target);
    }

    @Override
    public void makeMove(GameMap map) {
        motionCounter();
        super.makeMove(map);
    }

    @Override
    public boolean isPepful(int satiety) {
        return false;
    }

    @Override
    public void motionCounter() {
        motionCounter++;
    }

    @Override
    public void energyСonsumption() {

    }

    @Override
    public void stop() {

    }
}
