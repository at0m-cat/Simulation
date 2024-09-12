package GameMap.MapSetting;

import Entity.Entity;
import java.util.*;

public class Coordinates {

    public final Integer horizontal;
    public final Integer vertical;

    public Coordinates(Integer horizontal, Integer vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }


    public int distanceTo(Entity entity) {
        Coordinates target = entity.getCoordinates();
        return Math.abs(this.horizontal - target.horizontal) + Math.abs(this.vertical - target.vertical);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(horizontal, that.horizontal) && Objects.equals(vertical, that.vertical);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horizontal, vertical);
    }
    @Override
    public String toString() {
        return "vertical: " + vertical + ", horizontal: " + horizontal;
    }
}
