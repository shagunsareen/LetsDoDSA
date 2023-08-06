package dsa.with.shagun.scaler.advance.TwoPointer;

public class SubarraySum {
    public static void main(String[] args) {
        solve(new int[]{1, 2, 3, 4, 5}, 5);
        solve(new int[]{5, 10, 20, 100, 105}, 110);
    }

    public static int[] solve(int[] A, int B) {
        int ptr1 = 0;
        int ptr2 = 0;
        long sum = A[ptr2];

        while (ptr1 < A.length && ptr2 < A.length) {

            if (sum == B) {
                return getArray(ptr1, ptr2, A);
            } else if (sum > B) {  // since sum is exceeding we can exclude leftmost element as we can't have it as starting index
                sum = sum - A[ptr1];
                ptr1++;
            } else {
                // if sum <B
                ptr2++;
                if (ptr2 < A.length) {
                    sum += A[ptr2];
                }else{
                    break;
                }
            }
        }
        return new int[]{-1};
    }

    private static int[] getArray(int ptr1, int ptr2, int[] a) {
        int[] res = new int[ptr2 - ptr1 + 1];
        int index = 0;
        for (int i = ptr1; i <= ptr2; i++) {
            res[index] = a[i];
            System.out.println(res[index]);
            index++;
        }
        return res;
    }
}
