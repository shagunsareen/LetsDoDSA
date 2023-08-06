package dsa.with.shagun.scaler.advance.Sorting.session3;

public class SortFirstEleOfSubarray {
    public static void main(String[] args) {
        int[] A = rearrange(new int[]{10, 3, 8, 6, 14, 7, 4, 12, 7, 1}, 2, 7);
        for (int i : A) {
            System.out.println(i);
        }
    }

    // TC : O(n) ,SC :O(1)
    public static int[] rearrange(int[] A, int s, int e) {
        int p1 = s + 1;
        int p2 = e;
        int eleToSort = A[s]; // this is the element to sort

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
        swap(s, p1 - 1, A);
        return A;
    }

    private static void swap(int start, int end, int[] arr) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
