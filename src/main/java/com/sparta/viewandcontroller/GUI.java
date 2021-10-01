package com.sparta.viewandcontroller;

import com.sparta.logging.LoggingMain;
import com.sparta.model.SortFactory;
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

import java.util.ArrayList;
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

        Button buttonExit = new Button("Exit");
        Button buttonAgain = new Button("Again?");
        Button buttonSort = new Button("Start Sort");
        Button buttonStyle = new Button("Old Style");

        CheckBox bubbleCheckBox = new CheckBox("BubbleSort");
        CheckBox mergeCheckBox = new CheckBox("MergeSort");
        CheckBox quickCheckBox = new CheckBox("QuickSort");
        CheckBox binaryCheckBox = new CheckBox("BinaryTreeSort");
        CheckBox insertionCheckBox = new CheckBox("InsertionSort");
        CheckBox selectionCheckBox = new CheckBox("SelectionSort");

        TextField arrayTextField = new TextField("Array Size?");

        // set widths of buttons and text field, so they are the same
        buttonExit.setPrefWidth(buttonWidth);
        buttonAgain.setPrefWidth(buttonWidth);
        buttonSort.setPrefWidth(buttonWidth);
        buttonStyle.setPrefWidth(buttonWidth);
        arrayTextField.setPrefWidth(buttonWidth);


        //creating pane object
        GridPane gridPane = new GridPane();

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



        buttonExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });


        buttonSort.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // i want this to begin the sorting, i also want it to disable the style button, to prevent both the askquestions being run as well as the new method that I implement
                // either needs to be disabled if there is no int input or throw an exception.
                // when things are disabled I want their style to change so that they are obviously grayed out
                
                ArrayList<SortFactory> sortFactories = new ArrayList<SortFactory>();

                if(bubbleCheckBox.isSelected()){

                }

                if(mergeCheckBox.isSelected()){

                }

                if(binaryCheckBox.isSelected()){

                }

                if(quickCheckBox.isSelected()){

                }


            }
        });

        buttonAgain.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Again");
            }
        });
        // array of sorters that is populated from the gui selections when the go button is pressed
        // checkboxes are checked to see if they are in the ticked or not ticked state, if they are ticked then they are added to an array of sorts, where the int array size input is then fed into them.
        // once the int array size is fed in, we can change the gui to be an output screen where it compares the times of the sort types


        //-------------------------------------------------------------------------
        //Grid creation
        //-------------------------------------------------------------------------

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
        gridPane.add(buttonExit, 2,5);
        gridPane.add(buttonAgain,2, 1);
        gridPane.add(buttonSort,1,1);
        gridPane.add(buttonStyle,2,3);
        gridPane.add(arrayTextField, 1, 5);

        gridPane.add(bubbleCheckBox,0, 0);
        gridPane.add(mergeCheckBox,0, 1);
        gridPane.add(quickCheckBox,0, 2);
        gridPane.add(selectionCheckBox,0, 3);
        gridPane.add(insertionCheckBox,0, 4);
        gridPane.add(binaryCheckBox,0, 5);


        //button styling
        buttonExit.setStyle("-fx-background-color: firebrick; -fx-text-fill: white;");
        buttonAgain.setStyle("-fx-background-color: firebrick; -fx-text-fill: white;");
        buttonStyle.setStyle("-fx-background-color: firebrick; -fx-text-fill: white;");
        buttonSort.setStyle("-fx-background-color: firebrick; -fx-text-fill: white;");

//        arrayTextField.se

        //pane styling
        gridPane.setStyle("-fx-background-color: mistyrose;");



        //creating a scene object
        Scene scene = new Scene(gridPane);




        //window title
        primaryStage.setTitle("Sort Choice GUI");

        primaryStage.setScene(scene);
        primaryStage.show();

        buttonStyle.setOnAction(new EventHandler<ActionEvent>() {       // this allows for the full functionality of the old system, whilst maintaining the ability to work on the gui version,
                                                                        // so if its uncompleted I can throw errors and say its uncompleted but also show off the wokring version wihtout a gui
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.hide();
                AskQuestions.askQuestions();
            }
        });

    }

}
