package dsa.with.shagun.scaler.array.SlidingWindow;

public class SubArrLeastAvg {  //TC : O(N), SC : O(1),
    // NOTE : Since no. of elements remain same in each subarray, if sum is least that means avg is least. Hence, calculate SUM not AVG


    public static void main(String[] args) {
        //System.out.println(solve(new int[]{3, 7, 90, 20, 10, 50, 40},3));
        //System.out.println(solve(new int[]{20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11},9));
        System.out.println(solve(new int[]{15, 7, 11, 7, 9, 8, 18, 1, 16, 18, 6, 1, 1, 4, 18},6));
    }

    public static int solve(int[] A, int B) {
        int avg = 0;
        int sum = 0;
        int index = -1;
        // find average of first subarray  -- since no. of elements remain same in every subarray , least average means least sum
        for (int i = 0; i <= B - 1; i++) {
            sum += A[i];
        }
        index = 0;

        //now calculate least sum as per sum of first subarray
        // Find subarray with length B , then find least average among them
        int start = 1;
        int end = B;

        int minSum = sum;
        while (start <= A.length - B) {
            sum = sum - A[start - 1] + A[end];  // since sum would be least meaning avg would be least , hence not dividing by no. of elements
            if(minSum>sum){
                minSum = sum;
                index = start;
            }
            start++;
            end++;
        }
        return index;
    }
}
