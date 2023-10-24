package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    @Test
    void run() {
        //given
        List<MoveDirection> Orders = OptionsParser.parse(new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"});
        List<Vector2d> startingPositions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
        Simulation simulation = new Simulation(Orders, startingPositions);

        Vector2d expectedAnimal1P = new Vector2d(0, 1);
        MapDirection expectedAnimal1O = MapDirection.NORTH;

        Vector2d expectedAnimal2P = new Vector2d(4, 4);
        MapDirection expectedAnimal2O = MapDirection.SOUTH;

        //when
        simulation.run();
        List<Animal> animalsAfter = simulation.getAnimals();

        Vector2d actualAnimal1P = animalsAfter.get(0).getPosition();
        MapDirection actualAnimal1O = animalsAfter.get(0).getOrientation();

        Vector2d actualAnimal2P = animalsAfter.get(1).getPosition();
        MapDirection actualAnimal2O = animalsAfter.get(1).getOrientation();

        //then
        Assertions.assertEquals(expectedAnimal1P,actualAnimal1P);
        Assertions.assertEquals(expectedAnimal1O,actualAnimal1O);
        Assertions.assertEquals(expectedAnimal2P,actualAnimal2P);
        Assertions.assertEquals(expectedAnimal2O,actualAnimal2O);

    }
}