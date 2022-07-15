package dsa.with.shagun.questions.pepcoding.Sorting;

import java.util.Scanner;

public class MergeSortedArrays {
    public static int[] mergeTwoSortedArrays(int[] a, int[] b) {
        //Approach 1. Brute force  TC : O(n) , but it also uses extra space
        /*int i = 0;
        int j = 0;
        int k = 0;

        int[] res = new int[a.length + b.length];

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                res[k] = a[i];
                i++;
                k++;
            } else {
                res[k] = b[j];
                j++;
                k++;
            }
        }

        while(i< a.length){
            res[k] = a[i];
            i++;
            k++;
        }

        while(j < b.length){
            res[k] = b[j];
            j++;
            k++;
        }
         return res;
         */

        //Approach 2. TC : O(m+n), SC : O(1)
        // Without using extra space  ( Place greater elements at the end ) //This solution will work if we have one array already with size as combination of elements in botht the arrays
        int i = a.length - 1;
        int j = b.length - 1;
        int k = a.length + b.length - 1;

        while (i >= 0 && j >= 0) {
            if (a[i] > b[j]) {
                a[k] = a[i];
                k--;
                i--;
            }else{
                a[k] = b[j];
                k--;
                j--;
            }
        }

        while(i>=0){
            a[k] = a[i];
            k--;
            i--;
        }

        while(j>=0){
            a[k] = b[j];
            k--;
            j--;
        }
        return a;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scn.nextInt();
        }
        int[] mergedArray = mergeTwoSortedArrays(a, b);
        print(mergedArray);
    }

}
