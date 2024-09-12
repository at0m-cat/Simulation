package Entity;

import MapSetting.*;

public class Predator extends Creature {

    private double attackPower;


    public Predator(Coordinates coordinates, int speed, double hp, double attackPower) {
        super(coordinates, FamilyType.Predator, TargetType.NO, speed, hp);
        this.attackPower = attackPower;
    }

    public void setAttackPower(double attackPowerPercent) {
        this.attackPower = attackPowerPercent;
    }

    public double getAttackPower() {
        return attackPower;
    }

    @Override
    public void makeMove(GameMap map) {
        super.makeMove(map);
    }
}
