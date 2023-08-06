package dsa.with.shagun.scaler.Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class FactorsSort {
    public static void main(String[] args) {
        solve(new int[]{6,8,9});
    }

    public static int[] solve(int[] A) {
        Integer[] arr = IntStream.of(A).boxed().toArray(Integer[]::new);

        //we need to sort elements on basis of factors it holds. This can be done with comparator
        Arrays.sort(arr, new factorsComparator());

        return Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
    }

    public static int countFactors(int A) {
        int count = 0;
        for (int i = 1; i * i <= A; i++) {
            if (A % i == 0) {
                if (A / i == i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }

    static class factorsComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer val1, Integer val2) {
            Integer count1 = countFactors(val1);
            Integer count2 = countFactors(val2);

            if (count2 < count1) {
                return 1;
            } else if (count1.equals(count2)) {
                if (val2 < val1) return 1;
                else return -1;
            } else {
                return -1;
            }
        }
    }
}
