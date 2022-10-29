package dsa.with.shagun.scaler.array.ModularArithmeticIntro;

public class PowerModulo {
    public static int solve(int A, int B, int C) {
        long ans = 1;
        for (int i = 1; i <= B; i++) {
            ans = (ans % C * A % C) %C;
        }
        return (int) (ans%C);
    }
}
