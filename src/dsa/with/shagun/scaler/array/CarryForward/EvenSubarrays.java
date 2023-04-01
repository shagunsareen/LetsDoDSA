package dsa.with.shagun.scaler.array.CarryForward;

public class EvenSubarrays {
    public static void main(String[] args) {
        solve(new int[]{2, 4, 6, 8});
    }

    public static String solve(int[] A) {

        //Observation 1 : if array size is odd then there will always be 1 array of odd length
        // Array size has to be EVEN

        //Observation 2 : if first element or last element of the array is odd then there will always be 1 subarray with non-even elements as start or end
        int n = A.length;
        if (n % 2 == 0 && A[0] % 2 == 0 && A[n - 1] % 2 == 0) {
            return "YES";
        }
        return "NO";
    }
}
