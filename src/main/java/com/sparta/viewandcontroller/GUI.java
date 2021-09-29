package com.sparta.viewandcontroller;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
//----------------------------------------------------------------------------------------------
//  GUI stuff
//----------------------------------------------------------------------------------------------

public class GUI extends Application{

    public static void guiRun(String[] args) {
        launch();
    }
    @Override
    public void start(Stage primaryStage){

        //buttons
        Button buttonBubble = new Button("BubbleSort");
        Button buttonMerge = new Button("MergeSort");
        Button buttonQuick = new Button("QuickSort");

        //creating pane object
        GridPane gridPane = new GridPane();
        //size of the pane
        gridPane.setMinSize(400,200);
        //setting the border
        gridPane.setPadding(new Insets(10,10,10,10));
        //setting vert and horiz gaps between columns
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        //set grid alignment
        gridPane.setAlignment(Pos.CENTER);

        //arranging buttons onto grid nodes
        gridPane.add(buttonBubble, 0,0);
        gridPane.add(buttonMerge,1,0);
        gridPane.add(buttonQuick,2,0);

        //button styling
        buttonBubble.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        buttonQuick.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        buttonMerge.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        //pane styling
        gridPane.setStyle("-fx-background-color: BEIGE;");

        //creating a scene object
        Scene scene = new Scene(gridPane);

        //window title
        primaryStage.setTitle("Sort Choice GUI");

        primaryStage.setScene(scene);
        primaryStage.show();

    }


}
