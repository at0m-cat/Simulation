package Entity;
import Actions.Murder;
import Entity.EnumType.FamilyType;
import Entity.EnumType.StaticType;
import Entity.EnumType.TargetType;
import GameMap.PathToTarget.PathToTarget;
import Entity.EntityMotion.MotionController;
import GameMap.MapSetting.Coordinates;
import GameMap.MapSetting.GameMap;

import java.util.*;

abstract public class Creature extends Entity implements MotionController {

    protected int speed;
    protected double hp;
    protected int satiety;

    public Creature(Coordinates coordinates, FamilyType type, TargetType target) {
        super(coordinates, type, target, StaticType.NO);

    }

    protected void contactToTarget(Entity entityTarget, GameMap gameMap) {
    }


    protected void makeMove(GameMap gameMap) {

        if (isDead()){
            Murder murder = new Murder(gameMap, coordinates);
            murder.execute(gameMap);
            return;
        }

        if (isFullHp()){
            setHp(95);
            return;
        }

        PathToTarget pathToTarget = new PathToTarget(gameMap, coordinates);
        ArrayList<Coordinates> path = pathToTarget.getPath();

        if (path.isEmpty()) {
            return;
        }

        if (path.size() > speed + 1) {
            gameMap.moveCreature(coordinates, path.get(speed));
        } else {

            if (isTargetContact(gameMap, path.getLast())) {
                Entity target = gameMap.getEntity(path.getLast());
                contactToTarget(target, gameMap);
            }

        }

    }

    private boolean isTargetContact(GameMap map, Coordinates tagetCoordinations) {
        return map.getEntity(tagetCoordinations) != null;
    }


    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public abstract boolean isValidTarget(TargetType target);

}

