package com.company;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

public class Body extends Group {
    private static class Torso extends Circle{
        static final double RADIUS_FACTOR = 1.5;
        Torso(double headRadius){
            super(headRadius * RADIUS_FACTOR);
            setStyle("-fx-fill: white");
        }
    }
    private static class Legs extends Circle{
        static final double RADIUS_FACTOR = 2;
        Legs(double headRadius){
            super(headRadius * RADIUS_FACTOR);
            setStyle("-fx-fill: white");
            setLayoutY(+(headRadius * 2));
        }
    }

    Body(double headRadius){
        super();
        getChildren().addAll(new Torso(headRadius), new Legs(headRadius));

    }
}
