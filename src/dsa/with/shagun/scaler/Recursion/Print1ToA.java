package dsa.with.shagun.scaler.Recursion;

public class Print1ToA {
    public static void main(String[] args) {
        solve(9);
    }

    public static void solve(int A) {
        print(A);
        System.out.println("");
    }

    private static void print(int A){
        if (A == 1) {
            System.out.print(A+ " ");
            return;
        }
        print(A - 1);
        System.out.print(A + " ");
    }
}
