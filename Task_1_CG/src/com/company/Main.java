package com.company;

import com.company.Picture.Background;
import com.company.Picture.Forest;
import com.company.Picture.House;
import com.company.Picture.Tree;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
	    Application.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        stage.setWidth(700);
        stage.setHeight(700);
        //pane.setStyle("-fx-background-color: blue;");

        Background background = new Background(0.4, stage.getWidth(), stage.getHeight());
        Forest forest = new Forest(stage.getWidth() / 2, stage.getHeight() , 20);
        forest.locateOn(stage.getWidth() / 2, stage.getHeight() * 0.4);
        //Tree tree = new Tree(100);
        //tree.locateOn(300, 300);
        House house = new House(stage.getWidth() / 4, stage.getHeight() / 3);
        //house.locateOn(500, 500);
        pane.getChildren().addAll(background, forest, house);

        pane.layoutBoundsProperty().addListener((observableValue, bounds, t1) -> {
            background.update(stage.getWidth(), stage.getHeight());
            //tree.update(0.4, stage.getWidth(), stage.getHeight());
            house.update(0.4, stage.getWidth(), stage.getHeight());
            forest.update(stage.getWidth(), stage.getHeight());
        });
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }


}

