package dsa.with.shagun.scaler.advance.Sorting.session2;

import java.util.Arrays;

public class BClosestPointsToOrigin {
    public int[][] solve(int[][] A, int B) {
        //Integer[][] arr = Arrays.stream(A).boxed().toArray(Integer[][]::new);

        //Arrays.sort(arr, new myComparator());

        // This will sort the values as per the distance
        Arrays.sort(A, (a, b)-> Integer.compare(a[0]*a[0]+a[1]*a[1], b[0]*b[0]+b[1]*b[1]));

        return Arrays.copyOfRange(A,0,B);
    }
}
