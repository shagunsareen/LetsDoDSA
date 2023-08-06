package dsa.with.shagun.scaler.array.ProblemSolving;

public class SquareRootOfNum {
    public static void main(String[] args) {
        System.out.println(solve(84630800));
    }
    public static int solve(int A) {
        //check max value of A and iterate loop till square root of max A because there is no point going beyond that
        for (int i = 0; i <= 10000; i++) {
            if (i * i == A) {
                  return i;
            }
        }
        return -1;
    }
}
