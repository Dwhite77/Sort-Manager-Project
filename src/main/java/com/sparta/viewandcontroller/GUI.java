package com.sparta.viewandcontroller;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
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
        Button buttonDone = new Button("Done");
        buttonDone.setPrefWidth(75);
        Button buttonAgain = new Button("Again?");
        buttonAgain.setPrefWidth(75);

        TextField arrayTextField = new TextField("Array Size?");
        arrayTextField.setPrefWidth(75);
        // CheckBoxes
        CheckBox bubbleCheckBox = new CheckBox("BubbleSort");
        CheckBox mergeCheckBox = new CheckBox("MergeSort");
        CheckBox quickCheckBox = new CheckBox("QuickSort");
        CheckBox binaryCheckBox = new CheckBox("BinaryTreeSort");
        CheckBox insertionCheckBox = new CheckBox("InsertionSort");
        CheckBox selectionCheckBox = new CheckBox("SelectionSort");

        //Comparison CheckBoxes


        //creating pane object
        GridPane gridPane = new GridPane();
        //size of the pane
        gridPane.setMinSize(400,200);
        //setting the border
        gridPane.setPadding(new Insets(10,10,10,10));
        //setting vert and horiz gaps between columns
        gridPane.setVgap(5);
        gridPane.setHgap(20);

        //set grid alignment
        gridPane.setAlignment(Pos.CENTER);

        //arranging Check Boxes onto grid nodes
        gridPane.add(buttonDone, 1,1);
        gridPane.add(buttonAgain,1, 3);
        gridPane.add(arrayTextField, 1, 5);
        gridPane.add(bubbleCheckBox,0, 0);
        gridPane.add(mergeCheckBox,0, 1);
        gridPane.add(quickCheckBox,0, 2);
        gridPane.add(selectionCheckBox,0, 3);
        gridPane.add(insertionCheckBox,0, 4);
        gridPane.add(binaryCheckBox,0, 5);


        //button styling
        buttonDone.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        buttonAgain.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        //arrayTextField.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
//        arrayTextField.se

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
