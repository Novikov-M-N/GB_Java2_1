package lesson2Homework;

public class Main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {

        String[][] arr = new String[4][4];
        arr[0][0] = "2";    arr[0][1] = "4";        arr[0][2] = "8";        arr[0][3] = "16";
        arr[1][0] = "32";   arr[1][1] = "64";       arr[1][2] = "128";      arr[1][3] = "256";
        arr[2][0] = "Вася"; arr[2][1] = "1024";     arr[2][2] = "2048";     arr[2][3] = "4096";
        arr[3][0] = "8192"; arr[3][1] = "16384";    arr[3][2] = "32768";    arr[3][3] = "13";



        ArrayConverter arrayConverter = new ArrayConverter(4, 4, arr);
        System.out.println(arrayConverter.convert());
    }
}
