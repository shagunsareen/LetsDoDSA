package dsa.with.shagun.scaler.advance.TwoPointer;

public class PairWithGivenSum2 {
    public static void main(String[] args) {
        //System.out.println(solve(new int[]{1, 1, 1}, 2));
        //System.out.println(solve(new int[]{1, 1}, 2));
        System.out.println(solve(new int[]{1, 2, 6, 6, 7, 9, 9}, 13));
    }

    public static int solve(int[] A, int B) {

        //approach 1 : Go through each and every pair TC :O(n2)
        //approach 2 : Fix one element and insert in hashmap and check whether sum-B  is present or not TC : O(N), SC:O(N)
        /*long count = 0;
        int mod = 1000000007;
        HashMap<Integer, Integer> hm = new HashMap();
        for (int i = 0; i < A.length; i++) {
            //create frequency array
            if (hm.containsKey(B - A[i])) {
                count += hm.get(B - A[i]);
                count %= mod; // since for large values it was failing because count value might go out of range
            }
            hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
        }
        return (int) count % mod;*/

        //approach 3 : Fix element and search other element using binary search TC :O(NlogN), SC :O(1)

        //approach 4 : Use two pointers as time and space both complexities are reduced to TC:O(N),SC:O(1)
        int ptr1 = 0;
        int ptr2 = A.length - 1;
        long count = 0;
        int mod = 1000000007;

        while (ptr1 < ptr2) {
            if (A[ptr1] + A[ptr2] == B) {
                // we got a match

                //check whether we have duplicates
                if (A[ptr1] != A[ptr2]) { // when two pointers are not same, check leftPtr duplicates and rightPtr duplicates
                    long leftCnt = 1;
                    long rightCnt = 1;
                    while (ptr1 < A.length && A[ptr1] == A[ptr1 + 1]) { // i.e. left side we have duplicates
                        leftCnt++;
                        ptr1++;
                    }
                    ptr1++;
                    while (ptr2 > 0 && A[ptr2] == A[ptr2 - 1]) { // i.e. left side we have duplicates
                        rightCnt++;
                        ptr2--;
                    }
                    ptr2--;
                    count += (leftCnt * rightCnt)%mod;
                    count %= mod;
                } else {  // if both pointers have same values meaning all elements are same since array is sorted
                    //no. of pairs with n elements is n*(n-1)/2
                    long elements = ptr2 - ptr1 + 1;
                    count += (elements * (elements - 1) / 2) % mod;
                    count %= mod;
                    break;
                }
            } else if (A[ptr1] + A[ptr2] < B) {
                //we need to increase sum we move right side
                ptr1++;
            } else {
                ptr2--;
            }
        }
        return (int) count % mod;
    }
}
