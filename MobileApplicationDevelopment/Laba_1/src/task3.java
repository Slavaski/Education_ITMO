import java.util.Arrays;

public class task3 {
    public static void main(String[] args) {
        float[] myList = new float[10];
        for (int i = 0; i < myList.length; ++i) {
            myList[i] = (float) Math.random();
        }
        System.out.println(Arrays.toString(myList));
        bubbleSort(myList);
    }

    private static void bubbleSort(float[] myArr) {
        for (int j = 1; j < myArr.length - 1; j++) {
            for (int i = 0; i < myArr.length - 1; i++) {
                if (myArr[i] > myArr[i + 1]) {
                    float buffer = myArr[i];
                    myArr[i] = myArr[i + 1];
                    myArr[i + 1] = buffer;
                }
            }
        }
        System.out.print(Arrays.toString(myArr));
    }
}
