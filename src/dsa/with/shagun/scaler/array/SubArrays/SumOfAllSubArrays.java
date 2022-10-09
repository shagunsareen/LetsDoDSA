package dsa.with.shagun.scaler.array.SubArrays;

public class SumOfAllSubArrays {

    //Approach 1 : fix start and end points , iterate over subarray and take sum
    // TC : O(N3), SC : O(1)

    //Approach 2 : construct prefix array, fix start and end points, get total sum from prefix arr
    // TC : O(N + N2 = N2), SC : O(N)

    //Approach 3 : fix start and end points, take sum variable to add each element and carry forward sum  value to next iteration
    //TC : O(N2), SC : O(1)

    //Approach 4 (Optimised) : "Contribution Technique"
    // Get contribution of each element in all subarrays and add them
    // NOTE : count of ith element in all subarrays : (i+1)*(N-i)
    // TC : O(N), SC : O(1)

    public long subarraySum(int[] A) {
        long count = 0;
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            //count of each element in all possible subarrays
            count = (long) (i + 1) * (A.length - i);
            sum = sum + (A[i] * count);
        }
        return sum;
    }
}
