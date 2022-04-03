package dsa.with.shagun.questions.pepcoding.RecursionBackTracking;

import java.util.Scanner;

public class MaxOfArray {
    //TC: O(n). This is because we have iterated the array twice. Once while going into the recursion and the other time while coming out of it. So, n elements were visited twice: n+n= 2n, O(2n)=O(n).
    //SC: O(n) The space complexity will be O(1) as we have not used any extra space. If we consider the recursion space, it will be O(n) i.e. the maximum height of the recursion stack.
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(maxOfArray(arr, 0));
    }

    public static int maxOfArray(int[] arr, int idx) {
        if (idx == arr.length - 1) { // Since last element has nothing to compare with hence max element from that will be element itself.
            return arr[idx];
        }
        int misa = maxOfArray(arr, idx + 1); // find max element from idx+1 till end;
        if (misa > arr[idx]) {
            return misa;
        } else {
            return arr[idx];
        }
    }

}
