package Nature;

import Simulation.Map;

public abstract class Creature  extends Entity{

    protected double speed; // клетки в секунду
    protected double hp; // здоровье

    public Creature(int x, int y, double speed, double hp){
        super(x, y);
        this.speed = speed;
        this.hp = hp;
    }

    public void decreaseHp(double amount){
        this.hp -= amount;
    }

    public abstract void makeMove(Map map);

    public double getSpeed() {
        return speed;
    }

    public double getHp() {
        return hp;
    }

    @Override
    public String toString() {

        return "Класс: " + getClass().getSimpleName() + "\n"
                + super.toString() + "\n" +
               "Здоровье: " + hp + "\n" +
               "Скорость: " + speed + "\n";
    }



}
