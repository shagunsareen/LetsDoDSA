package dsa.with.shagun.scaler.Sorting;

import java.util.Arrays;
import java.util.Collections;

public class ElementRemoval {
    public static void main(String[] args) {
        System.out.println(solveOptimised(new int[]{8, 0, 10}));
    }

    public static int solve(int[] A) {
        int sum = 0;
        int contributorIndex = 1;

        Integer[] arr = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());
        //since collections.reverseOrder() applies only on object type arrays hence the given arr has to be converted to Integer[]

        for (int i = 0; i <= arr.length - 1; i++) {
            sum += arr[i] * contributorIndex;
            contributorIndex++;
        }
        return sum;
    }

    /*public int solve(ArrayList<Integer> A) {

        Collections.sort(A);
        int sum = 0, ans = 0;

        for(int i=0;i<A.size();i++)
        {
            sum += (A.size()-i)*A.get(i);
        }

        return sum;
    }*/

    public static int solveOptimised(int[] A) {

        Arrays.sort(A);  //this will take less time as compared to Arrays.sort(Object[]) because https://www.baeldung.com/arrays-sortobject-vs-sortint#:~:text=sort(Object%5B%5D)%20accepts%20reference%20types.&text=%2C%2010%2C%2022%5D-,Arrays.,(n%20log(n)).
        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            sum += (A.length - i) * A[i];
        }

        return sum;
    }
}
