package Task_2_Multithreading;

public class A2_CheckThreadsState {
    public static void main(String[] args) {
        Thread myThready = new Thread(new Runnable() {
            public void run() {
                Thread.State state = Thread.currentThread().getState();
                System.out.println(state+" - in \"run\"");
            }
        });
        System.out.println(myThready.getState()+" - before \"start\"");
        myThready.start();
        System.out.println(myThready.getState()+" - after \"start\"");
    }
}
