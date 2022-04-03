package dsa.with.shagun.questions.pepcoding.RecursionBackTracking;

import java.util.Scanner;

public class DisplayArray {
    //TC :  O(n). Since we are making at most n recursion calls and in each call we are performing O(1) operations (printing a data is constant time) so our overall time complexity is n*O(1) = O(n).
    //SC : O(n). Also, we know for each recursion call the parameters, address of the array are stored in the runtime stack, and since the recursive call stack is of n length it will also take n space in the stack. Although we are not using any array the space complexity will be O(n).
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        displayArr(arr, 0);
    }

    //Expectation : index to end print every element
    //Faith : index+1 to end print every element
    public static void displayArr(int[] arr, int idx) {
        if (idx > arr.length - 1) {
            return;
        }
        System.out.println(arr[idx]);
        displayArr(arr, idx + 1);
    }
}
