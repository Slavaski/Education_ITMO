package Task_1_IO;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class A2_WriteInFileParameter {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\slava\\Documents\\GitHub\\Education_ITMO\\MobileApplicationDevelopment\\Laba_3\\src\\Task_1_IO\\testfile1.txt";
        String text = "This new text1\nThis new text2\nThis new text3\nThis new text4\n";
        write(fileName, text);
    }

    public static void write(String fileName, String text) {
        File myFile = new File(fileName);
        try {
            if (!myFile.exists()) {
                myFile.createNewFile();
            }
            try (PrintWriter out = new PrintWriter(myFile.getAbsoluteFile())) {
                out.print(text);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
