package dsa.with.shagun.scaler.advance.array;

public class QuerySum {

    //TC : O(Q+N), Q for q queries and N for prefix sum , SC:O(1) since we didn't use any extra space
    public static void main(String[] args) {
        getQuerySum(new int[]{0, 0, 0, 0, 0, 0, 0}, 3, new int[][]{{1, 3, 2}, {2, 5, 3}, {2, 4, -1}});
    }

    public static int[] getQuerySum(int[] arr, int Q, int[][] mat) {

        for (int a = 0; a < Q; a++) {// iterate over each query
            int i = mat[a][0];
            int j = mat[a][1];
            int k = mat[a][2];

            arr[i] += k;// add k value to ith place
            if (j + 1 < arr.length) {
                arr[j + 1] -= k; //deduct k value from j+1th place since k has to be added till jth place only. Deduct k from j+1 till last element
            }
        }

        return generatePrefixSum(arr);
    }

    public static int[] generatePrefixSum(int[] arr) {
        int prefixSum = 0;
        for (int l = 0; l < arr.length; l++) {
            prefixSum = prefixSum + arr[l];
            arr[l] = prefixSum;
        }
        return arr;
    }
}
