package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.presenter.SimulationPresenter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.List;

public class SimulationApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("simulation.fxml"));
        BorderPane viewRoot = loader.load();
        configureStage(primaryStage, viewRoot);
        SimulationPresenter presenter = loader.getController();
        WorldMap map = new GrassField(19);
        presenter.setWorldMap(map);
        map.addSubscriber(presenter);
//        List<MoveDirection> Orders = OptionsParser.parse(new String[]{"f", "r", "f", "l", "f", "f", "l", "b", "l", "b",
//                "b", "f", "l", "b", "r", "l", "f", "f", "f", "f", "b", "r", "b", "f", "f"});
//        List<Vector2d> startingPositions = List.of(new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(6, 10),
//                new Vector2d(1, 1));
//
//        Simulation simul = new Simulation(Orders, startingPositions, map);
        primaryStage.show();
//        simul.run();
    }

    private void configureStage(Stage primaryStage, BorderPane viewRoot) {
        var scene = new Scene(viewRoot);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simulation app");
        primaryStage.minWidthProperty().bind(viewRoot.minWidthProperty());
        primaryStage.minHeightProperty().bind(viewRoot.minHeightProperty());
    }
}
