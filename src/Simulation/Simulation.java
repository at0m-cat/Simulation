package Simulation;

import java.util.List;

public class Simulation {

    private Map map;
    private int moveCounter;
    private Renderer renderer;
    private List<Actions> initActions;
    private List<Actions> turnActions;

    // главный класс приложения
    // включает в себя:
    //  - карту
    //  - счетчик ходов
    //  - рендерер поля
    //  - Actions - список действий, исполняемых перед стартом симуляции или на каждом ходу


    // Методы:
    //  - nextTurn() - просимултровать и отрендерить один ход
    //  - startSumulation() - запустить бесконечный цикл симуляции и рендеринга
    //  - pauseSimulation() - приостановить бесконечный цикл симуляции и рендеринга

    // Actions:
//    Action -действие, совершаемое над миром.
//    Например - сходить всеми существами.
//    Это действие итерировало бы существ и вызывало каждому makeMove().
//    Каждое действие описывается отдельным классом и совершает операции над картой.

//    Симуляция содержит 2 массива действий:
    //  - initActions - действия, совершаемые перед стартом симуляции.
    //  Пример - расставить объекты и существ на карте
    //  - turnActions - действия, совершаемые каждый ход.
    //  Пример - передвижение существ, добавить травы или травоядных,
    //  если их осталось слишком мало

    public void startSimulation(){
        for (Actions actions : initActions){
            actions.execute(map);
        }
        while (true){
            nextTurn();
        }
    }

    public void nextTurn(){
        for (Actions actions : turnActions){
            actions.execute(map);
        }

        renderer.render(map);
        moveCounter++;
    }

    public void pauseSimulation(){

    }
}
