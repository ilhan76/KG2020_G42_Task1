package com.company;

import javafx.scene.Group;

public class Snowman extends Group {
    Snowman(double headRadius){
        super();
        Body body = new Body(headRadius);
        body.setLayoutY(+(headRadius * 2));
        getChildren().addAll(
                new Head(headRadius), body
        );
    }
}
