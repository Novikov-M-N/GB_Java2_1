package com.geekbrains.java2.lesson2.hw;

public class MatrixSummator {
    static int MATRIX_SIZE = 4;
    static String[][] positiveTestMatrix = {
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}
    };
    static String[][] negativeTestMatrix = {
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "0"}
    };

    public static void main(String[] args) {
        sumMatrix(positiveTestMatrix);
        sumMatrix(negativeTestMatrix);
    }

    public static void sumMatrix(String[][] matrix) throws MyArrayDataException, MyArraySizeException {
        int sum = 0;
        int size = matrix.length;
        if (size != MATRIX_SIZE) {
            throw new MyArraySizeException("Размер матрицы не равен 4!");
        }
        for(int i=0; i<MATRIX_SIZE; i++) {
            if (matrix[i].length != MATRIX_SIZE) {
                throw new MyArraySizeException("Размер матрицы не равен 4!");
            }
            for (int j=0; j<MATRIX_SIZE; j++) {
                try {
                    int element = Integer.parseInt(matrix[i][j]);
                    sum += element;
                } catch (NumberFormatException ne) {
                    throw new MyArrayDataException("В ячейке [" + i + "][" + j + "] лежат неверные данные");
                }
            }
        }
        System.out.println("Сумма элементов матрицы равна " + sum);
    }
}
