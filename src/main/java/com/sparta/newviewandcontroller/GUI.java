package com.sparta.newviewandcontroller;

import com.sparta.logging.LoggingMain;
import com.sparta.model.*;
import com.sparta.oldviewandcontroller.AskQuestions;
import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;

import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.util.ArrayList;
//----------------------------------------------------------------------------------------------
//  GUI stuff
//----------------------------------------------------------------------------------------------

public class GUI extends Application{

    public static void guiRun(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage){
        Logger log = LoggingMain.getLogger();
        int buttonWidth = 80;

        Button buttonExit = new Button("Exit");
        //Button buttonAgain = new Button("Again?");
        Button buttonSort = new Button("Start Sort");
        Button buttonStyle = new Button("Old Style");

        CheckBox bubbleCheckBox = new CheckBox("BubbleSort");
        CheckBox mergeCheckBox = new CheckBox("MergeSort");
        CheckBox quickCheckBox = new CheckBox("QuickSort");
        CheckBox binaryCheckBox = new CheckBox("BinaryTreeSort");
        CheckBox insertionCheckBox = new CheckBox("InsertionSort");
        CheckBox selectionCheckBox = new CheckBox("SelectionSort");

        //Arrays.sort Collections.sort, arrays.parallelSort
        CheckBox standardArraySortCheckBox = new CheckBox("Standard Lib Array Sort");
        CheckBox standardCollectionsSortCheckBox = new CheckBox("Standard Lib Collections Sort");
        CheckBox standardArrayParallelSortCheckBox = new CheckBox("Standard Lib Array Parallel Sort");

        TextField arrayTextField = new TextField("Array Size?");

        // set widths of buttons and text field, so they are the same
        buttonExit.setPrefWidth(buttonWidth);
        //buttonAgain.setPrefWidth(buttonWidth);
        buttonSort.setPrefWidth(buttonWidth);
        buttonStyle.setPrefWidth(buttonWidth);
        arrayTextField.setPrefWidth(buttonWidth);

        //---------------------------------------------------------------------------------------------------

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Sort Type");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Time Taken");

        BarChart barChart = new BarChart(xAxis, yAxis);

        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("Run 1");


        //---------------------------------------------------------------------------------------------------

        //creating pane object
        GridPane gridPane = new GridPane();

        //-------------------------------------------------------------------------
        //Event handling
        //-------------------------------------------------------------------------

        buttonExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        buttonSort.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ArrayList<SortFactory> sortFactories = new ArrayList<SortFactory>();
                String s = arrayTextField.getText();
                int arraySize = 0;

                try{
                    arraySize = Integer.parseInt(s);
                    if(bubbleCheckBox.isSelected()){
                        BubbleSort bubSort = new BubbleSort();
                        sortFactories.add(bubSort);
                    }

                    if(mergeCheckBox.isSelected()){
                        MergeSort mSort = new MergeSort();
                        sortFactories.add(mSort);
                    }

                    if(binaryCheckBox.isSelected()){
                        BinaryTreeSort binSort = new BinaryTreeSort();
                        sortFactories.add(binSort);
                    }

                    if(quickCheckBox.isSelected()){
                        QuickSort qSort = new QuickSort();
                        sortFactories.add(qSort);
                    }

                    if(selectionCheckBox.isSelected()){
//                    System.err.println("Selection Sort is not currently implemented"); //this is to demonstrate usage of this stuff
//                    log.info("User tried to select Selection Sort");
                        SelectionSort sSort = new SelectionSort();
                        sortFactories.add(sSort);
                    }

                    if(insertionCheckBox.isSelected()){
//                    System.err.println("Insertion Sort is not currently implemented"); //this is to demonstrate usage of this stuff
//                    log.info("User tried to select Insertion Sort");
                        InsertionSort iSort = new InsertionSort();
                        sortFactories.add(iSort);
                    }

                    if(sortFactories.isEmpty()){
                        System.err.println("No Sort type selected");
                        log.info("User tried to start without selecting a Sort");
                    }
                    else{
                        IntArrayGenerate intArray = new IntArrayGenerate();
                        int[] myArr = intArray.intArrayGen(arraySize);
                        for(int j=0;j<myArr.length;j++){
                            System.out.print(myArr[j]+" ");
                        }
                        System.out.println();
                        for(int i = 0; i < sortFactories.size();i++){
                            sortFactories.get(i).setStartTime();
                            sortFactories.get(i).sort(myArr);
                            sortFactories.get(i).setEndTime();
                            if(i==0){
                                sortFactories.get(i).printArray(myArr);
                            }
                            dataSeries1.getData().add(new XYChart.Data(sortFactories.get(i).toString(),sortFactories.get(i).getCompletionTime()));
                            System.out.println(sortFactories.get(i).toString()+": "+sortFactories.get(i).getCompletionTime());
                        }
                        barChart.getData().add(dataSeries1);
                    }
                } catch(Exception e){
                    e.printStackTrace();
                    System.err.println("Not a valid int");
                    log.error("User didn't select a valid int");
                }

            }
        });

        // once the int array size is fed in, we can change the gui to be an output screen where it compares the times of the sort types


        //-------------------------------------------------------------------------
        //Grid creation
        //-------------------------------------------------------------------------

        //size of the pane
        gridPane.setMinSize(800,400);
        //setting the border
        gridPane.setPadding(new Insets(10,10,10,10));
        //setting vert and horiz gaps between columns
        gridPane.setVgap(5);
        gridPane.setHgap(20);

        //set grid alignment
        gridPane.setAlignment(Pos.CENTER);

        //arranging Check Boxes onto grid nodes
        gridPane.add(buttonExit, 2,4);
        gridPane.add(buttonSort,2,2);
        gridPane.add(buttonStyle,0,4);

        gridPane.add(arrayTextField, 1, 4);

        gridPane.add(bubbleCheckBox,0, 1);
        gridPane.add(mergeCheckBox,0, 2);
        gridPane.add(quickCheckBox,0, 3);
        gridPane.add(selectionCheckBox,1, 1);
        gridPane.add(insertionCheckBox,1, 2);
        gridPane.add(binaryCheckBox,1, 3);
        gridPane.add(barChart, 5,5,5,5);

        //button styling - css
        buttonExit.setStyle("-fx-background-color: firebrick; -fx-text-fill: white;");
        buttonStyle.setStyle("-fx-background-color: firebrick; -fx-text-fill: white;");
        buttonSort.setStyle("-fx-background-color: firebrick; -fx-text-fill: white;");

        //pane styling - css
        gridPane.setStyle("-fx-background-color: mistyrose;");
        //creating a scene object
        Scene choiceScene = new Scene(gridPane);


        //--------------------------------------------------------------------------


        //window title
        primaryStage.setTitle("Sort Choice GUI");

        primaryStage.setScene(choiceScene);
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
