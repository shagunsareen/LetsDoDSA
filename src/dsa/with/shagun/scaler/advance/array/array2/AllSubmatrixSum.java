package dsa.with.shagun.scaler.advance.array.array2;

public class AllSubmatrixSum {

    public int solve(int[][] A) {

        //Approach 1 : cover all possible combinations of TL and BR , and traverse them to take sum
        // TC : O(n4) for all combinations and for traversing O(n2) so this is the worst option

        //Approach 2 : Take prefix sum for all O(n4) combinations but that also is quite large Time complexity

        //Approach 3 : Contribution Technique TC : O(n2) , SC : O(1)
        // Here, we  consider the contribution of each element in all possible submatrices
        // Suppose an element is (i,j) we can have [0 i] and [0 j] Top Left coordinate options to include this element i.e. i-0+1 = i+1 elements & j+1 elements
        // Similarly for Bottom Right coordinates we can have [j to A[0].length-1] and [i A.length-1] i.e. (m-j)*(n-i) combinations
        //At the end,we multiply this with element itself to get the contribution of that element

        //traverse each element
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                sum += (i + 1) * (j + 1) * (A[0].length - j) * (A.length - i) * A[i][j];
            }
        }
        return sum;
    }
}
