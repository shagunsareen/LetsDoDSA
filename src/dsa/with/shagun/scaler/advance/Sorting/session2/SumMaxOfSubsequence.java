package dsa.with.shagun.scaler.advance.Sorting.session2;

import java.util.Arrays;

public class SumMaxOfSubsequence {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{4, 7, 2, 5, 8, 10}));
    }

    //need to find sum of max of every subsequence of a given array
    public static int solve(int[] A) {

        //approach 1 : for every subsequence, find max and add it to sum, TC : O(2^N*N) not good
        //approach 2 : Find number of subsequences in which each element is max,  and add contribution of each ele in sum
        /**
         * An element can bemax in subsequence when it has all other elements as smaller , for this sort array
         * find number of elements smaller than current element and no. of sub = 2^no.ofelementssmallerthancurrent
         * Multiple currenteleme to no. of subsequences where it's max then sum it up
         */

        //Step1 : To get number of ele smaller than current ele sort array
        Arrays.sort(A); // TC : nlogn

        int sum = 0;
        for (int i = 0; i < A.length; i++) { // TC : O(n)
            int subseq = (int) Math.pow(2, i); // no. of elements smaller than element is the index of the element itself,subseq = 2^i
            sum += A[i] * subseq;
        }

        return sum;  //TC : O(nlogn +n),SC :O(1)
    }

}
