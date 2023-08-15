package dsa.with.shagun.scaler.advance.Sorting.session3;

public class SortFirstEleInArray {

    public static void main(String[] args) {
        int[] A = rearrange(new int[]{10, 3, 8, 15, 6, 12, 2, 18, 7, 15, 14});
        for (int i : A) {
            System.out.println(i);
        }
    }

    //sort first element at correct position
    // ele < ar[0] should be on left
    //ele > ar[0] should be on right
    //TC : O(n), SC : O(1)
    public static int[] rearrange(int[] A) {
        int p1 = 1;
        int p2 = A.length - 1;
        int eleToSort = A[0];

        while (p1 <= p2) {
            if (A[p1] < eleToSort) {  // i.e. smaller elements are on left of array we should keep them as is
                p1++;
            } else if (A[p2] > eleToSort) { // here A[p1] > eleToSort hence move this ele to right end of array
                p2--;
            } else { // if p2 ele on right < eleToSort then swap it with p1 ele on left > eleToSort
                swap(p1, p2, A);
                p1++;
                p2--;
            }
        }
        swap(0, p1 - 1, A);  //this is to bring 0th element at the correct position
        return A;
    }

    private static void swap(int start, int end, int[] arr) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
