package Entity;

import GameMap.MapSetting.GameMap;

public class EntityQuantity {

    GameMap gameMap;

    public EntityQuantity(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    private int getSquareMap() {
        return gameMap.getSizeMap().HORIZONTAL * gameMap.getSizeMap().VERTICAL;
    }

    public double[] getConstValues() {
        double PREDATORS = getSquareMap() * 0.15;
        double HERBIVORES = getSquareMap() * 0.25;
        double GRASS = getSquareMap() * 0.2;
        double THREES = getSquareMap() * 0.1;
        double ROCKS = getSquareMap() * 0.1;

        return new double[]{
                PREDATORS,
                HERBIVORES,
                GRASS,
                THREES,
                ROCKS
        };
    }



}
