package dsa.with.shagun.scaler.array.CarryForward;

public class SpecialSubsequence {
    public static void main(String[] args) {
        System.out.println(solve("ABCGAG"));
        System.out.println(solve("GAB"));
    }

    public static int solve(String A) {

        /* Approach 1 : Brute force
           Iterate for every element and check the no. of G's present in a string.
           TC : O(N*N), SC:O(1)

                int count = 0;
                char[] arr = A.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    if(arr[i] == 'A'){  // if current ele is A then only run second loop to check count of 'G' elements
                        for (int j = i + 1; j < arr.length; j++) {
                                if(arr[j] == 'G'){
                                    count++;
                                }
                        }
                    }
                }
                return count;
      */

        /* Approach 2 : Optimised Carry Forward approach.
            Instead of counting same number of G's again and again which are already counted in first iteration
            , let's store count of 'G' and number of pairs till particular index and carry forward the values to next index
            TC: O(N), SC: O(1)
         */

        int countOfA = 0;
        int countOfSubseq = 0;
        char[] arr = A.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 'A'){
                countOfA++;
            }
            if(arr[i] == 'G'){
                countOfSubseq = countOfSubseq + countOfA;
            }
        }
        return countOfSubseq;
    }
}
