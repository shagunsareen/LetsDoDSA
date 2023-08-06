package dsa.with.shagun.scaler.advance.TwoPointer;

import java.util.Arrays;

public class PairsWithGivenDifference {
    public static void main(String[] args) {
        //System.out.println(solve(new int[]{8, 12, 16, 4, 0, 20}, 4));
        //System.out.println(solve(new int[]{1, 5, 3, 4, 2}, 3));
        System.out.println(solve(new int[]{1, 1, 1, 2, 2}, 0));
        //System.out.println(solve(new int[]{1, 2}, 0));
    }

    public static int solve(int[] A, int B) {

        //approach 1 : For all combination of pairs ,i.e. n(n-1)/2 pairs check if difference is B
        //TC :O(n2), SC:O(1)

        //approach 2 : using hashmap or hashset, we can put elements in hashmap then check for other element which when subtracted =B
        //TC:O(n), SC:O(n)

        //approach 3 : Iterate over elements one by one , find other element by binary search TC :O(NlogN),SC :O(1)

        //approach 4 : Two pointers approach
        int p1 = 0;
        int p2 = 1; //since by taking these cordinates we have option to increase and decrease difference to make it = B
        int count = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        Arrays.sort(A); // we have to sort since we can then only increment or decrement pointers accordingly otherwise we might miss on few valid pairs

        while (p1 < A.length && p2 < A.length) {
            if (p1 != p2 && (A[p2] - A[p1] == B) && (A[p2] != ele2 && A[p1] != ele1)) {
                ele1 = A[p1];
                ele2 = A[p2];
                count++;
                p1++;
                p2++;
            } else if (A[p2] - A[p1] < B) {
                p2++; // since we can't decrement p1,we have only 1 option i.e. to increment p2
            } else {
                p1++; // if difference is greater than B and we have to reduce difference
            }
        }
        return count;  // TC : O(NlogN + N) = O(NlogN) ,SC:O(1)
    }
}
