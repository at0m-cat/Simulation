package Nature;

import Simulation.Map;

public class Herbivore extends Creature{

    // травоядное
    // стремятся найти ресурс (траву)
    // могут сделать ход в сторону травы, либо на ее поглощение

    private static int numbersType;

    public Herbivore(int x, int y, double speed, double hp){
        super(x, y, speed, hp);
        numbersType += 1;
        isQuantity = true;
    }

    @Override
    public void decreaseHp(double amount) {
        super.decreaseHp(amount);
        if (hp <= 0){

        }
    }

    @Override
    public void makeMove(Map map) {

    }

    @Override
    public String toString() {
        return super.toString() + "Количество представителей: " + numbersType;
    }
}
