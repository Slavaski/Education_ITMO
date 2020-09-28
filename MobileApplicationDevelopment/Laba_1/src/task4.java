public class task4 {
    public static void main(String[] args) {
        int j;
        for (int i = 2; i < 100; i++) {
            int k = 0;
            for (j = 2; j <= i; j++) {
                if ((i % j) == 0)
                    k++;
            }
            if (k < 2)
                System.out.print(i+" ");
        }
    }
}
