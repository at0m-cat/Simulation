package Entity;
import MapSetting.*;

public class Predator extends Creature {

    // Хищник
    // - переместиться (в сторону травоядного - к жертве)
    // - атаковать травоядное. ХП травоядного уменьшается на силу атаки хищника,
    // если значение ХП травоядного уменьшается до 0, то травоядное исчезает.

    private double attackPower;

    public Predator(Coordinates coordinates, double speed, double hp, double attackPower) {
        super(coordinates, Types.Predator, speed, hp);
        this.attackPower = attackPower;
    }


}
