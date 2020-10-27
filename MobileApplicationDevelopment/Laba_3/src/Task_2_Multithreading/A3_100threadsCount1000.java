package Task_2_Multithreading;

import java.util.concurrent.TimeUnit;

public class A3_100threadsCount1000 {
    public static void main(String[] args) {
        Counter count = new Counter();
        for (int j = 0; j < 100; j++) {
            int finalJ = j;
            Thread myThready = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        count.increment();

                    }
                }
            });
            myThready.start();
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count.getCount());
    }
}
