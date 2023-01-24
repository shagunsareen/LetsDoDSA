package dsa.with.shagun.scaler.advance.Hashing;

import java.util.HashSet;

public class ColorfulNum {
    public static void main(String[] args) {
        System.out.println(colorful(3245));
    }

    //TC : O(n2) ,SC:O(n)
    public static int colorful(int A) {
        HashSet<Integer> hs = new HashSet<>();
        String str = String.valueOf(A);
        for (int i = 0; i < str.length(); i++) {
            int prod = 1;
            for (int j = i; j < str.length(); j++) {
                prod *= (int) (str.charAt(j) - '0');
                if (hs.contains(prod)) {
                    return 0;
                }
                hs.add(prod);
            }
        }
        return 1;
    }
}
