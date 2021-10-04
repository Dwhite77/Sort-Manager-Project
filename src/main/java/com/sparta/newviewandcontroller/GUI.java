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

import javafx.geometry.Side;
import javafx.scene.Scene;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.util.ArrayList;
//----------------------------------------------------------------------------------------------
//  GUI Code
//----------------------------------------------------------------------------------------------

public class GUI extends Application{

    public static void guiRun(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage){

        Logger log = LoggingMain.getLogger();

        int buttonWidth = 110;

        Button buttonExit = new Button("Exit");
        Button buttonSort = new Button("Start Sort");
        Button buttonStyle = new Button("Old Style");

        CheckBox bubbleCheckBox = new CheckBox("BubbleSort");
        CheckBox mergeCheckBox = new CheckBox("MergeSort");
        CheckBox quickCheckBox = new CheckBox("QuickSort");
        CheckBox binaryCheckBox = new CheckBox("BinaryTreeSort");
        CheckBox insertionCheckBox = new CheckBox("InsertionSort");
        CheckBox selectionCheckBox = new CheckBox("SelectionSort");
        CheckBox standardArraySortCheckBox = new CheckBox("Std Array");
        CheckBox standardCollectionsSortCheckBox = new CheckBox("Std Collections");
        CheckBox standardArrayParallelSortCheckBox = new CheckBox("Std Array Parallel");

        Text textBub = new Text();
        Text textMerge = new Text();
        Text textQuick = new Text();
        Text textBin = new Text();
        Text textInsert = new Text();
        Text textSelect = new Text();
        Text textSLCS = new Text();
        Text textSLAS = new Text();
        Text textSLAPS = new Text();
        Text textRandNums = new Text();
        Text textSortedNums = new Text();

        TextField arrayTextField = new TextField("Array Size?");
        TextField upperBoundsTextField = new TextField("Int Gen Upper Bounds");

        ArrayList<SortFactory> sortFactories = new ArrayList<SortFactory>();

        // set widths of buttons and text field, so they are the same
        buttonExit.setPrefWidth(buttonWidth);
        buttonSort.setPrefWidth(buttonWidth);
        buttonSort.setPrefHeight(35);
        buttonStyle.setPrefWidth(buttonWidth);
        arrayTextField.setPrefWidth(buttonWidth);
        upperBoundsTextField.setPrefWidth(buttonWidth);

        //---------------------------------------------------------------------------------------------------

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Sort Type");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Time Taken (ns)");

        BarChart barChart = new BarChart(xAxis, yAxis);
        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("Run 1");
        barChart.setAnimated(false); // unfortunately these animations are really buggy and therefore to get the GUI to function correctly I have to disable this
        yAxis.setSide(Side.RIGHT);
        ArrayList<Text> textOutputs = new ArrayList<Text>();

        GridPane gridPane = new GridPane();

        //-------------------------------------------------------------------------
        //Event handling
        //-------------------------------------------------------------------------
        upperBoundsTextField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String strUpperBounds = upperBoundsTextField.getText();
                int upperBounds = 0;
                try{
                    upperBounds = Integer.parseInt(strUpperBounds);
                    IntArrayGenerate.setUpperBounds(upperBounds);
                } catch(Exception e){
                    log.error("User didn't select a valid int");
                    System.err.println("Not a Valid Int");
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
                //---------------------------------------------------------------------
                //resets the values and bar chart
                //---------------------------------------------------------------------
                barChart.getData().clear();
                dataSeries1.getData().clear();
                textBub.setText(" ");
                textBin.setText(" ");
                textMerge.setText(" ");
                textSelect.setText(" ");
                textInsert.setText(" ");
                textQuick.setText(" ");
                textSLCS.setText(" ");
                textSLAS.setText(" ");
                textSLAPS.setText(" ");
                textRandNums.setText(" ");
                textSortedNums.setText(" ");



                sortFactories.clear();
                String s = arrayTextField.getText();
                int arraySize = 0;

                try{
                    textOutputs.clear();
                    arraySize = Integer.parseInt(s);
                    //---------------------------------------------------------------------
                    //check box checkers
                    //---------------------------------------------------------------------
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

                    if(binaryCheckBox.isSelected()){
                        BinaryTreeSort binSort = new BinaryTreeSort();
                        sortFactories.add(binSort);
                        textOutputs.add(textBin);
                    }

                    if(standardArrayParallelSortCheckBox.isSelected()){
                        StandardArrayParallelSort sAPSort = new StandardArrayParallelSort();
                        sortFactories.add(sAPSort);
                        textOutputs.add(textSLAPS);
                    }

                    if(standardArraySortCheckBox.isSelected()){
                        StandardArraySort sASort = new StandardArraySort();
                        sortFactories.add(sASort);
                        textOutputs.add(textSLAS);
                    }

                    if(standardCollectionsSortCheckBox.isSelected()){
                        StandardCollectionSort colSort = new StandardCollectionSort();
                        sortFactories.add(colSort);
                        textOutputs.add(textSLCS);
                    }


                    if(sortFactories.isEmpty()){
                        System.err.println("No Sort type selected");
                        log.info("User tried to start without selecting a Sort");
                    }
                    else{
                        //---------------------------------------------------------------------
                        //random array generation
                        //---------------------------------------------------------------------
                        IntArrayGenerate intArray = new IntArrayGenerate();
                        int[] myArr = intArray.intArrayGen(arraySize);

                        String strOutRand = "";
                        for(int j=0;j<myArr.length;j++){
                            strOutRand += myArr[j]+" ";
                        }

                        System.out.print("Random Array: " + strOutRand);
                        if(myArr.length <= 100){
                            textRandNums.setText("Random Array: " + strOutRand);
                        }
                        //-----------------------------------------------------------------------------------------------------------------------------------
                        // This is what works out how much data we are going to display, on both the bar chart and the text outputs
                        //-----------------------------------------------------------------------------------------------------------------------------------
                        System.out.println();
                        int sFLen = sortFactories.size() -1;
                        for(int i = 0; i < sortFactories.size();i++){
                            int[] tempArr = myArr.clone();
                            sortFactories.get(i).sort(tempArr);
                            if(i==0){
                                sortFactories.get(i).printArray(sortFactories.get(i).sort(tempArr));
                                textSortedNums.setText("Sorted Array:    " + sortFactories.get(i).arrayString(sortFactories.get(i).sort(tempArr)));

                            }
                            textOutputs.get(i).setText(sortFactories.get(i).toString()+": "+sortFactories.get(i).getCompletionTime()+"ns");
                            dataSeries1.getData().add(new XYChart.Data(sortFactories.get(i).toString(),sortFactories.get(i).getCompletionTime()));
                            gridPane.getChildren().remove(textOutputs.get(i));
                            gridPane.add(textOutputs.get(i),1,i+1,1,1);
                            System.out.println(sortFactories.get(i).toString()+": "+sortFactories.get(i).getCompletionTime()+" ");
                        }
                        gridPane.getChildren().remove(barChart);
                        gridPane.add(barChart, 2,0,5,30);
                        barChart.getData().add(dataSeries1);

                        //-----------------------------------------------------------------------------------------------------------------------------------

                    }
                } catch(Exception e){
                    //e.printStackTrace();
                    System.err.println("Not a valid int");
                    log.error("User didn't select a valid int");
                }

            }
        });

         //-------------------------------------------------------------------------
        //Grid creation
        //-------------------------------------------------------------------------

        //size of the pane
        gridPane.setMinSize(900,200);
        //setting the border
        gridPane.setPadding(new Insets(10,10,10,10));
        //setting vert and horiz gaps between columns
        gridPane.setVgap(5);
        gridPane.setHgap(20);

        //set grid alignment
        gridPane.setAlignment(Pos.TOP_LEFT);

        //arranging Check Boxes onto grid nodes
        gridPane.add(buttonExit, 0,25,1,2);
        gridPane.add(buttonSort,0,14,1,3);
        gridPane.add(buttonStyle,0,21,1,2);

        gridPane.add(arrayTextField, 0, 11,1,2);
        gridPane.add(upperBoundsTextField,0,18,1,1);

        gridPane.add(bubbleCheckBox,0, 1);
        gridPane.add(mergeCheckBox,0, 2);
        gridPane.add(quickCheckBox,0, 3);
        gridPane.add(selectionCheckBox,0, 4);
        gridPane.add(insertionCheckBox,0, 5);
        gridPane.add(binaryCheckBox,0, 6);

        gridPane.add(standardArrayParallelSortCheckBox,0,7);
        gridPane.add(standardArraySortCheckBox,0,8);
        gridPane.add(standardCollectionsSortCheckBox,0,9);

        gridPane.add(textRandNums,0,36,5,1);
        gridPane.add(textSortedNums,0,37,5,1);

        gridPane.add(barChart, 2,0,5,30);


        //button styling - css
        buttonExit.setStyle("-fx-background-color: firebrick; -fx-text-fill: white;");
        buttonStyle.setStyle("-fx-background-color: firebrick; -fx-text-fill: white;");
        buttonSort.setStyle("-fx-background-color: firebrick; -fx-text-fill: white;");
        //buttonResetData.setStyle("-fx-background-color: firebrick; -fx-text-fill: white;");

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
