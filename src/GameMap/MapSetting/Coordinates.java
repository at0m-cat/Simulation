package GameMap.MapSetting;

import Entity.Entity;
import java.util.*;

public class Coordinates {

    public final Integer HORIZONTAL;
    public final Integer VERTICAL;

    public Coordinates(Integer horizontal, Integer vertical) {
        this.HORIZONTAL = horizontal;
        this.VERTICAL = vertical;
    }


    public int distanceTo(Entity entity) {
        Coordinates target = entity.getCoordinates();
        return Math.abs(this.HORIZONTAL - target.HORIZONTAL) + Math.abs(this.VERTICAL - target.VERTICAL);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(HORIZONTAL, that.HORIZONTAL) && Objects.equals(VERTICAL, that.VERTICAL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(HORIZONTAL, VERTICAL);
    }
    @Override
    public String toString() {
        return "vertical: " + VERTICAL + ", horizontal: " + HORIZONTAL;
    }
}
