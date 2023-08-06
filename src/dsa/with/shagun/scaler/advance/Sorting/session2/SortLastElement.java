package dsa.with.shagun.scaler.advance.Sorting.session2;

public class SortLastElement {

    public static void main(String[] args) {
        int[] res = sortEntireArray(new int[]{2, 6, 10, 14, 20, 4});
        for(int i: res){
            System.out.println(i);
        }
    }

    //first N-1 elements are sorted, sort entire array
    public static int[] sortEntireArray(int[] A) {  // TC : O(n) ,SC : O(1)

        // idea 1 : question is not to sort entire array , if we sort entire array TC : nlogn

        //idea2 : we need to sort just the last element at correct position and when we have to insert one ele at right position we can go with Insertion sort
        int indx = A.length - 1;
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[indx] < A[i]) {
                //move greater ele to right side
                swap(indx, i, A);
                indx = i;
            } else {
                break;
            }
        }
        return A;
    }

    private static void swap(int start, int end, int[] arr) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
