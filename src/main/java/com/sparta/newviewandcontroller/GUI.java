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
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
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
        Button buttonResetData = new Button("Reset Data");
        Button buttonSort = new Button("Start Sort");
        Button buttonStyle = new Button("Old Style");

        CheckBox bubbleCheckBox = new CheckBox("BubbleSort");
        CheckBox mergeCheckBox = new CheckBox("MergeSort");
        CheckBox quickCheckBox = new CheckBox("QuickSort");
        CheckBox binaryCheckBox = new CheckBox("BinaryTreeSort");
        CheckBox insertionCheckBox = new CheckBox("InsertionSort");
        CheckBox selectionCheckBox = new CheckBox("SelectionSort");


        CheckBox standardArraySortCheckBox = new CheckBox("Lib Array");
        CheckBox standardCollectionsSortCheckBox = new CheckBox("Lib Collections");
        CheckBox standardArrayParallelSortCheckBox = new CheckBox("Lib Array Parallel");

        Text textBub = new Text();
        Text textMerge = new Text();
        Text textQuick = new Text();
        Text textBin = new Text();
        Text textInsert = new Text();
        Text textSelect = new Text();
        Text textSLCS = new Text();
        Text textSLAS = new Text();
        Text textSLAPS = new Text();


        TextField arrayTextField = new TextField("Array Size?");

        // set widths of buttons and text field, so they are the same
        buttonExit.setPrefWidth(buttonWidth);
        buttonResetData.setPrefWidth(buttonWidth);
        buttonSort.setPrefWidth(buttonWidth);
        buttonSort.setPrefHeight(50);
        buttonStyle.setPrefWidth(buttonWidth);
        arrayTextField.setPrefWidth(buttonWidth);

        //---------------------------------------------------------------------------------------------------

//        CategoryAxis xAxis = new CategoryAxis();
//        xAxis.setLabel("Sort Type");
//
//        NumberAxis yAxis = new NumberAxis();
//        yAxis.setLabel("Time Taken");

//        BarChart barChart = new BarChart(yAxis, xAxis);
//        //barChart.setPrefHeight(800);
//        XYChart.Series dataSeries1 = new XYChart.Series();
//        dataSeries1.setName("Run 1");

        ArrayList<Text> textOutputs = new ArrayList<Text>();
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

                textBub.setText(" ");
                textBin.setText(" ");
                textMerge.setText(" ");
                textSelect.setText(" ");
                textInsert.setText(" ");
                textQuick.setText(" ");
                textSLCS.setText(" ");
                textSLAS.setText(" ");
                textSLAPS.setText(" ");


                ArrayList<SortFactory> sortFactories = new ArrayList<SortFactory>();
                sortFactories.clear();
                String s = arrayTextField.getText();
                int arraySize = 0;

                try{
                    textOutputs.clear();
                    arraySize = Integer.parseInt(s);

                    if(bubbleCheckBox.isSelected()){
                        BubbleSort bubSort = new BubbleSort();
                        sortFactories.add(bubSort);
                        textOutputs.add(textBub);
                    }

                    if(mergeCheckBox.isSelected()){
                        MergeSort mSort = new MergeSort();
                        sortFactories.add(mSort);
                        textOutputs.add(textMerge);
                    }

                    if(binaryCheckBox.isSelected()){
                        BinaryTreeSort binSort = new BinaryTreeSort();
                        sortFactories.add(binSort);
                        textOutputs.add(textBin);
                    }

                    if(quickCheckBox.isSelected()){
                        QuickSort qSort = new QuickSort();
                        sortFactories.add(qSort);
                        textOutputs.add(textQuick);
                    }

                    if(selectionCheckBox.isSelected()){
                        SelectionSort sSort = new SelectionSort();
                        sortFactories.add(sSort);
                        textOutputs.add(textSelect);
                    }

                    if(insertionCheckBox.isSelected()){
                        InsertionSort iSort = new InsertionSort();
                        sortFactories.add(iSort);
                        textOutputs.add(textInsert);
                    }

                    if(standardCollectionsSortCheckBox.isSelected()){
                        StandardCollectionSort colSort = new StandardCollectionSort();
                        sortFactories.add(colSort);
                        textOutputs.add(textSLCS);
                    }

                    if(standardArrayParallelSortCheckBox.isSelected()){

                        textOutputs.add(textSLAPS);
                    }

                    if(standardArraySortCheckBox.isSelected()){

                        textOutputs.add(textSLAS);
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
                            int[] tempArr = myArr.clone();
                            sortFactories.get(i).sort(tempArr);
                            if(i==0){
//                                if(binaryCheckBox.isSelected()){
                                    sortFactories.get(i).printArray(sortFactories.get(i).sort(tempArr));
//                                }
//                                else
//                                    sortFactories.get(i).printArray(tempArr);
                            }




                            textOutputs.get(i).setText(sortFactories.get(i).toString()+": "+sortFactories.get(i).getCompletionTime());
                            //dataSeries1.getData().add(new XYChart.Data(sortFactories.get(i).getCompletionTime(),sortFactories.get(i).toString()));

                            gridPane.getChildren().remove(textOutputs.get(i));
                            gridPane.add(textOutputs.get(i),1,i+4);


                            System.out.println(sortFactories.get(i).toString()+": "+sortFactories.get(i).getCompletionTime());

                        }

                        //gridPane.add(textVBox,1,4,1,6);
                        //gridPane.getChildren().remove(barChart);
                        //gridPane.add(barChart, 2,0,5,13);
                        //barChart.getData().add(dataSeries1);
                    }
                } catch(Exception e){
                    //e.printStackTrace();
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
        gridPane.setAlignment(Pos.TOP_LEFT);

        //arranging Check Boxes onto grid nodes
        gridPane.add(buttonExit, 8,12,1,2);
        gridPane.add(buttonSort,1,1,1,3);
        gridPane.add(buttonStyle,0,12,1,2);
        gridPane.add(buttonResetData,1,12,1,2);



        gridPane.add(bubbleCheckBox,0, 1);
        gridPane.add(mergeCheckBox,0, 2);
        gridPane.add(quickCheckBox,0, 3);
        gridPane.add(selectionCheckBox,0, 4);
        gridPane.add(insertionCheckBox,0, 5);
        gridPane.add(binaryCheckBox,0, 6);
        gridPane.add(arrayTextField, 0, 7,1,2);
        gridPane.add(standardArrayParallelSortCheckBox,0,9);
        gridPane.add(standardArraySortCheckBox,0,10);
        gridPane.add(standardCollectionsSortCheckBox,0,11);

        //gridPane.add(barChart, 2,0,5,13);


        //button styling - css
        buttonExit.setStyle("-fx-background-color: firebrick; -fx-text-fill: white;");
        buttonStyle.setStyle("-fx-background-color: firebrick; -fx-text-fill: white;");
        buttonSort.setStyle("-fx-background-color: firebrick; -fx-text-fill: white;");
        buttonResetData.setStyle("-fx-background-color: firebrick; -fx-text-fill: white;");

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

        buttonResetData.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                /* delete all data currently in play
                delete text boxes
                delete bar chart
                recreate an empty bar chart
                */

                //choiceScene.
            }
        });



    }

}
