package Task_1_IO;

import java.io.*;

public class A4_CopyByte {
    public static void main(String[] args) throws IOException {
        File fileName1 = new File("C:\\Users\\Acer\\Documents\\GitHub\\Education_ITMO\\MobileApplicationDevelopment\\Laba_3\\src\\Task_1_IO\\testfile1.txt");
        File fileName3 = new File("C:\\Users\\Acer\\Documents\\GitHub\\Education_ITMO\\MobileApplicationDevelopment\\Laba_3\\src\\Task_1_IO\\testfile3.txt");
        getByteCopyTime(fileName1, fileName3);
    }

    private static void getByteCopyTime(File f1, File f2) throws IOException {
        FileInputStream is = new FileInputStream(f1);
        FileOutputStream os = new FileOutputStream(f2, false);
        int b;
        while ((b = is.read()) != -1) os.write(b);
        is.close();
        os.close();
    }
}