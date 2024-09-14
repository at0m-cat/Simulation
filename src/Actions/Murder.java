package Actions;


import Entity.Entity;
import Entity.Objects.DeadSouls;
import GameMap.MapSetting.Coordinates;
import GameMap.MapSetting.GameMap;

public class Murder implements GameActions {

    GameMap gameMap;
    Coordinates to;

    public Murder(GameMap gameMap, Coordinates to) {
        this.gameMap = gameMap;
        this.to = to;
    }

    @Override
    public void execute(GameMap gameMap) {
//        gameMap.setEntities(to, new DeadSouls(to) {
//        });

        gameMap.setEntities(new DeadSouls(to));
    }

    private void addEntity(Entity newEntity, Coordinates to){
        gameMap.setEntities(to, newEntity);
    }
}
