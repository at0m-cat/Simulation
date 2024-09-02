package Nature;

public abstract class Entity {
    // Корневой АБСТРАКТНЫЙ класс для всех существ
    // нельзя создавать объект на основе этого класса, только наследовать

    protected final int MAX_X = 150;
    protected final int MAX_Y = 150;

    protected int x;
    protected int y;
    protected boolean isQuantity;

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void toDelete(){
        this.isQuantity = false;
        Object obj = getClass().getSimpleName();

    }

    @Override
    public String toString() {
        return "Существует: " + isQuantity + "\n" + "Координаты: " + x + ", " + y;
    }
}

