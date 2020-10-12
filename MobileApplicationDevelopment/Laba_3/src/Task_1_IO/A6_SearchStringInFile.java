package Task_1_IO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class A6_SearchStringInFile {
    public static void main(String[] args) {
        String pathToFile = "C:\\Users\\slava\\Documents\\GitHub\\Education_ITMO\\MobileApplicationDevelopment\\Laba_3\\src\\Task_1_IO";
        String findingSymbols = "!";
        find(Path.of(pathToFile), findingSymbols);
    }

    private static void find(Path filesPath, String findingSymbols) {
        File f = new File(String.valueOf(filesPath));
        String[] list = f.list();
        if (list != null) {
            for (String file : list) {
                try {
                    readUsingScanner1Line(filesPath + "\\" + file, file, findingSymbols);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void readUsingScanner1Line(String fileName, String file, String findingSymbols) throws IOException {
        Scanner scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name());
        while (scanner.hasNext()) {
            String data = scanner.useDelimiter("\\n").next();
            if (data.contains(findingSymbols)) {
                System.out.println(file);
                scanner.close();
                break;
            }
        }
        scanner.close();
    }
}
