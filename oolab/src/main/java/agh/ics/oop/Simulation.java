package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.List;

public class Simulation {
    private final List<Animal> Animals;
    private final List<MoveDirection> Orders;

    public Simulation(List<MoveDirection> Orders, List<Vector2d> startingPositions) {
        this.Orders = Orders;
        this.Animals = startingPositions.stream().map(Animal::new).toList();
    }

    public List<Animal> getAnimals() {
        return Animals;
    }

    private void printIthAnimal(int i) {
        System.out.println("Zwierze " + i + ": " + Animals.get(i).toString());
    }

    public void run() {
        int animal_idx = 0;
        for (var ord : Orders) {
            Animal current = Animals.get(animal_idx);
            current.move(ord);
//            Animals.set(animal_idx, current);
            printIthAnimal(animal_idx);
            animal_idx = (animal_idx + 1) % Animals.size();
        }
    }
}
