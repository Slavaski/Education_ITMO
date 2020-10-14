package Task_2_Multithreading;

public class A4_2threadsPrintNameAlternately {
    public static void main(String[] args) {
        Thread[] myThready = new Thread[2];
        for (int j = 0; j < 2; j++) {
            int finalJ = j;
            myThready[finalJ] = new Thread(new Runnable() {
                public void run() {
                    myThready[finalJ].setName("Thread"+ finalJ);
                }
            });
            myThready[finalJ].start();
        }
        for (int j = 0; j < 6; j++) {
            System.out.println(myThready[0].getName());
            Thread.yield();
            System.out.println(myThready[1].getName());
            Thread.yield();
        }
    }
}
