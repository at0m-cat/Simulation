package Entity;
import MapSetting.*;

public class Grass extends Entity{

    public final boolean RESOURCES = true;

    // ресурс для травоядных

    public Grass(Coordinates coordinates) {
        super(coordinates, FamilyType.Grass, Target.YES, Static.YES);
    }
}
