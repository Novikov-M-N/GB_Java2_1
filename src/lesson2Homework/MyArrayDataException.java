package lesson2Homework;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int i, int j) {
        super("Illegal data in array element [" + i + "][" + j + ']');
    }
}
