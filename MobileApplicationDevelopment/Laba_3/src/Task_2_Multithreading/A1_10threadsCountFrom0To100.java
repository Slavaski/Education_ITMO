package Task_2_Multithreading;

public class A1_10threadsCountFrom0To100 {
    public static void main(String[] args) {
        for (int j = 0; j < 10; j++) {
            int finalJ = j;
            Thread myThready = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(finalJ + " thread: " + (i + 1));
                    }
                }
            });
            System.out.println(myThready.getState());
            myThready.start();
            System.out.println("!!!!   " + myThready.getId());
        }
    }
}
