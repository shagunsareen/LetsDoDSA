package dsa.with.shagun.scaler.array.ModularArithmeticIntro;

public class LeapYear {
    public static void main(String[] args) {
        System.out.println(solve(107852));
    }
    public static int solve(int A) {
        int lastTwoDigit = A%100;
        if((lastTwoDigit%4==0 && A%100 !=0) || A%400 == 0){
            return 1;
        }
        return 0;
    }
}
