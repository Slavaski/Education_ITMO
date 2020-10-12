package Task_1_IO;

import java.io.*;

public class A1_ReadFileAndWriteArrayOfString {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\slava\\Documents\\GitHub\\Education_ITMO\\MobileApplicationDevelopment\\Laba_3\\src\\Task_1_IO\\testfile1.txt";
        String textFromFile = read(fileName);
        System.out.println(textFromFile);
    }

    public static String read(String fileName) {
        File myFile = new File(fileName);
        StringBuilder sb = new StringBuilder();
        try {
            try (BufferedReader in = new BufferedReader(new FileReader(myFile.getAbsoluteFile()))) {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
