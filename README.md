# 🌿 Simulation

This project is an ecosystem simulation consisting of predators, herbivores, and static objects such as rocks, trees, and grass. The creatures (predators and herbivores) move across the map and interact with each other according to simple rules. Predators hunt herbivores, and herbivores search for grass to feed. The simulation includes a full life cycle, where creatures can die, disappear, or be reborn.

- [Java Roadmap by Sergey Zhukov.](https://zhukovsd.github.io/java-backend-learning-course/)
- [Project "Simulation".](https://zhukovsd.github.io/java-backend-learning-course/projects/simulation/)

## 🔍 Key Features

### 🐾 Predator and Herbivore Behavior
- **Predators**:
  - Hunt herbivores using the A* pathfinding algorithm to move towards their target.
  - Attack herbivores when they reach their coordinates.
- **Herbivores**:
  - Search for grass and eat it to restore health and maintain satiety.

### 🌱 Static Objects
- **Grass**: Consumed by herbivores to sustain life.
- **Rocks and Trees**: Act as obstacles that creatures cannot pass through.

### 🔄 Life Cycle
- **Health and Satiety**: Each creature has a health (HP) and satiety level.
- **Death and Rebirth**:
  - If a predator’s or herbivore’s health (HP) drops to zero, they die and turn into "dead entities".
  - Grass and new creatures can regenerate when certain conditions are met.

## ⚙️ How It Works

The simulation takes place on a grid-based map where each creature or object occupies specific coordinates. Predators search for herbivores as targets, and herbivores search for grass. The A* algorithm is used to find the shortest path while avoiding obstacles.

### 📍 A* Pathfinding Algorithm
The [A* Algorithm](https://youtu.be/gCclsviUeUk?si=0l3xv-GcTtPRs4JH) finds the shortest path between points while accounting for obstacles:
- **Heuristic**: Each potential move is evaluated based on the heuristic (distance to the target).
- **Movement**: Predators and herbivores follow this path to reach their target.

## 🗂️ Class Overview

### 🔧 Entity
The base class for all simulation objects (both creatures and static objects). It contains properties such as coordinates, the type of entity (e.g., herbivore or predator), and its target (e.g., grass or herbivore).

### 🐾 Creature
An abstract class for all moving creatures (predators and herbivores). It includes logic for movement, interaction with targets, and managing health and satiety.

### 🦁 Predator and 🐹 Herbivore
These classes inherit from `Creature` and define specific behaviors:
- **Predator** — hunts herbivores.
- **Herbivore** — searches for and consumes grass.

### 🗺️ GameMap
This class manages the map, which is a grid where all entities are placed. It also provides helper functions for checking the status of cells on the map (e.g., if a cell is free).

### 🔀 PathToTarget
A class that implements the A* algorithm to find the shortest path from a creature to its target.

### 🎮 Game
The main class that runs the simulation. It initializes the map, creates entities, and updates the actions of each creature on every turn.

## 🖥 Example Output

![SimulationOut](SimulationOut.png)

## 📃 Сlass relationships

![My UML Diagram](graphviz.drawio.svg)

## A* Pathfinding Algorithm

The `aStar` class is designed to compute the shortest path for a creature on a game map from one coordinate to another using the A* (A-star) algorithm. It uses a heuristic function to evaluate the most promising path to the target while avoiding obstacles.

- Uses a heuristic based on Manhattan distance.
- Supports dynamic maps with moving entities.
- Flexible pathfinding based on the current state of the game map.
- Efficient priority queue to manage open nodes.

## How It Works

The A* algorithm works as follows:
1. Uses a **heuristic function** to estimate the distance from the current position to the target.
2. Explores neighboring cells and tracks the cost to reach each one.
3. Prioritizes nodes that are closer to the target (based on the sum of cost and heuristic).
4. Returns the optimal path once the target is reached.

### Example

```java
import Entity.Objects.Herbivore;
import Entity.Objects.Predator;
import GameMap.MapSetting.Coordinates;
import GameMap.MapSetting.GameMap;
import GameMap.PathToTarget.aStar;
import Entity.Entity;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GameMap map = new GameMap();

        Coordinates start = new Coordinates(13, 17);
        Coordinates target = new Coordinates(5, 5);

        Entity predator = new Predator(start);
        Entity herbivore = new Herbivore(target);
        map.setEntities(predator);
        map.setEntities(herbivore);

        aStar pathfinder = new aStar(predator);
        ArrayList<Coordinates> path = pathfinder.shortestPath(start, target, map);

        System.out.println("Shortest path: " + path.toString());
    }
}
```

In this example:
- A new game map (`GameMap`) is created along with two entity objects (`Entity`).
- Start and target coordinates are defined.
- The `aStar` class is used to compute the shortest path between two points on the map.

### Output
The program will output a list of coordinates (`Coordinates`) representing the shortest path found by the A* algorithm.

```java
Shortest path: [vertical: 17, horizontal: 13, vertical: 16, horizontal: 13, vertical: 15, horizontal: 13, vertical: 14, horizontal: 13, vertical: 14, horizontal: 12, vertical: 14, horizontal: 11, vertical: 14, horizontal: 10, vertical: 13, horizontal: 10, vertical: 13, horizontal: 9, vertical: 12, horizontal: 9, vertical: 11, horizontal: 9, vertical: 10, horizontal: 9, vertical: 10, horizontal: 8, vertical: 9, horizontal: 8, vertical: 8, horizontal: 8, vertical: 7, horizontal: 8, vertical: 6, horizontal: 8, vertical: 5, horizontal: 8, vertical: 5, horizontal: 7, vertical: 5, horizontal: 6, vertical: 5, horizontal: 5]

Process finished with exit code 0
```

### Key Components:
- **`heuristic(Coordinates from, Coordinates to)`**: Calculates the Manhattan distance between two points.
- **`getNeighbours(Coordinates coordinates, GameMap map)`**: Finds all valid neighboring positions for the entity.
- **`shortestPath(Coordinates from, Coordinates to, GameMap map)`**: The main method that calculates and returns the shortest path using the A* algorithm.
