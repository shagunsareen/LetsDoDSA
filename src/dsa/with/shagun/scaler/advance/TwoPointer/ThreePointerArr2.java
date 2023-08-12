package dsa.with.shagun.scaler.advance.TwoPointer;

public class ThreePointerArr2 {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int minimize(final int[] A, final int[] B, final int[] C) {

            int ptr1 = 0;
            int ptr2 = 0;
            int ptr3 = 0;
            int minDiff = Integer.MAX_VALUE;

            while(ptr1 < A.length && ptr2 < B.length && ptr3 < C.length){
                // Since we need max difference between 3 numbers we can get that only when we have first ele as max element and second ele as min element
                int firstEle = Math.max(Math.max(A[ptr1], B[ptr2]), C[ptr3]);
                int secondEle = Math.min(Math.min(A[ptr1], B[ptr2]), C[ptr3]);

                // Now we need this difference to be max
                int diff = firstEle - secondEle;
                minDiff = Math.min(diff, minDiff);

                //since second element is the minimum we can directly check which ptr has that value and can increment that
                if(A[ptr1] == secondEle){
                    ptr1++;
                }else if(B[ptr2] == secondEle){
                    ptr2++;
                }else{
                    ptr3++;
                }
            }
            return minDiff;
        }
}
