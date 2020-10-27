import java.io.*;
import java.net.URL;

public class DownloadingThread extends Thread {
    private static int counter = 0;
    private static int countFiles = 0;
    private static float totalSize = 0;
    private static float totalTime = 0;

    private String link;
    private String name;
    private String path;
    private float size = 0;

    public DownloadingThread(String link, String name, String path) {
        super();
        this.link = link;
        this.name = name;
        this.path = path;
        counter++;
    }

    public void run() {
        System.out.println("Downloading file " + name);
        long start = System.currentTimeMillis();
        downloadContent();
        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;
        System.out.println("File " + name + " is downloaded: " + size / 1024 + "kB for " + (float) timeConsumedMillis / 1000 + " seconds");
        counter--;
        totalSize += size / 1024;
        totalTime += (float) timeConsumedMillis / 1000;
        countFiles++;
    }

    private void downloadContent() {
        while (!isInterrupted()) {
            try (BufferedInputStream in = new BufferedInputStream(new URL(link).openStream());
                 FileOutputStream fileOutputStream = new FileOutputStream(path + "\\" + name)) {
                byte[] dataBuffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                    size += bytesRead;
                }
            } catch (IOException e) {
                System.out.println("Something went wrong with " + link);
            } finally {
                this.interrupt();
            }
        }
    }

    public static int getCounter() {
        return counter;
    }

    public static int getCountFiles() {
        return countFiles;
    }

    public static float getTotalSize() {
        return totalSize;
    }

    public static float getTotalTime() {
        return totalTime;
    }

    public static void printTotal() {
        System.out.println("\nDownloaded: " + getCountFiles() + " files, " + getTotalSize() + " KB");
        System.out.println("Time: " + getTotalTime() + " seconds");
        System.out.println("Average speed: " + getTotalSize() / getTotalTime() + " kB/s");
    }
}

