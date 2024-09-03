package MapSetting;
import Entity.*;
import java.util.HashMap;

public class Map {
    // Карта - содержит в себе коллекцию для хранения существ и их расположение

    HashMap<Coordinates, Entity> entities = new HashMap<>();

    public void setEntities(Coordinates coordinates, Entity entity){
        entities.put(coordinates, entity);
        entity.coordinates = coordinates;
    }

    public void setupDefaultEntityPositions(){
        for (int i = 0; i < 9; i++) {
        setEntities(new Coordinates(1, i), new Grass(new Coordinates(8, i)));
        setEntities(new Coordinates(1, i), new Rock(new Coordinates(8, i)));
        }
    }
}
