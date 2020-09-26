package com.company.Picture;

import javafx.scene.Group;

import java.util.ArrayList;

public class Forest extends Group {
    private final ArrayList<Tree> forest = new ArrayList<>();
    public Forest(double width, double height, int count){
        for (int i = 0; i < count; i++) {
            Tree tree = new Tree(100 + Math.random() * 200);
            forest.add(tree);
            getChildren().add(tree);
        }
        update(width, height);
    }
    public void locateOn(double x, double y){
        setLayoutX(x);
        setLayoutY(y);
    }
    public void update(double width, double height){
        for (Tree tree :
                forest) {
            tree.update(0.4, width, height);
        }
    }
}
