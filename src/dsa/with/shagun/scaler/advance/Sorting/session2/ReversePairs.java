package dsa.with.shagun.scaler.advance.Sorting.session2;

public class ReversePairs {
        int count = 0;

        public int solve(int[] A) {
            mergeSort(A, 0, A.length-1);
            return count;
        }

        private int[] mergeSort(int[] A, int start, int end){

            //base case
            if(start == end){
                int[] singleArr = new int[1];
                singleArr[0] = A[start];
                return singleArr;
            }

            int mid = (start+end)/2;

            int[] B = mergeSort(A, start, mid);
            int[] C = mergeSort(A, mid+1, end);

            //now we have 2 sorted arrays, let's apply 2 pointer here to get our count of important reverse pairs
            getReversePairCount(B,C);

            return merge(B,C);
        }

        private int[] merge(int[] B, int[] C){
            int n1 = B.length;
            int n2 = C.length;

            int[] res = new int[n1+n2];

            int i=0;
            int j=0;
            int k=0;
            while(i < n1 && j < n2){

                if(B[i] < C[j]){
                    res[k] = B[i];  // first array element is smaller
                    i++;
                }else{
                    res[k] = C[j]; // second array element is smaller
                    j++;
                }
                k++;
            }

            while(i < n1){
                res[k] = B[i];
                i++;
                k++;
            }
            while(j < n2){
                res[k] = C[j];
                j++;
                k++;
            }

            return res;
        }


        private void getReversePairCount(int[] A, int[] B) {
            int n1 = A.length;
            int n2 = B.length;
            int left = 0;
            int right = 0;

            while (left < n1 && right < n2) {
                //compare both values ans increment count accordingly
                if ((long) A[left] > 2 * (long) B[right]) {
                    // if left ele is greater than right ele then obviously ele post left ele are greater than right arr ele
                    //hence increment the count for all elements on the right as well
                    count += n1 - left;
                    right++;
                } else {
                    //if left ele is smaller than right ele then it will be smaller than all ele on right of right ele
                    //hence don't compare it with any further ele on right arr
                    left++;
                }
            }
        }
}
