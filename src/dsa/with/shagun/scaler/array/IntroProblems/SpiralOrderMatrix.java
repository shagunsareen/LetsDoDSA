package dsa.with.shagun.scaler.array.IntroProblems;

public class SpiralOrderMatrix {//TC : O(N*N), SC: O(1)
    public static void main(String[] args) {
        generateMatrix(5);
    }
    public static int[][] generateMatrix(int A) {

        int left = 0;
        int top = 0;
        int right = A - 1;
        int bottom = A - 1;

        int[][] ans = new int[A][A];
        int a = 1;

        while (left <= right) {
            //traversing top row
            for (int i = left; i <= right; i++) {
                ans[top][i] = a;
                a++;
            }
            top++;

            //traversing right column
            for (int i = top; i <= bottom; i++) {
                ans[i][right] = a;
                a++;
            }
            right--;

            //traversing bottom row
            for (int i = right; i >= left; i--) {
                ans[bottom][i] = a;
                a++;
            }
            bottom--;

            //traversing left column
            for (int i = bottom; i >= top; i--) {
                ans[i][left] = a;
                a++;
            }
            left++;
        }
        return ans;
    }
}
