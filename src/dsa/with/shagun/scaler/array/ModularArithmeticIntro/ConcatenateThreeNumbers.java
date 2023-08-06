package dsa.with.shagun.scaler.array.ModularArithmeticIntro;

import java.util.Arrays;

public class ConcatenateThreeNumbers {
    public static void main(String[] args) {
        System.out.println(solve(65,29,65));
    }

    public static int solve(int A, int B, int C) {
        int a[] = {A, B, C};
        Arrays.sort(a);
        return 10000*a[0] + 100*a[1] + a[2];
    }
}
