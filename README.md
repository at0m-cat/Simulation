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

![SimulationOut](https://i124.fastpic.org/big/2024/0915/80/_fcdf2c21084ebee6ff6b5f9808337380.png?md5=9MmMf2OKYSRhRfC6ISYzMw&expires=1726369200)

## 📃 Сlass relationships

![My UML Diagram](graphviz.drawio.svg)
