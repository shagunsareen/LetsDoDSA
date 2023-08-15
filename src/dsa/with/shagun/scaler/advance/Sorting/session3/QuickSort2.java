package dsa.with.shagun.scaler.advance.Sorting.session3;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSort2 {

    //TC : Best case : O(Nlogn), as O(N) + O(N/2) +O(N/2); Worst case : O(n^n) as TC(N) + TC(N-1), Average case  : O(Nlogn)

    public static void main(String[] args) {
        solution(new int[]{10, 3, 8, 6, 14, 7, 4, 12, 7, 1});
    }
    public static void solution(int[] A){

        quickSort(A, 0, A.length-1);
        for(int i : A){
            System.out.print(i+", ");
        }
    }

    private static void quickSort(int[] A, int start, int end){
        //if all elements are already sorted and all elements are on one side
        if(start >= end){
            return;
        }

        //First let 1 element get sorted then we will sort left subarray and right subarray
        //This will return the index of the sorted element
        int index = sortElement(A, start, end); // TC: O(N)
        quickSort(A, start, index-1); // this will sort 1 element and further divide array into 2 halves  //TC: O(N/2)
        quickSort(A, index + 1, end); //TC: O(N/2)
    }

    //this will sort 0th index element to it's correct position
    private static int sortElement(int[] A, int start, int end){

        //Now select a random integer and swap it with 0th element to save from worst case time complexity
//        int randomNum = ThreadLocalRandom.current().nextInt(start,end+1);
//        swap(A,0, randomNum);

        int p1 = start + 1;
        int p2 = end;

        while(p1<=p2){
            int ele = A[start];

            if(ele > A[p1]){ //if elements are smaller then move forward we need bigger element
                p1++;
            }else if(ele < A[p2]){ //if elements are greater move backward we need smaller element
                p2--;
            }else{
                //swap(A,p1,p2); //swap bigger ele where p1 is with the smaller ele where p2 is
                int temp = A[p1];
                A[p1] = A[p2];
                A[p2] = temp;

                p1++;
                p2--;
            }
        }

        // at the end swap start element to it's right position
        //swap(A, start, p1-1);
        int temp = A[p1-1];
        A[p1-1] = A[start];
        A[start] = temp;

        return p1-1;
    }

    /*private static int[] swap(int[] A, int start, int end){
        int temp = A[start];
        A[start] = A[end];
        A[end] = temp;
        return A;
    }*/

}
