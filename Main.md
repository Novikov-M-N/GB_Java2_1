package geekbrains.java_level2;

public class Main {

    public static void main(String[] args) {
        String[][] arraySizeExcept = {
                {"3","7","0","1"},
                {"12","10","8","3"},
                {"3","7","0"},
                {"12","10","8","3"}
        };

        String[][] arrayDataExcept = {
                {"3","7","phfh","1"},
                {"12","10","8","3"},
                {"3","7","0","1"},
                {"12","10","8","3"}
        };

        String[][] arrayCorrect = {
                {"3","7","0","1"},
                {"12","10","8","3"},
                {"3","7","0","1"},
                {"12","10","8","3"}
        };

        try{
            checkArray(arrayCorrect);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }


    public static void checkArray(String [][] array) throws MyArraySizeException, MyArrayDataException {
        for (int i = 0; i < array.length; i++) {
            if (array.length != 4 || array[i].length != 4) {
                throw new MyArraySizeException("Array size should not be other than 4x4");
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length ; j++) {
                try {
                    sum += Integer.valueOf(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Data at element [" + i + "][" + j + "] is not a number. Please insert correct data");
                    }
                }
            }
        System.out.println("Total sum is " + sum);
        }
}