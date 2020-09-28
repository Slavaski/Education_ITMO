import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = in.nextInt();
        System.out.print("Enter k: ");
        int k = in.nextInt();
        System.out.print("Algebraic sum is "+myAlgSum(N, k));

    }

    private static float myAlgSum(int N, int k) {
        float mySum = 0;
        int i = 0;
        while (i < N) {
            i++;
            mySum += (Math.pow(i, k));
        }
        return mySum;
    }
}
