package Nature;

import Simulation.Map;

public class Herbivore extends Creature{

    // травоядное
    // стремятся найти ресурс (траву)
    // могут сделать ход в сторону травы, либо на ее поглощение

    public Herbivore(int x, int y, double speed, double hp){
        super(x, y, speed, hp);
    }

    @Override
    public void decreaseHp(double amount) {
        super.decreaseHp(amount);
    }

    @Override
    public void makeMove(Map map) {

    }
}
