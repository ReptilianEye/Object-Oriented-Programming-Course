package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.List;


public class SimulationPresenter implements MapChangeListener {
    private WorldMap map;

    @FXML
    private Label description;

    @FXML
    private TextField movesInput;

    @FXML
    private GridPane mapGrid;
    private static int CELL_WIDTH = 30;
    private static int CELL_HEIGHT = 30;

    public void setWorldMap(WorldMap map) {
        this.map = map;
    }

    @FXML
    void onSimulationStartClicked() {
        List<MoveDirection> Orders = OptionsParser.parse(collectInput());
        List<Vector2d> startingPositions = List.of(new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(6, 10),
                new Vector2d(1, 1));
        Simulation simulation = new Simulation(Orders, startingPositions, map);
        SimulationEngine engine = new SimulationEngine(simulation);
        engine.runAsync();
    }

    public String[] collectInput() {
        return movesInput.getText().split(" ");
    }

    private void clearGrid() {
        mapGrid.getChildren().retainAll(mapGrid.getChildren().get(0)); // hack to retain visible grid lines
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }

    private void configureGrid() {
        mapGrid.getRowConstraints().add(new RowConstraints(CELL_HEIGHT));
        mapGrid.getColumnConstraints().add(new ColumnConstraints(CELL_WIDTH));
        Label label = new Label();
        label.setText("x/y");
        mapGrid.add(label, 0, 0);
        GridPane.setHalignment(label, HPos.CENTER);
        Boundary bounds = map.getCurrentBounds();
        for (int i = 1; i <= bounds.rightCorner().getX() - bounds.leftCorner().getX() + 1; i++) {
            mapGrid.getRowConstraints().add(new RowConstraints(CELL_HEIGHT));
            label = new Label();
            Integer labelText = bounds.leftCorner().getX() + i - 1;
            label.setText(labelText.toString());
            mapGrid.add(label, 0, i);
            GridPane.setHalignment(label, HPos.CENTER);
        }
        for (int j = 1; j <= bounds.rightCorner().getY() - bounds.leftCorner().getY() + 1; j++) {
            mapGrid.getColumnConstraints().add(new ColumnConstraints(CELL_WIDTH));
            label = new Label();
            Integer labelText = bounds.leftCorner().getY() + j - 1;
            label.setText(labelText.toString());
            mapGrid.add(label, j, 0);
            GridPane.setHalignment(label, HPos.CENTER);
        }
    }

    public void drawMap() {
        clearGrid();
        configureGrid();
        Boundary bounds = map.getCurrentBounds();
        for (int i = 0; i <= bounds.rightCorner().getX() - bounds.leftCorner().getX(); i++) {
            for (int j = 0; j <= bounds.rightCorner().getY() - bounds.leftCorner().getY(); j++) {
                Label label = new Label();
                WorldElement el = (WorldElement) map.objectAt(new Vector2d(bounds.leftCorner().getX() + i, bounds.leftCorner().getY() + j));
                label.setText(el != null ? el.toString() : "");
                mapGrid.add(label, j + 1, i + 1);
                GridPane.setHalignment(label, HPos.CENTER);
            }

        }

    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        Platform.runLater(() -> {
            description.setText(message);
            drawMap();
        });
    }

}
