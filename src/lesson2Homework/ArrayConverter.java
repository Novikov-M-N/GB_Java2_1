package lesson2Homework;

public class ArrayConverter {
    private final int iSize;
    private final int jSize;
    private final int iLength;
    private final int jLength;
    private String[][] arr;

    public ArrayConverter(int iSize, int jSize, String[][] arr) throws MyArraySizeException {
        this.iSize = iSize;
        this.jSize = jSize;
        this.arr = arr;
        this.iLength = arr.length;
        if (iLength == 0) { throw new MyArraySizeException(iSize, jSize, 0, 0); }
        this.jLength = arr[0].length;
        if (iLength != iSize || jLength != jSize) { throw new MyArraySizeException(iSize, jSize, iLength, jLength); }
    }

    public int convert() throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < iLength; i++) {
            for (int j = 0; j < jLength; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (Exception e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}
