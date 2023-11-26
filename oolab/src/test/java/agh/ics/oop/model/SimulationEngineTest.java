package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;


class SimulationEngineTest {


    @Test
    void run() {
        List<MoveDirection> Orders1 = OptionsParser.parse(new String[]{"f", "r", "f", "l", "f", "f", "l", "b", "l", "b",
                "b", "f", "l", "b", "r", "l", "f", "f", "f", "f", "b", "r", "b", "f", "f"});
        List<Vector2d> startingPositions1 = List.of(new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(6, 10),
                new Vector2d(1, 1));
        List<MoveDirection> Orders2 = OptionsParser.parse(new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f",
                "f", "f", "f", "f", "f", "f", "f", "f", "b", "f", "f"});
        List<Vector2d> startingPositions2 = List.of(new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(6, 10),
                new Vector2d(1, 1), new Vector2d(16, 9), new Vector2d(14, 8), new Vector2d(7, 7),
                new Vector2d(11, 13));
//        WorldMap map1 = new RectangularMap(19, 19);
        ConsoleMapDisplay mapDisplay = new ConsoleMapDisplay();
//        WorldMap map2 = new GrassField(19);
//        map2.addSubscriber(mapDisplay);
        List<Simulation> simulations = new LinkedList<>();
        for (int i = 0; i < 6000000; i++) {
            WorldMap map2 = new GrassField(19);
//            WorldMap map1 = new RectangularMap(19, 19);
            map2.addSubscriber(mapDisplay);
            simulations.add(new Simulation(Orders1, startingPositions1, map2));
        }
//        List<Simulation> simulations = List.of(new Simulation(Orders1, startingPositions1, map1), new Simulation(Orders2, startingPositions2, map2));
        SimulationEngine engine = new SimulationEngine(simulations);
//        engine.runAsync();
//        engine.awaitSimulationEnd();
        engine.runAsyncInThreadPool();
//        engine.awaitSimulationEnd();
        System.out.println(mapDisplay.getEventsIListenedTo());
    }
}