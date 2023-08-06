package dsa.with.shagun.scaler.array.BitManipulations;

public class AnyBaseToDecimal {
    public static void main(String[] args) {
        System.out.println(solve(22,3));
    }

    public static int solve(int A, int B) {
        int ans = 0;
        int power = 0;
        while (A > 0) {
            int digit = A % 10;
            ans = (int) (ans + digit*(Math.pow(B, power)));
            A = A/10;
            power++;
        }
        return ans;
    }
}
