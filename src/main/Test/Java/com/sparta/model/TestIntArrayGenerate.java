package com.sparta.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestIntArrayGenerate {

    @Test
   public void givenInputOfTwentyIsAnArrayOf20NumbersGenerated(){
        IntArrayGenerate myArray = new IntArrayGenerate();
        assertTrue(myArray.intArrayGen(20).length == 20);
   }
}
