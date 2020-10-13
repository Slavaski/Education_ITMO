package Task_1_IO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class A7_SearchAnyCriterion {
    public static void main(String[] args) {
        List<File> list = getFiles("C:\\Users\\slava\\Documents\\GitHub\\Education_ITMO\\MobileApplicationDevelopment\\Laba_3\\src\\Task_1_IO", new Function<File, File>() {
            @Override
            public File apply(File file) {
                if(file.getName().endsWith(".txt"))
                    return file;
                return null;
            }
        });
        System.out.println(list);
    }

    public static List<File> getFiles(String path, Function<File, File> filter) {
        File dir = new File(path);
        if(!dir.isDirectory())
            return null;
        List<File> list = new ArrayList<>();
        for(File f: dir.listFiles()){
            File result = filter.apply(f);
            if(result != null)
                list.add(result);
        }
        return list;
    }
}
