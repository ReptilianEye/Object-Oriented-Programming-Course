package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class SimulationEngine {
    private final List<Simulation> simulations;
    private final List<Thread> threads = new LinkedList<>();

    public SimulationEngine(List<Simulation> simulations) {
        this.simulations = simulations;
    }

    public void runSync() {
        for (var sim : simulations) {
            sim.run();
        }
    }

    public void runAsync() {
        for (var sim : simulations) {
            Thread thread = new Thread(sim);
            threads.add(thread);
            thread.start();
        }
    }

    public void awaitSimulationEnd() {
//        for (var simThread : threads) {
//            try {
//                simThread.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException();
//            }
//        }
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (var sim : simulations) {
            executorService.submit(sim);
        }
        System.out.println("all submitted");
        executorService.shutdown();
        try {
            // Wait for all tasks to complete or until 10 seconds
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                // If not all tasks completed within 10 seconds, force shutdown
                System.out.println("Forcing shutdown after waiting for 10 seconds");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void runAsyncInThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(this::runAsync);
        executorService.shutdown();
    }
}
