package Entity.EntityMotion;

public interface MotionController {

    abstract void motionCounter(); // считает ходы
    abstract void becomeEnergetic(); // тратить хп за ход
    abstract boolean isPepful(int satiety);

}
