package dsa.with.shagun.scaler.advance.array;

public class ContinousSumQueryABeggers {

    public static void main(String[] args) {
        solve(5, new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}});
    }

    public static int[] solve(int A, int[][] B) {

        int[] arr = new int[A];

        // Add val at lth index and deduct same val at r+1th index. This is done to remove extra sum added beyond rth index in prefix sum
        for (int i = 0; i < B.length; i++) { //TC : O(B)
            int l = B[i][0] - 1;
            int r = B[i][1] - 1;
            int val = B[i][2];

            arr[l] += val;

            if (r + 1 < arr.length) {
                arr[r + 1] -= val;
            }
        }

        //generate prefix sum of this arr
        for (int k = 1; k < arr.length; k++) { //TC : O(N)
            arr[k] += arr[k-1];
        }
        return arr;
        //TC : O(B+N), SC:O(N)
    }
}
