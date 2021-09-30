package com.sparta.viewandcontroller;

import com.sparta.logging.LoggingMain;
import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;

import javafx.scene.control.*;

import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.util.EventListener;
//----------------------------------------------------------------------------------------------
//  GUI stuff
//----------------------------------------------------------------------------------------------

public class GUI extends Application{

    public static void guiRun(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage){

        int buttonWidth = 75;

        Button buttonDone = new Button("Done");
        Button buttonAgain = new Button("Again?");

        CheckBox bubbleCheckBox = new CheckBox("BubbleSort");
        CheckBox mergeCheckBox = new CheckBox("MergeSort");
        CheckBox quickCheckBox = new CheckBox("QuickSort");
        CheckBox binaryCheckBox = new CheckBox("BinaryTreeSort");
        CheckBox insertionCheckBox = new CheckBox("InsertionSort");
        CheckBox selectionCheckBox = new CheckBox("SelectionSort");

        TextField arrayTextField = new TextField("Array Size?");

        // set widths of buttons and text field, so they are the same
        buttonDone.setPrefWidth(buttonWidth);
        buttonAgain.setPrefWidth(buttonWidth);
        arrayTextField.setPrefWidth(buttonWidth);

        //-------------------------------------------------------------------------
        //Event handling
        //-------------------------------------------------------------------------
        arrayTextField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String s = arrayTextField.getText();;
                int arraySize = 0;
                try{
                    arraySize = Integer.parseInt(s);
                    System.out.println(arraySize); // <------------------------------------------------------------------this is what I want to connect to the array gen
                } catch(Exception e){
                    System.err.println("Not a valid int");
                    Logger log = LoggingMain.getLogger();
                    log.error("User didn't select a valid int");
                }
            }
        });

        buttonDone.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        buttonAgain.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Again");
            }
        });

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
