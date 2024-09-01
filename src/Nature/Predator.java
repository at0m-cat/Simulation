package Nature;

import Simulation.Map;

public class Predator extends Creature {

    // Хищник
    // - переместиться (в сторону травоядного - к жертве)
    // - атаковать травоядное. ХП травоядного уменьшается на силу атаки хищника,
    // если значение ХП травоядного уменьшается до 0, то травоядное исчезает.

    private double attackPower;

    public Predator(int x, int y, double speed, double hp, double attackPower) {
        super(x, y, speed, hp);
        this.attackPower = attackPower;
    }

    @Override
    public void decreaseHp(double amount) {
        super.decreaseHp(amount);
    }

    @Override
    public void makeMove(Map map) {

    }
}
