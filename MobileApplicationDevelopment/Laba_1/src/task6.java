import java.util.*;

public class task6 {
    public static void main(String[] args) {
        int min = -10, max = 10, i, lengthOfArr = 10, k = 0;
        Random rand = new Random();
        ArrayList<Integer> myArr = new ArrayList<>();
        for (i = 0; i < lengthOfArr; i++)
            myArr.add(i, rand.nextInt(max - min));

        System.out.println(Arrays.toString(new ArrayList[]{myArr}));

        Scanner in = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = in.nextInt();
        for (i = 0; i < lengthOfArr; i++)
            if (myArr.get(i) == N) {
                k++;
                lengthOfArr--;
                myArr.remove(i);
                i--;
            }
        System.out.println(Arrays.toString(new ArrayList[]{myArr}));
        if (k == 0)
            System.out.println("No matches.");
        else {
            if (k == 1)
                System.out.println("1 element has been removed.");
            else
                System.out.println(k + " elements have been removed.");
        }
    }
}
