package dsa.with.shagun.scaler.advance.Sorting.session2;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public String largestNumber(final int[] A) {
            int n = A.length;
            if(n==0){
                return "0";
            }
            Integer[] arr = Arrays.stream(A).boxed().toArray(Integer[]::new);

            //we need to sort elements on basis of factors it holds. This can be done with comparator
            Arrays.sort(arr, new myComparator());

            //return Arrays.toString(arr).replace(",", "").replace("[", "").replace("]", "").replace(" ", "");
            StringBuilder res = new StringBuilder("");
            int sum = 0;
            for (int i : arr) {
                sum += i;
                res.append(i);
            }
            if (sum == 0) {
                return "0";
            }
            return res.toString();
        }

        static class myComparator implements Comparator<Integer> {

            @Override
            public int compare(Integer val1, Integer val2) {
                String a = "" + val1 + val2;
                String b = "" + val2 + val1;

                Long one = Long.parseLong(a);
                Long two = Long.parseLong(b);


                if ((two > one) || two.equals(one)) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
}
