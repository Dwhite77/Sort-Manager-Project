package com.sparta.viewandcontroller;


import static javafx.application.Application.launch;

public class DisplayManager{
    public static void main(String[] args) {



        GUI gui = new GUI(); // if you're not doing anything with gui then turn this off
        gui.guiRun(args);

        AskQuestions testQuestions = new AskQuestions();
        testQuestions.askQuestions();



    }

// change things so that there arent void/0 arg methods


}

