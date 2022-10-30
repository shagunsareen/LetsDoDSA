package dsa.with.shagun.scaler.array.ModularArithmeticIntro;

public class DivisibleByEight {
    public static void main(String[] args) {
        System.out.println(solve("16"));
        /*System.out.println(solve("123"));
        System.out.println(solve("4"));*/
    }
    public static int solve(String A) {
        long ans = 0;
        int n = A.length();
        int fans = 1;
        int count = A.length() > 3 ? A.length()-3 : 0;
        for (int i = n-1 ; i >= count; i--) {
            ans = ans + (A.charAt(i) -'0')*fans;
            fans = (fans*10)%8;
        }
        if (ans % 8 == 0) {
            return 1;
        }
        return 0;
    }
}
