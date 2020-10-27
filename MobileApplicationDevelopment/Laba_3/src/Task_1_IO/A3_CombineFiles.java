package Task_1_IO;

public class A3_CombineFiles {
    public static void main(String[] args) {
        //необходимо почистить файл testfile3.txt
        String fileName1 = "C:\\Users\\Acer\\Documents\\GitHub\\Education_ITMO\\MobileApplicationDevelopment\\Laba_3\\src\\Task_1_IO\\testfile1.txt";
        String fileName2 = "C:\\Users\\Acer\\Documents\\GitHub\\Education_ITMO\\MobileApplicationDevelopment\\Laba_3\\src\\Task_1_IO\\testfile2.txt";
        String fileName3 = "C:\\Users\\Acer\\Documents\\GitHub\\Education_ITMO\\MobileApplicationDevelopment\\Laba_3\\src\\Task_1_IO\\testfile3.txt";
        String addedText1 = A1_ReadFileAndWriteArrayOfString.read(fileName1);
        String addedText2 = A1_ReadFileAndWriteArrayOfString.read(fileName2);
        String addedText = addedText1 + addedText2;

        A2_WriteInFileParameter.write(fileName3, addedText);
    }
}
