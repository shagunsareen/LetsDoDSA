package dsa.with.shagun.scaler.Strings;

public class ToggleCase {
    public static void main(String[] args) {
        System.out.println(solve("Hello"));
    }

    //TC : O(N), SC:O(N)
    public static String solve(String A) {
        char[] c = A.toCharArray();
        for (int i = 0; i < c.length; i++) {
            c[i] = (char) (c[i]^32);
        }
        return new StringBuilder().append(c).toString();
    }
}
