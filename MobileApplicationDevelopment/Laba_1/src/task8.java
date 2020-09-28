import java.util.*;
import java.util.stream.Collectors;

public class task8 {
    public static void main(String[] args) {
        int min = -5, max = 5, lengthOfArr = 10, i, j, count;
        Random rand = new Random();
        int[] myArr = new int[lengthOfArr];
        int[] quantityArr = new int[lengthOfArr];
        for (i = 0; i < myArr.length; i++) {
            myArr[i] = rand.nextInt(max - min);
            quantityArr[i] = -1;
        }
        Arrays.sort(myArr);
        System.out.println(Arrays.toString(myArr));
        Scanner in = new Scanner(System.in);
        System.out.print("Enter K: ");
        int K = in.nextInt();

        for (i = 0; i < lengthOfArr; i++) {
            count = 1;
            for (j = i + 1; j < lengthOfArr; j++)
                if (myArr[i] == myArr[j]) {
                    count++;
                    quantityArr[j] = 0;
                }
            if (quantityArr[i] != 0)
                quantityArr[i] = count;
        }
        System.out.println("Quantity sorted " + Arrays.toString(quantityArr));
        final Map<Integer, Integer> myMap = new HashMap<>();
        for (i = 0; i < lengthOfArr; i++) {
            if (quantityArr[i] != 0) {
                myMap.put(myArr[i], quantityArr[i]);
            }
        }
        final Map<Integer, Integer> sortedByCount = sortByValue(myMap);
        i = 0;
        for (Map.Entry<Integer, Integer> entry : sortedByCount.entrySet()) {
            if (i < K) {
                System.out.println(entry.getKey());
                i++;
            }
        }
    }

    public static Map<Integer, Integer> sortByValue(final Map<Integer, Integer> wordCounts) {
        return wordCounts.entrySet()
                .stream()
                .sorted((Map.Entry.<Integer, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
