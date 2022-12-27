package dsa.with.shagun.scaler.Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class LargestNumber {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{2, 3, 9, 0}));
    }

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static String largestNumber(final int[] A) {

        Integer[] arr = IntStream.of(A).boxed().toArray(Integer[]::new);

        //we need to sort elements on basis of factors it holds. This can be done with comparator
        Arrays.sort(arr, new myComparator());

        //return Arrays.toString(arr).replaceAll("[\\[\\],]", "");
        return Arrays.toString(arr).
                replace(",", "").
                replace("[", "").
                replace("]", "").
                replace(" ", "");
    }

    static class myComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer val1, Integer val2) {

            Integer one = Integer.valueOf("" + val1 + val2);
            Integer two = Integer.valueOf("" + val2 + val1);

            if ((two > one) || two.equals(one)) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
