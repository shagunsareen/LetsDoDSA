package dsa.with.shagun.scaler.array.ProblemSolving;

public class SquareRootOfNum {
    public int solve(int A) {
        for (int i = 0; i <= A; i++) {
            if (i * i == A) {
                  return i;
            }
        }
        return -1;
    }
}
