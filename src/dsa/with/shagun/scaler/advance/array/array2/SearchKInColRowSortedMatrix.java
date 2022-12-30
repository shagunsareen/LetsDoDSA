package dsa.with.shagun.scaler.advance.array.array2;

public class SearchKInColRowSortedMatrix {
    public static void main(String[] args) {
        //System.out.println(solve(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 2));
        System.out.println(solve(new int[][]{
                {1, 3, 5, 8, 9, 11, 12, 13, 16, 19, 21, 22, 25, 27, 28, 31, 33, 35, 36, 39, 41, 42, 44, 46, 49, 50, 53, 56, 59, 60, 63, 65, 66, 67, 70, 73, 74, 75, 77, 79, 81, 83, 85, 88, 91},
                {4, 7, 10, 12, 15, 17, 20, 22, 25, 27, 30, 33, 34, 37, 40, 42, 44, 47, 48, 51, 54, 57, 59, 61, 63, 65, 66, 69, 71, 74, 76, 78, 79, 81, 82, 84, 86, 88, 89, 90, 92, 94, 95, 97, 99}}, 1));

    }

    //Approach 1 : To traverse entire matrix and find K. TC : O(N*M), SC :O(1)
    //Approach 2: To compare K with 0th element of each row and see if element can be present in the row.
    // In worst case we might have to check every row TC : O(N*M), SC: O(1)

    //Approach 3 : Start from top right corner and check if ele can be in that row or not. Else move to next row.
    //TC : O(N+M), SC:O(1) Since in worst case we need to start from Top Right corner and traverse till bottom left corner
    public static int solve(int[][] A, int B) {

        int N = A.length;
        int i = 0;
        int j = A[0].length - 1;
        int resIndex = Integer.MAX_VALUE; // in case B is not present in whole matrix

        while (i < N && j >= 0) {
            if (A[i][j] < B) {
                // skip the row as element can't be present in this row
                i++;
            } else if (A[i][j] > B) {
                // we can check in this row and can skip column
                j--;
            } else if (A[i][j] == B) {
                resIndex = Math.min(resIndex, ((i + 1) * 1009 + (j + 1)));
                j--;
            }
        }
        if (resIndex == Integer.MAX_VALUE) {
            return -1;
        }
        return resIndex;
    }
}
