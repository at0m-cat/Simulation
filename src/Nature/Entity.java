package Nature;

public abstract class Entity {
    // Корневой АБСТРАКТНЫЙ класс для всех существ
    // нельзя создавать объект на основе этого класса, только наследовать

    protected int x;
    protected int y;
    protected int quantity;

    protected Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void toDelete(){
        this.quantity = 0;
    }


}
