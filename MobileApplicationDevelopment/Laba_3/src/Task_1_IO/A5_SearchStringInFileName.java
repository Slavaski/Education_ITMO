package Task_1_IO;

import java.io.File;

public class A5_SearchStringInFileName {
    public static void main(String[] args) {
        String filesPath = "C:\\Users\\Acer\\Documents\\GitHub\\Education_ITMO\\MobileApplicationDevelopment\\Laba_3\\src\\Task_1_IO\\";
        String findingSymbols = "3";
        find(filesPath, findingSymbols);
    }

    private static void find(String path, String find) {
        File f = new File(path);
        String[] list = f.list();
        assert list != null;
        for (String file : list) {
            if (file.contains(find)) {
                System.out.println(file);
            }
        }
    }
}
