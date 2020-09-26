package com.company.Picture;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Tree extends Group {
    private final double TreeHeight;

    public Tree(double height){
        TreeHeight = height;
        Trunk trunk = new Trunk(height / 10, height / 2);
        trunk.setLayoutY(+50);
        Crown crown = new Crown((int)height);
        getChildren().addAll(trunk, crown);
    }

    public void locateOn(double x, double y){
        setLayoutX(x);
        setLayoutY(y);
    }
    public void update(double ratio, double width, double height){
        //locateOn(Math.random() * width, Math.random() * height * ratio + height * (1 - ratio) - TreeHeight);
        locateOn(Math.random() * width, Math.random() * height);
    }

    private static class Trunk extends Rectangle {
        Trunk(double width, double height){
            super(width, height);
            setFill(Color.SANDYBROWN);
        }
    }

    private static class Crown extends Group{

        Crown(int count){
            for (int i = 1; i < count; i++) {
                Circle circle = new Circle(10,Math.random() > 0.3 ? Color.GREENYELLOW : Color.DARKGREEN);
                getChildren().add(circle);
                circle.setCenterY(Math.sin(100/i) * 40 + Math.random() * 30);
                circle.setCenterX(Math.cos(100/i) * 30 + Math.random() * 30);
            }
        }
    }
}
