import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of threads: ");
        int numberThreads = in.nextInt();
        System.out.print("Enter path to file with urls: ");
        String filePath = in.next();
        System.out.print("Enter path to folder for downloading: ");
        String downloadPath = in.next();

        BufferedReader file;
        ArrayList<String> pathsNames = new ArrayList<>();
        try {
            file = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = file.readLine()) != null) {
                pathsNames.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }

        DownloadingThread[] threads = new DownloadingThread[numberThreads];
        while (!pathsNames.isEmpty()) {
            for (int i = 0; i < numberThreads; i++) {
                if (!pathsNames.isEmpty() && DownloadingThread.getCounter() < numberThreads) {
                    String[] pathName1 = pathsNames.get(0).split(" ");
                    threads[i] = new DownloadingThread(pathName1[0], pathName1[1], downloadPath);
                    threads[i].start();
                    pathsNames.remove(0);
                } else {
                    DownloadingThread.getCounter();
                    break;
                }
            }
            for (DownloadingThread thread : threads) {
                thread.join();
            }
        }
        in.close();

        for (DownloadingThread thread : threads) {
            thread.join();
        }
        DownloadingThread.printTotal();
    }
}
