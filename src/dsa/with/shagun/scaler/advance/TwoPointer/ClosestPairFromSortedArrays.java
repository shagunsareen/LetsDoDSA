package dsa.with.shagun.scaler.advance.TwoPointer;

/*Given two sorted arrays of distinct integers, A and B, and an integer C, find and return the pair
    whose sum is closest to C and the pair has one element from each array.
    More formally, find A[i] and B[j] such that abs((A[i] + B[j]) - C) has minimum value.
    If there are multiple solutions find the one with minimum i and even if there are multiple values of j
    for the same i then return the one with minimum j.
    Return an array with two elements {A[i], B[j]}.

    Problem Constraints
    1 <= length of both the arrays <= 100000
    1 <= A[i], B[i] <= 109
    1 <= C <= 109

    Input Format
    The first argument given is the integer array A.
    The second argument given is the integer array B.
    The third argument given is integer C.

    Output Format
    Return an array of size 2 denoting the pair which has sum closest to C.

    Input 1:
    A = [1, 2, 3, 4, 5]
    B = [2, 4, 6, 8]
    C = 9

    Input 2:
     A = [5, 10, 20]
     B = [1, 2, 30]
     C = 13

    Example Output
    Output 1:
    [1, 8]
    Output 2:
    [10, 2]

   */
public class ClosestPairFromSortedArrays {
    public static void main(String[] args) {
        //solve(new int[]{1, 2, 3, 4, 5}, new int[]{2, 4, 6, 8}, 9);
        solve(new int[]{5, 10, 20}, new int[]{1, 2, 30}, 13);
    }

    public static int[] solve(int[] A, int[] B, int C) {
        int i = 0;
        int j = B.length - 1;
        int low = Integer.MAX_VALUE;
        int high = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;

        while (j >= 0 && i < A.length) {
            int sum = Math.abs(A[i] + B[j]);
            int diff = Math.abs(sum - C);


            if (diff <= minDiff) {
                if (diff == minDiff) {
                    //i.e. when we have multiple solutions
                    if (low == i) {
                        high = j; // update j as it would be less than previous one because j starts from end to beginning i.e. later we will get smaller values
                    }
                } else { // i.e. diff is lesser than last min diff then update the values and the indices
                    minDiff = diff;
                    low = i;
                    high = j;
                }
            }

            if (sum == C) {
                i++;
                j--;
            } else if (sum < C) {
                // we need to increase sum to reach near to C i.e. we need to increase either i or j but j we are starting from end we can't increase hence increase i
                i++;
            } else {
                // we need to decrease sum to reach near to C i.e. decrement j
                j--;
            }
        }
        System.out.println("Low : " + A[low] + " - " + "High : " + B[high]);
        return new int[]{A[low], B[high]};
    }
}
