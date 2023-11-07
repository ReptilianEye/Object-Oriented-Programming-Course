package agh.ics.oop;

import agh.ics.oop.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

class SimulationTest {

    @Test
    void basicCase() {
        // given
        List<MoveDirection> Orders = OptionsParser
                .parse(new String[] { "f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f" });
        List<Vector2d> startingPositions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
        int animalsCount = startingPositions.size();
        WorldMap map = new RectangularMap(4, 4);
        Simulation simulation = new Simulation(Orders, startingPositions, map);

        Vector2d expectedAnimal1P = new Vector2d(3, 0);
        MapDirection expectedAnimal1O = MapDirection.SOUTH;

        Vector2d expectedAnimal2P = new Vector2d(2, 4);
        MapDirection expectedAnimal2O = MapDirection.NORTH;

        // when
        // int actualAnimalsPlaced = simulation.placeAnimals();
        simulation.run();
        List<Animal> animalsAfter = simulation.getAnimals();

        Vector2d actualAnimal1P = animalsAfter.get(0).getPosition();
        MapDirection actualAnimal1O = animalsAfter.get(0).getOrientation();

        Vector2d actualAnimal2P = animalsAfter.get(1).getPosition();
        MapDirection actualAnimal2O = animalsAfter.get(1).getOrientation();

        // then
        // Assertions.assertEquals(animalsCount, actualAnimalsPlaced, "All animals
        // should be placed if had different starting positions");

        Assertions.assertEquals(expectedAnimal1P, actualAnimal1P);
        Assertions.assertEquals(expectedAnimal1O, actualAnimal1O);
        Assertions.assertEquals(expectedAnimal2P, actualAnimal2P);
        Assertions.assertEquals(expectedAnimal2O, actualAnimal2O);
        System.out.println(map);

    }

    @Test
    void manyAnimalsLittleOrdersCase() {
        // given
        List<MoveDirection> Orders = OptionsParser.parse(new String[] { "f", "b", "r", "l", "f" });
        List<Vector2d> startingPositions = List.of(new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(6, 10),
                new Vector2d(1, 1), new Vector2d(1, 0), new Vector2d(15, 4), new Vector2d(3, 14), new Vector2d(6, 17),
                new Vector2d(2, 11), new Vector2d(16, 9), new Vector2d(14, 8), new Vector2d(7, 7),
                new Vector2d(11, 13));
        int animalsCount = startingPositions.size();
        WorldMap map = new RectangularMap(19, 19);
        Simulation simulation = new Simulation(Orders, startingPositions, map);

        Vector2d expectedAnimal1P = new Vector2d(2, 3);
        MapDirection expectedAnimal1O = MapDirection.NORTH;

        Vector2d expectedAnimal2P = new Vector2d(3, 3);
        MapDirection expectedAnimal2O = MapDirection.NORTH;

        Vector2d expectedAnimal3P = new Vector2d(6, 10);
        MapDirection expectedAnimal3O = MapDirection.EAST;

        Vector2d expectedAnimal4P = new Vector2d(1, 1);
        MapDirection expectedAnimal4O = MapDirection.WEST;

        Vector2d expectedAnimal5P = new Vector2d(1, 0);
        MapDirection expectedAnimal5O = MapDirection.NORTH;

        // when
        // int actualAnimalsPlaced = simulation.placeAnimals();
        simulation.run();
        List<Animal> animalsAfter = simulation.getAnimals();

        Vector2d actualAnimal1P = animalsAfter.get(0).getPosition();
        MapDirection actualAnimal1O = animalsAfter.get(0).getOrientation();

        Vector2d actualAnimal2P = animalsAfter.get(1).getPosition();
        MapDirection actualAnimal2O = animalsAfter.get(1).getOrientation();

        Vector2d actualAnimal3P = animalsAfter.get(2).getPosition();
        MapDirection actualAnimal3O = animalsAfter.get(2).getOrientation();

        Vector2d actualAnimal4P = animalsAfter.get(3).getPosition();
        MapDirection actualAnimal4O = animalsAfter.get(3).getOrientation();

        Vector2d actualAnimal5P = animalsAfter.get(4).getPosition();
        MapDirection actualAnimal5O = animalsAfter.get(5).getOrientation();

        // then
        // Assertions.assertEquals(animalsCount, actualAnimalsPlaced, "All animals
        // should be placed if had different starting positions");

        Assertions.assertEquals(expectedAnimal1P, actualAnimal1P);
        Assertions.assertEquals(expectedAnimal1O, actualAnimal1O);

        Assertions.assertEquals(expectedAnimal2P, actualAnimal2P);
        Assertions.assertEquals(expectedAnimal2O, actualAnimal2O);

        Assertions.assertEquals(expectedAnimal3P, actualAnimal3P);
        Assertions.assertEquals(expectedAnimal3O, actualAnimal3O);

        Assertions.assertEquals(expectedAnimal4P, actualAnimal4P);
        Assertions.assertEquals(expectedAnimal4O, actualAnimal4O);

        Assertions.assertEquals(expectedAnimal5P, actualAnimal5P,
                "Animal should not move if after move it would enter on others animals field");
        Assertions.assertEquals(expectedAnimal5O, actualAnimal5O);

        for (int i = Orders.size(); i < animalsAfter.size(); i++) {
            Assertions.assertEquals(startingPositions.get(i), animalsAfter.get(i).getPosition(),
                    "Position of unmoved animal " + i + " should remain the same");
            Assertions.assertEquals(MapDirection.NORTH, animalsAfter.get(i).getOrientation(),
                    "Orientation of unmoved animal " + i + " should remain the same");
        }
        System.out.println(map);

    }

    @Test
    void manyAnimalsManyOrdersCase() {
        // given
        List<MoveDirection> Orders = OptionsParser.parse(new String[] { "f", "b", "r", "l", "f", "f", "r", "r", "f",
                "f", "f", "f", "f", "f", "f", "f", "f", "b", "f", "f", "l", "l", "r", "b", "b", "l", "b", "r", "r", "b",
                "f", "r", "b", "l", "b", "b", "b", "r", "b", "l", "b", "r", "r", "f", "l", "f", "f", "l", "b", "l", "b",
                "b", "f", "l", "b", "r", "l", "f", "f", "f", "f", "b", "r", "b", "f", "f" });
        List<Vector2d> startingPositions = List.of(new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(6, 10),
                new Vector2d(1, 1), new Vector2d(1, 0), new Vector2d(15, 4), new Vector2d(3, 14), new Vector2d(6, 17),
                new Vector2d(2, 11), new Vector2d(16, 9), new Vector2d(14, 8), new Vector2d(7, 7),
                new Vector2d(11, 13));
        int animalsCount = startingPositions.size();
        WorldMap map = new RectangularMap(19, 19);
        Simulation simulation = new Simulation(Orders, startingPositions, map);

        List<Vector2d> expectedPositions = List.of(new Vector2d(0, 3), new Vector2d(2, 3), new Vector2d(8, 10),
                new Vector2d(0, 1), new Vector2d(1, 0), new Vector2d(15, 7), new Vector2d(6, 14), new Vector2d(4, 17),
                new Vector2d(3, 11), new Vector2d(13, 10), new Vector2d(14, 9), new Vector2d(5, 8),
                new Vector2d(12, 14));
        List<MapDirection> expectedDirections = List.of(MapDirection.WEST, MapDirection.NORTH, MapDirection.WEST,
                MapDirection.EAST, MapDirection.WEST, MapDirection.NORTH, MapDirection.EAST, MapDirection.WEST,
                MapDirection.SOUTH, MapDirection.EAST, MapDirection.NORTH, MapDirection.EAST, MapDirection.WEST);

        // when
        int actualAnimalsPlaced = simulation.placeAnimals();
        simulation.run();
        List<Animal> animalsAfter = simulation.getAnimals();

        // then
        Assertions.assertEquals(animalsCount, actualAnimalsPlaced,
                "All animals should be placed if had different starting positions");

        for (int i = 0; i < expectedPositions.size(); i++) {
            Animal current = animalsAfter.get(i);
            Assertions.assertEquals(expectedPositions.get(i), current.getPosition(),
                    "Animal " + i + " position is wrong");
            Assertions.assertEquals(expectedDirections.get(i), current.getOrientation(),
                    "Animal " + i + " orientation is wrong");
        }
        System.out.println(map);
    }

    @Test
    void basicCaseFieldMap() {
        // given
        List<MoveDirection> Orders = OptionsParser
                .parse(new String[] { "f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f" });
        List<Vector2d> startingPositions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
        int animalsCount = startingPositions.size();
        WorldMap map = new FieldMap(4);
        Simulation simulation = new Simulation(Orders, startingPositions, map);

        Vector2d expectedAnimal1P = new Vector2d(3, 0);
        MapDirection expectedAnimal1O = MapDirection.SOUTH;

        Vector2d expectedAnimal2P = new Vector2d(2, 4);
        MapDirection expectedAnimal2O = MapDirection.NORTH;

        // when
        simulation.run();
        List<Animal> animalsAfter = simulation.getAnimals();

        Vector2d actualAnimal1P = animalsAfter.get(0).getPosition();
        MapDirection actualAnimal1O = animalsAfter.get(0).getOrientation();

        Vector2d actualAnimal2P = animalsAfter.get(1).getPosition();
        MapDirection actualAnimal2O = animalsAfter.get(1).getOrientation();

        // then
        Assertions.assertEquals(expectedAnimal1P, actualAnimal1P);
        Assertions.assertEquals(expectedAnimal1O, actualAnimal1O);
        Assertions.assertEquals(expectedAnimal2P, actualAnimal2P);
        Assertions.assertEquals(expectedAnimal2O, actualAnimal2O);
        System.out.println(map);

    }

    @Test
    void manyAnimalsLittleOrdersCaseFieldMap() {
        // given
        List<MoveDirection> Orders = OptionsParser.parse(new String[] { "f", "b", "r", "l", "f" });
        List<Vector2d> startingPositions = List.of(new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(6, 10),
                new Vector2d(1, 1), new Vector2d(1, 0), new Vector2d(15, 4), new Vector2d(3, 14), new Vector2d(6, 17),
                new Vector2d(2, 11), new Vector2d(16, 9), new Vector2d(14, 8), new Vector2d(7, 7),
                new Vector2d(11, 13));
        int animalsCount = startingPositions.size();
        WorldMap map = new FieldMap(19);
        Simulation simulation = new Simulation(Orders, startingPositions, map);

        Vector2d expectedAnimal1P = new Vector2d(2, 3);
        MapDirection expectedAnimal1O = MapDirection.NORTH;

        Vector2d expectedAnimal2P = new Vector2d(3, 3);
        MapDirection expectedAnimal2O = MapDirection.NORTH;

        Vector2d expectedAnimal3P = new Vector2d(6, 10);
        MapDirection expectedAnimal3O = MapDirection.EAST;

        Vector2d expectedAnimal4P = new Vector2d(1, 1);
        MapDirection expectedAnimal4O = MapDirection.WEST;

        Vector2d expectedAnimal5P = new Vector2d(1, 0);
        MapDirection expectedAnimal5O = MapDirection.NORTH;

        // when
        simulation.run();
        List<Animal> animalsAfter = simulation.getAnimals();

        Vector2d actualAnimal1P = animalsAfter.get(0).getPosition();
        MapDirection actualAnimal1O = animalsAfter.get(0).getOrientation();

        Vector2d actualAnimal2P = animalsAfter.get(1).getPosition();
        MapDirection actualAnimal2O = animalsAfter.get(1).getOrientation();

        Vector2d actualAnimal3P = animalsAfter.get(2).getPosition();
        MapDirection actualAnimal3O = animalsAfter.get(2).getOrientation();

        Vector2d actualAnimal4P = animalsAfter.get(3).getPosition();
        MapDirection actualAnimal4O = animalsAfter.get(3).getOrientation();

        Vector2d actualAnimal5P = animalsAfter.get(4).getPosition();
        MapDirection actualAnimal5O = animalsAfter.get(5).getOrientation();

        // then
        Assertions.assertEquals(expectedAnimal1P, actualAnimal1P);
        Assertions.assertEquals(expectedAnimal1O, actualAnimal1O);

        Assertions.assertEquals(expectedAnimal2P, actualAnimal2P);
        Assertions.assertEquals(expectedAnimal2O, actualAnimal2O);

        Assertions.assertEquals(expectedAnimal3P, actualAnimal3P);
        Assertions.assertEquals(expectedAnimal3O, actualAnimal3O);

        Assertions.assertEquals(expectedAnimal4P, actualAnimal4P);
        Assertions.assertEquals(expectedAnimal4O, actualAnimal4O);

        Assertions.assertEquals(expectedAnimal5P, actualAnimal5P,
                "Animal should not move if after move it would enter on others animals field");
        Assertions.assertEquals(expectedAnimal5O, actualAnimal5O);

        for (int i = Orders.size(); i < animalsAfter.size(); i++) {
            Assertions.assertEquals(startingPositions.get(i), animalsAfter.get(i).getPosition(),
                    "Position of unmoved animal " + i + " should remain the same");
            Assertions.assertEquals(MapDirection.NORTH, animalsAfter.get(i).getOrientation(),
                    "Orientation of unmoved animal " + i + " should remain the same");
        }
        System.out.println(map);

    }

    @Test
    void manyAnimalsManyOrdersCaseFieldMap() {
        // given
        List<MoveDirection> Orders = OptionsParser.parse(new String[] { "f", "b", "r", "l", "f", "f", "r", "r", "f",
                "f", "f", "f", "f", "f", "f", "f", "f", "b", "f", "f", "l", "l", "r", "b", "b", "l", "b", "r", "r", "b",
                "f", "r", "b", "l", "b", "b", "b", "r", "b", "l", "b", "r", "r", "f", "l", "f", "f", "l", "b", "l", "b",
                "b", "f", "l", "b", "r", "l", "f", "f", "f", "f", "b", "r", "b", "f", "f" });
        List<Vector2d> startingPositions = List.of(new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(6, 10),
                new Vector2d(1, 1), new Vector2d(1, 0), new Vector2d(15, 4), new Vector2d(3, 14), new Vector2d(6, 17),
                new Vector2d(2, 11), new Vector2d(16, 9), new Vector2d(14, 8), new Vector2d(7, 7),
                new Vector2d(11, 13));
        int animalsCount = startingPositions.size();
        WorldMap map = new FieldMap(19);
        Simulation simulation = new Simulation(Orders, startingPositions, map);

        List<Vector2d> expectedPositions = List.of(new Vector2d(0, 3), new Vector2d(2, 3), new Vector2d(8, 10),
                new Vector2d(0, 1), new Vector2d(1, 0), new Vector2d(15, 7), new Vector2d(6, 14), new Vector2d(4, 17),
                new Vector2d(3, 11), new Vector2d(13, 10), new Vector2d(14, 9), new Vector2d(5, 8),
                new Vector2d(12, 14));
        List<MapDirection> expectedDirections = List.of(MapDirection.WEST, MapDirection.NORTH, MapDirection.WEST,
                MapDirection.EAST, MapDirection.WEST, MapDirection.NORTH, MapDirection.EAST, MapDirection.WEST,
                MapDirection.SOUTH, MapDirection.EAST, MapDirection.NORTH, MapDirection.EAST, MapDirection.WEST);

        // when
        int actualAnimalsPlaced = simulation.placeAnimals();
        simulation.run();
        List<Animal> animalsAfter = simulation.getAnimals();

        // then
        Assertions.assertEquals(animalsCount, actualAnimalsPlaced,
                "All animals should be placed if had different starting positions");

        for (int i = 0; i < expectedPositions.size(); i++) {
            Animal current = animalsAfter.get(i);
            Assertions.assertEquals(expectedPositions.get(i), current.getPosition(),
                    "Animal " + i + " position is wrong");
            Assertions.assertEquals(expectedDirections.get(i), current.getOrientation(),
                    "Animal " + i + " orientation is wrong");
        }
        System.out.println(map);
    }
}