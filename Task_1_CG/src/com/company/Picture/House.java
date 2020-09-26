package com.company.Picture;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;


public class House extends Group {
    private final double HouseWidth;
    private final double HouseHeight;
    public House(double width, double height){
        this.HouseWidth = width;
        this.HouseHeight = height;

        Building building = new Building(width, height);
        Roof roof = new Roof(0, 0, width / 2, - height/ 2, width, 0);

        Window window = new Window(width, height);
        window.setLayoutX(width / 10);
        window.setLayoutY(height / 10);

        Door door = new Door(width, height);
        door.setLayoutX(width * 0.4);
        door.setLayoutY(height * 0.3);

        getChildren().addAll(building, roof, window, door);
    }
    public void locateOn(double x, double y){
        setLayoutX(x);
        setLayoutY(y);
    }
    public void update(double ratio, double width, double height){
        locateOn(Math.random() * width / 2 - HouseWidth, Math.random() * height * ratio + height * (1 - ratio) - HouseHeight);
    }

    private static class Building extends javafx.scene.shape.Rectangle {
        Building(double width, double height){
            super(width, height);
            setFill(Color.BROWN);
        }
    }
    private static class Roof extends Polygon {
        Roof(double... points){
            super(points);
            setFill(Color.RED);
        }
    }
    private static class Window extends javafx.scene.shape.Rectangle {
        Window(double width, double height){
            super(width * 0.2, height * 0.3);
            setFill(Color.CORNFLOWERBLUE);
            setOpacity(0.7);
        }
    }
    private static class Door extends Rectangle {
        Door(double width, double height){
            super(width * 0.4, height * 0.6);
            setFill(Color.DARKGRAY);
        }
    }

}
