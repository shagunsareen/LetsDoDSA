package dsa.with.shagun.scaler.array.ProblemSolving;

public class CountFactors { //TC : O(root(A)), SC : O(1)

    public static void main(String[] args) {
        System.out.println(solve(49));
    }

    public static int solve(int A) {
        int count = 0;
        for (int i = 1; i * i <= A; i++) {
            if (A % i == 0) {
                if(A/i == i){
                    count++;
                }else{
                    count +=2;
                }
            }
        }
        return count;
    }
}
