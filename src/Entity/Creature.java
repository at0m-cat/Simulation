package Entity;
import MapSetting.*;

public abstract class Creature  extends Entity{


    protected double speed; // клетки в секунду
    protected double hp; // здоровье

    public Creature(Coordinates coordinates, Types type, double speed, double hp) {
        super(coordinates, type, false);
        this.speed = speed;
        this.hp = hp;
    }
}
