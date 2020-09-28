import java.lang.Math;
import java.util.Arrays;

public class task1 {
    public static void main(String[] args) {
        float[] myList = new float[5];
        float mySum = 0;
        for (int i = 0; i < myList.length; i++) {
            myList[i] = (float) Math.random();
            mySum += myList[i];
        }
        Arrays.sort(myList);
        float myMax = myList[myList.length - 1];
        float myMin = myList[0];
        float myAvg = mySum/myList.length;

        System.out.println(Arrays.toString(myList));
        System.out.println("Max is "+myMax);
        System.out.println("Min is "+myMin);
        System.out.println("Avg is "+myAvg);
    }
}
