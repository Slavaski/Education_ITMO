package Task_1_IO;

import java.util.Objects;
import java.util.function.Function;

public class A7_SearchAnyCriterion {
    public static void main(String[] args) {
        Function<String, String> functionFind = Objects::toString;
        System.out.println(functionFind.apply("SDA"));

    }
}
