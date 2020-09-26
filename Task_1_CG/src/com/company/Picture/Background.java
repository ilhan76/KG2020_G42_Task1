package com.company.Picture;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Background extends Group {
    private final Sky sky;
    private final Field field;
    private final double ratio;

    public Background(double ratio, double width, double height) {
        super();
        this.ratio = ratio;
        sky = new Sky(ratio, width , height);
        field = new Field(ratio, width, height);
        getChildren().addAll(sky, field);
    }

    public void update(double width, double height){
        sky.update(width, height);
        field.update(width, height);
    }

    private static class Sky extends Group{
        private final Body body;
        private final ArrayList<Cloud> clouds;
        private final Sun sun;
        private final double ratio;

        Sky(double ratio, double width, double height){
            this.ratio = ratio;
            body = new Body(ratio, width, height);
            sun = new Sun();
            getChildren().addAll(body, sun);
            clouds = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                Cloud cloud = new Cloud();
                clouds.add(cloud);
                getChildren().add(cloud);
            }
            update(width, height);
        }

        public void update(double width, double height){
            body.setWidth(width);
            body.setHeight(height * ratio);
            sun.setLayoutX(Math.random() * width);
            sun.setLayoutY(Math.random() * height);
            for (Cloud c :
                    clouds) {
                c.locateOn(Math.random() * width, Math.random() * height);
            }
        }

        private static class Body extends Rectangle{
            Body(double ratio, double width, double height){
                super(width, height * (1 - ratio));
                setFill(Color.CORNFLOWERBLUE);
            }
        }
        private static class Cloud extends Group {
            Cloud(){
                for (int i = 1; i < 100; i++) {

                    Circle circle = new Circle(10,Math.random() > 0.3 ? Color.WHITE : Color.LIGHTGRAY);
                    getChildren().add(circle);
                    circle.setCenterY(Math.sin(100/i) * 15 + Math.random() * 30);
                    circle.setCenterX(Math.cos(100/i) * 40 + Math.random() * 30);
                }
            }
            public void locateOn(double x, double y){
                setLayoutX(x);
                setLayoutY(y);
            }
        }
        private static class Sun extends Circle{
            Sun(){
                super(40);
                setFill(Color.YELLOW);
            }
        }
    }

    private static class Field extends Rectangle{
        private final double ratio;
        Field(double ratio, double width, double height){
            super(width, height * ratio);
            this.ratio = ratio;
            setY(height * (1 - ratio));
            setFill(Color.GREEN);
        }
        public void update(double width, double height){
            setWidth(width);
            setHeight(height * (1 - ratio));
            setY(height * ratio);
        }
    }
}
