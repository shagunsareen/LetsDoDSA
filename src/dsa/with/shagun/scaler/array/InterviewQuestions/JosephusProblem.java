package dsa.with.shagun.scaler.array.InterviewQuestions;

public class JosephusProblem {
    public static void main(String[] args) {
        System.out.println("Kill people : " +getNearestPowOf2(100));
        System.out.println("Element holding the sword " + solve(100));
    }

    public static int solve(int A) {
        int killCount = A - (int)(Math.pow(2,getNearestPowOf2(A)));   // no. of elements that we need to kill to reach nearest power of 2
        return 2*killCount+1;  // since to kill killCount we need to make twice number of skips , and next element would be the one holding sword
    }

    private static int getNearestPowOf2(int A){
        // since 2^x <= N i.e. we need to find nearest power of 2 to the input number , hence take log on both sides, i.e. x = logN base 2
        // In java we don't have logN base 2 function so we use logN/logBase
        return (int) (Math.log(A)/Math.log(2));
    }
}
