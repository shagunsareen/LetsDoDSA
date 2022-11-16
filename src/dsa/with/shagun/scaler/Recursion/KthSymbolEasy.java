package dsa.with.shagun.scaler.Recursion;

public class KthSymbolEasy {
    public static void main(String[] args) {
       // System.out.println(solve(3, 0));
       System.out.println(solve(4, 4));
    }

    public static int solve(int A, int B) {
        if (B == 0) return 0; // since 0th col will always have 0 value

        int p = solve(A - 1, B / 2);  // since we need previous rows elements and parent's col is k/2

        // once we have traversed till col 0 then we will print elements of each row
        if (B % 2 == 0) {
            return p;  // if parent value is 0/1 then even index will have same value
        } else {
            return 1 - p; // if parent value is 0/1 then odd index will have opposite value
        }
    }
}
