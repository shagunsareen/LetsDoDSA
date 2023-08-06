package dsa.with.shagun.scaler.advance.BinarySearch.session2;

public class MagicalNumber {
    public static void main(String[] args) {
        System.out.println(solve(1, 2, 3));
    }

    // A number is called magical if it is divisible by B or C or both
    public static int solve(int A, int B, int C) {
        //Concept used is binary search since we will check for mid index how many multiples we have and we will discard them on the basis of if it's <or > than A

        long l = Math.min(B, C);  // smallest possible number which can be divisible by both

        //Ath element can not go beyong Ath multiple of Minimum of B,C.
        long r = (long) Math.min(B, C) * A;  //max range till where we should check elements that either they are divisible by B or C or both

        //Once the search space is defined.
        if (A == 1)
            return (int) l;

        //LCM of B and C = B*C/GDC(B,C) = B*C/HCF(B,C)
        long lcm = ((long) B * C) / gcd(B, C);

        long ans = 0;
        long mod = 1000000007;

        while (l <= r) {

            long mid = l + (r - l) / 2; // we need to check whether Ath smallest number lies within mid or it is the mid itself

            //num of multiples of B or C within range [1 mid]
            long numOfMultiples = mid / B + mid / C - mid / lcm;

            if (numOfMultiples < A) {
                // go to right to get more multiples
                l = mid + 1;
            } else { //numOfMultiples >= A
                // go to left to get Ath smallest multiple
                ans = mid;
                r = mid - 1;
            }
        }
        if (ans < 0) {
            ans += mod;
        }
        return (int) (ans % mod);  //TC:O(log(A*Math.min(B,C)), SC:O(1)
    }

    private static int gcd(int x, int y) {
        if (x == 0) {
            return y;
        }

        return gcd(y % x, x);
    }
}
