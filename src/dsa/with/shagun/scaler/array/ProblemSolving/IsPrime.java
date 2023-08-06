package dsa.with.shagun.scaler.array.ProblemSolving;

public class IsPrime {
    public static void main(String[] args) {
        System.out.println(solve(24));
        System.out.println(solve(100));
        System.out.println(solve(23));
    }

    public static int solve(long A) {
        //approach 1  -- check if number is divisible by more than 2 factors or more. If 2 its a prime number else no
        //TC:O(N) if N is 10^8 it will take lot of time to compute ans
        /*int count = 0;
        for (int i = 1; i <= A; i++) {
            if (A % i == 0) {
                count++;
            }
        }
        if (count == 2) {
            return 1;
        } else {
            return 0;
        }*/

        //approach 2 : Since factors occurs in pairs and pairs start repeating after certain point. That certain point is after square root of number
        //Hence,iterate only till square root of range of A.
        //TC : O(square root of N)
        int count = 0;
        for (long i = 1; i * i <= A; i++) {
            if (A % i == 0) {
                if (i * i == A) {
                    count++;
                } else {
                    count += 2; //since we are iterating till square root hence consider 2 factors
                }
            }
        }
        if (count == 2) {
            return 1;
        } else {
            return 0;
        }

    }
}
