package dsa.with.shagun.scaler.Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class TensDigitSorting {

    public static void main(String[] args) {
        solve(new int[]{15,11,7,19});
    }

    public static int[] solve(int[] A) {
        Integer[] arr = Arrays.stream(A).boxed().toArray(Integer[]::new);

        Arrays.sort(arr, new tenDigitComparator());

        return Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
    }


    static class tenDigitComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer val1, Integer val2) {
            Integer firstTensPlace = val1 / 10;
            Integer secondTensPlace = val2 / 10;

            if (secondTensPlace < firstTensPlace) {// as secondTensPlace is inserted first , hence if it is less it is correct for increasing order
                return 1;
            } else if (secondTensPlace.equals(firstTensPlace)) {
                if (val2 > val1) return 1;
                else return -1;
            } else {
                return -1;
            }
        }
    }
}
