package dsa.with.shagun.questions.pepcoding.Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SubsetsOfArray {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int limit = (int) Math.pow(2, n);
        for (int i = 0; i < limit; i++) {
            String subset = "";
            int temp = i;

            for (int j = arr.length - 1; j >= 0; j--) {
                int rem = temp % 2;
                temp = temp / 2;

                if (rem == 0) {
                    subset = "-\t" + subset;
                } else {
                    subset = arr[j] + "\t" + subset;
                }
            }
            System.out.println(subset);
        }
    }
}
