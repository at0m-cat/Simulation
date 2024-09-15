classDiagram
direction BT
class Agronome {
  + execute(GameMap) void
  + cutTree(GameMap) void
  + cutRock(GameMap) void
}
class AnsiSprite
class Coordinates {
  + distanceTo(Entity) int
  + equals(Object) boolean
  + hashCode() int
  + toString() String
}
class CreationWorld {
  - getCoordinatesMap() Coordinates
  - getSquareMap() int
  + execute(GameMap) void
  - setupAllEntity() void
}
class Creature {
  + isValidTarget(TargetType) boolean
  + setHp(double) void
  + getHp() double
  # contactToTarget(Entity, GameMap) void
  # makeMove(GameMap) void
  - isTargetContact(GameMap, Coordinates) boolean
}
class DeadSouls
class Entity {
  + getCoordinates() Coordinates
  + getCoordintes() Coordinates
  + setCoordinates(Coordinates) void
  + toString() String
}
class EntityFactory {
  + setGrass(GameMap, int, int) void
  + setThree(GameMap, int, int) void
  + setHerbivore(GameMap, int, int, int) void
  + setPredator(GameMap, int, int, int) void
  + setRock(GameMap, int, int) void
}
class EntityQuantity {
  - getSquareMap() int
  + getConstValues() double[]
}
class FamilyType {
<<enumeration>>
  + valueOf(String) FamilyType
  + values() FamilyType[]
}
class Game {
  + main(String[]) void
  + gameLoop() void
}
class GameActions {
<<Interface>>
  + execute(GameMap) void
}
class GameMap {
  + getAllGrass() ArrayList~Grass~
  + getAllThree() ArrayList~Three~
  + getTargets(GameMap, Entity) ArrayList~T~
  + getAllPredators() ArrayList~Predator~
  + isSquareEmptyForMove(Coordinates, Entity) boolean
  + isNotEntity(Coordinates) boolean
  + removeEntity(Coordinates) void
  + getAllEntities() ArrayList~Entity~
  + moveCreature(Coordinates, Coordinates) void
  + isValidCoordinates(Coordinates) boolean
  + getEntity(Coordinates) Entity
  + getSizeMap() Coordinates
  + setEntities(Entity) void
  + getAllHerbivore() ArrayList~Herbivore~
  + setEntities(Coordinates, Entity) void
  + getAllDeadSouls() ArrayList~DeadSouls~
  + getAllRock() ArrayList~Rock~
  + isSquareEmptyForPrintMap(Coordinates) boolean
}
class Grass {
  + compareTo(Grass) int
}
class Herbivore {
  + isDead() boolean
  + becomeEnergetic() void
  + makeMove(GameMap) void
  + isFullHp() boolean
  + compareTo(Herbivore) int
  + isPepful(int) boolean
  # contactToTarget(Entity, GameMap) void
  + isValidTarget(TargetType) boolean
  + motionCounter() void
}
class MapConsoleRenderer {
  + renderer(GameMap) void
  - getSprite(Entity) String
  - colorizeSprite(String, Entity) String
}
class MotionController {
<<Interface>>
  + isDead() boolean
  + isFullHp() boolean
  + becomeEnergetic() void
  + isPepful(int) boolean
  + motionCounter() void
}
class Murder {
  + execute(GameMap) void
}
class Node {
  ~ getF() double
}
class PathToTarget {
  - execute(GameMap, Coordinates) void
  + getPath() ArrayList~Coordinates~
}
class Predator {
  + isDead() boolean
  # contactToTarget(Entity, GameMap) void
  + isFullHp() boolean
  + getAttackPower() double
  + isValidTarget(TargetType) boolean
  + setAttackPower(double) void
  + motionCounter() void
  + isPepful(int) boolean
  + makeMove(GameMap) void
  + becomeEnergetic() void
  + getSatiety() int
}
class Reborn {
  + rebornGrass() void
  + rebornPredatorsFromThree() void
  + execute(GameMap) void
}
class Rock
class ShiftsCreature {
  - setShifts() int[][]
  + getShifts() int[][]
}
class StaticType {
<<enumeration>>
  + values() StaticType[]
  + valueOf(String) StaticType
}
class TargetType {
<<enumeration>>
  + values() TargetType[]
  + valueOf(String) TargetType
}
class Three
class UpdateEveryTurn {
  + execute(GameMap) void
  - makeMoveAll() void
}
class aStar {
  + shortestPath(Coordinates, Coordinates, GameMap) ArrayList~Coordinates~
  - constructPath(Node) ArrayList~Coordinates~
  - getNeighbours(Coordinates, GameMap) List~Coordinates~
  - heuristic(Coordinates, Coordinates) int
}

Agronome  ..>  GameActions 
CreationWorld  ..>  GameActions 
Creature  -->  Entity 
Creature  ..>  MotionController 
DeadSouls  -->  Entity 
Grass  -->  Entity 
Herbivore  -->  Creature 
Murder  ..>  GameActions 
Predator  -->  Creature 
Reborn  ..>  GameActions 
Rock  -->  Entity 
Three  -->  Entity 
UpdateEveryTurn  ..>  GameActions 
