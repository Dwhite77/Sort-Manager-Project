# Sort Manager Project
Project for week 4

The Sort Manager Project, is a small application used to generate an array of random numbers and them sort them into numerical order.

## Installation

### What was the Project motivation
The Motivation behind the project is simple:
- A desire to improve my Java Skills by putting them into practice, using a number of the skills I have picked up over the past few weeks.
-
### Why did I build the project?
### what problem does it solve
### what did I learn

## Features
My Project contains a large number of special features that allow it to stand out from the crowd.
#### GUI
Namely an intuitive GUI that makes it far easier to use, as everything is spelled out for the user. - Insert Picture of GUI -
#### Check Boxes
No longer do they have to contend with clunky typed inputs instead I have implemented a simple CheckBox system that allows multiple sorts to be run simultaneously for comparison. - Insert picture of checkboxes -
#### Bar Chart
A Bar Chart makes the time comparisons far easier when it comes to larger numbers, as during the manual testing phase it became clear that when the numbers are large it becomes more difficult to differentiate between the results. - Insert picture of Bar Chart here -





## Testing

During various phases of development there has been a number of JUnit tests that have been carried out, here are couple from various sections of the application.

```java
@Test
public void givenArrayWithTwoEqualIntsReturnSortedArray(){
    int[] testArray = {12,12,54,1,20,10};
    int[] testSortedArray = {1,10,12,12,20,54};
    BinaryTreeSort theTreeTest = new BinaryTreeSort();
    int[] sortedArray = theTreeTest.sort(testArray);
    assertArrayEquals(testSortedArray, sortedArray);
}

@Test
public void givenTwoNumbersInAnArrayReturnSwappedNumbersInAnArray(){
    int[] myArr = {12,23};
    int[] mySwappedArr = {23,12};
    QuickSort.swap(myArr,0,1);
    assertArrayEquals(myArr,mySwappedArr);
}
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## Help on readmes
[Click Me!](https://www.freecodecamp.org/news/how-to-write-a-good-readme-file/)
