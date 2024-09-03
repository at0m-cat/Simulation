package Entity;
import MapSetting.*;

abstract public class Entity {
    // Корневой АБСТРАКТНЫЙ класс для всех существ
    // нельзя создавать объект на основе этого класса, только наследовать

    public Coordinates coordinates;
    protected boolean isQuantity;


    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.isQuantity = true;
    }

}

