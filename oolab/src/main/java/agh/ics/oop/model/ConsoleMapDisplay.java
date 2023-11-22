package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {
    int eventsIListenedTo = 0;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        eventsIListenedTo++;
        System.out.println(message);
        System.out.println(worldMap);
        System.out.println("Otrzymanych aktualizacji: " + eventsIListenedTo);
        System.out.println();
    }
}
