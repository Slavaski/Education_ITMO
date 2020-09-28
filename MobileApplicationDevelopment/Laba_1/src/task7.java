import java.util.Arrays;
import java.util.Random;

public class task7 {
    public static void main(String[] args) {
        byte min = -1, max = 2, lengthOfArr = 4, i, j, count;
        Random rand = new Random();
        int[] myArr = new int[lengthOfArr];
        int[] unqArr = new int[lengthOfArr];

        for (i = 0; i < myArr.length; i++) {
            myArr[i] = rand.nextInt(max - min);
            unqArr[i] = -1;
        }
        Arrays.sort(myArr);
        System.out.println(Arrays.toString(myArr));

        for (i = 0; i < lengthOfArr; i++) {
            count = 1;
            for (j = (byte) (i + 1); j < lengthOfArr; j++)
                if (myArr[i] == myArr[j]) {
                    count++;
                    unqArr[j] = 0;
                }
            if (unqArr[i] != 0)
                unqArr[i] = count;
        }
        byte hasUnq=0;
        for (i = 0; i < lengthOfArr; i++)
            if (unqArr[i] == 1){
                hasUnq=1;
                System.out.println(myArr[i]);}
        if(hasUnq!=1)
            System.out.println("No unique values.");
    }
}
