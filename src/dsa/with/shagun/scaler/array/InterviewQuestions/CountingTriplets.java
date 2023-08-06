package dsa.with.shagun.scaler.array.InterviewQuestions;

/*
Q3. Count Increasing Triplets
Unsolved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA and get it resolved.
Get help from TA.
Problem Description
You are given an array A of N elements. Find the number of triplets i,j and k such that i<j<k and A[i]<A[j]<A[k]


Problem Constraints
1 <= N <= 103
1 <= A[i] <= 109


Input Format
First argument A is an array of integers.


Output Format
Return an integer.


Example Input
Input 1:
A = [1, 2, 4, 3]
Input 2:
A = [2, 1, 2, 3]


Example Output
Output 1:
2
Output 2:
1


Example Explanation
For Input 1:
The triplets that satisfy the conditions are [1, 2, 3] and [1, 2, 4].
For Input 2:

The triplet that satisfy the conditions is [1, 2, 3].
 */
public class CountingTriplets {
    public int solve(int[] A) {

        //Approach 1: Brute force : For i, j , k have for loop and iterate over every element TC :O(n3)

        //Approach 2 : Count smaller elements on left of element and larger elements on right of an element, this way we can reduce time complexity to O(n2)
        int n = A.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int small = 0;
            int large = 0;

            //check for smaller elements on the left
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    small++;
                }
            }

            //check for larger elements on the right
            for (int k = i + 1; k < n; k++) {
                if(A[k] > A[i]){
                    large++;
                }
            }

            ans += (small*large) ;
        }

        return ans;
    }
}
