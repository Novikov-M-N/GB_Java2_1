package lesson2Homework;

public class MyArraySizeException extends Exception{

    public MyArraySizeException(int iMust, int jMust, int i, int j) {
        super("Illegal size of array: " + i + 'x' + j + ". Must be " + iMust + 'x' + jMust + '.');
    }
}
