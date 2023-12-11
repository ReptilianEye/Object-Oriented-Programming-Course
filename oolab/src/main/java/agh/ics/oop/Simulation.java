package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;

public class Simulation implements Runnable{
    private final List<Animal> Animals;
    private final List<MoveDirection> Orders;
    private final WorldMap<Vector2d, Animal> Map;

    public Simulation(List<MoveDirection> Orders, List<Vector2d> startingPositions, WorldMap Map) {
        this.Orders = Orders;
        this.Animals = startingPositions.stream().map(Animal::new).toList();
        this.Map = Map;
        placeAnimals();
    }

    /*
     ** Place animals on the map
     ** @return number of placed animals
     */
    public int placeAnimals() {
        int placed = 0;
        List<Animal> startingPosition = getAnimals();
        for (var st : startingPosition) {
            try {
                placed++;
                Map.place(st);
            } catch (
                    PositionAlreadyOccupiedException ignored) {
                placed--;
            }
        }
        return placed;
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
            Map.move(current, ord);
//            printIthAnimal(animal_idx);
            animal_idx = (animal_idx + 1) % Animals.size();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
