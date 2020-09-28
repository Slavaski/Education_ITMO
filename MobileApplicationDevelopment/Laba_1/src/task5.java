import java.util.Scanner;

public class task5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = in.nextInt();
        int[] myArr = new int[N];
        myArr[0] = 0;
        for (int i = 1; i < N; ++i) {
            myArr[1] = 1;
            if (i == 1) {
                System.out.print(N + " Fibonacci number is " + myArr[N - 1]);
            } else {
                myArr[i] = myArr[i - 1] + myArr[i - 2];
            }
        }
        System.out.print(N + " Fibonacci number is " + myArr[N - 1]);
    }
}
