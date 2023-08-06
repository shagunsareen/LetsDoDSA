package dsa.with.shagun.scaler.array.ModularArithmeticIntro;

public class DivisibleByThree {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{8, 2, 5, 6, 7, 6, 2, 6, 2}));
    }

    public static int solve(int[] A) {
        long ans = 0;
        for (int i = 0; i <= A.length - 1; i++) {
            ans = ans + A[i];
        }
        if(ans%3 == 0){
            return 1;
        }
        return 0;
    }
}
