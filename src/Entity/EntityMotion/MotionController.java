package Entity.EntityMotion;

public interface MotionController {


    // считать ходы
    // отнимать хп за ход
    // варьировать скорость перемещения от сытости





    abstract void motionCounter(); // считает ходы
    abstract void energyСonsumption(); // тратить хп за ход
    abstract boolean isPepful(int satiety);

    abstract void stop();




}
