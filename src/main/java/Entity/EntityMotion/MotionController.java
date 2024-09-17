package Entity.EntityMotion;

public interface MotionController {

    abstract void motionCounter();
    abstract void becomeEnergetic();
    abstract boolean isPepful(int satiety);
    abstract boolean isDead();
    abstract boolean isFullHp();

}
