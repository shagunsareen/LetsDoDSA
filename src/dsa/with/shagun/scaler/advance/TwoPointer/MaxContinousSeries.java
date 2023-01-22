package dsa.with.shagun.scaler.advance.TwoPointer;

public class MaxContinousSeries {
    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 0, 1, 1, 0, 0, 1, 1, 1};
        maxone(a, 1);
    }

    /*
    * Given a binary array A, find the maximum sequence of continuous 1's that can be formed by replacing at-most B zeroes.
    * For this problem, return the indices of maximum continuous series of 1s in order.
    * If there are multiple possible solutions, return the sequence which has the minimum start index.
    *
    *
    * Problem Constraints
        0 <= B <= 105
        1 <= size(A) <= 105
        0 <= A[i] <= 1

    * Input Format
    First argument is an binary array A.
    Second argument is an integer B.

    * Output Format
    Return an array of integers denoting the indices(0-based) of 1's in the maximum continuous series.

    * Example Input
    Input 1:

    A = [1 1 0 1 1 0 0 1 1 1 ]
    B = 1
    * */
    public static int[] maxone(int[] A, int B) {
        int i = 0; // left pointer to keep start index of window
        int j = 0; // right pointer to keep index of zero which will be replaced
        int zero = 0;
        int max = 0;
        int low = 0;
        int high = 0;
        int previousMax = 0;

        while (j < A.length) {
            if (A[j] == 1) {
                j++; //move forward if element is 1
            } else {
                //if element is 0
                zero++; // we are keeping count of zeros
            }

            //once zero>B i.e no. of zeros to be replaced with 1 if it is greater,
            // then move left pointer till zero==B so that we can calulate no. of 1s in that window if 0s are replaced
            if (zero > B) {
                while (zero > B) {
                    if (A[i] == 0) {
                        zero--;
                    }
                    i++;
                }
            }

            max = Math.max(max, j - i + 1);  // no. of consecutive 1s

            //to store indexes of elements where we have consecutive 1s
            if (max > previousMax) {
                low = i;  //start index of ans
                high = j; //end index of ans
                previousMax = max; // to keep track of prev max value
            }
        }

        int[] res = new int[max - 1]; // as arrays indexing starts from 0
        for (int k = low; k < high; k++) {
            res[k - low] = k;
        }
        return res;
    }
}
