package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {
    private int eventsIListenedTo = 0;

    public int getEventsIListenedTo() {
        return eventsIListenedTo;
    }

    @Override
    public synchronized void mapChanged(WorldMap worldMap, String message) {
        eventsIListenedTo += 1;
//        System.out.println(eventsIListenedTo);
//        System.out.println("Map id: " + worldMap.getId());
//        System.out.println(message);
//        System.out.println(worldMap);
//        System.out.println("Otrzymanych aktualizacji: " + eventsIListenedTo);
//        System.out.println();
    }
}
