package com.company;

import javafx.scene.Group;
import javafx.scene.shape.Circle;

class Head extends Group {
    private static class Eye extends Circle {
        static final double RADIUS_FACTOR = 0.1;

        Eye(double headRadius, boolean isLeft) {
            super(
                    headRadius / 2 * (isLeft ? -1 : 1), - headRadius / 2,
                    headRadius * RADIUS_FACTOR);
        }
    }

    private static class Skull extends Circle {
        Skull(double headRadius) {
            super(headRadius);
            setStyle("-fx-fill: white");
        }
    }

    Head(double headRadius) {
        super();

        getChildren().addAll(
                new Skull(headRadius),
                new Eye(headRadius, true),
                new Eye(headRadius, false)
        );
    }
}
