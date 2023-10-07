package agh.ics.oop;


public class World {
    public static void main(String[] args){
        System.out.println("System wystartował");
        run(args);
        System.out.println("System zakończył działanie");
    }
    static void run(String[] args){
        for (var i : args)
            System.out.println(i);
        System.out.println("Zwierzak idzie do przodu");
    }
}
