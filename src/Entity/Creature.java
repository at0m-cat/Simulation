package Entity;

import MapSetting.*;

public abstract class Creature  extends Entity{


    protected double speed; // клетки в секунду
    protected double hp; // здоровье
    protected final Types type;

    public Creature(Coordinates coordinates, Types type, double speed, double hp) {
        super(coordinates);
        this.speed = speed;
        this.hp = hp;
        this.type = type;
    }

}
