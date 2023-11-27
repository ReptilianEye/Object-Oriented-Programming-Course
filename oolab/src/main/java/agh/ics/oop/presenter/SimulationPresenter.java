package agh.ics.oop.presenter;

import agh.ics.oop.model.MapChangeListener;
import agh.ics.oop.model.WorldMap;
import javafx.fxml.FXML;

import java.awt.*;


public class SimulationPresenter implements MapChangeListener {
    private WorldMap map;

    //    SimulationPresenter(WorldMap map) {
//        this.map = map;
//    }
    @FXML
    private Label infoLabel;

    public void setWorldMap(WorldMap map) {
        this.map = map;

    }

    public void drawMap() {
        infoLabel.setText(map.toString());
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        drawMap();
    }
}
