package dsa.with.shagun.scaler.advance.Sorting.session3;

public class MaxUnsortedArray {
    public int[] subUnsort(int[] A) {
        //Step 1 : Get start from where array is UnSorted
        int start = -1;
        int end = -1;
        int n = A.length;
        int i = 0;
        int j = n-1;

        //Step 2 : Get end from where the array is UnSorted
        while(i < n-1){
            if(A[i] > A[i+1]){ //greater ele on left is not sorted
                start = i;
                break;
            }
            i++;
        }

        if(i == n-1){
            return new int[]{-1};
        }

        while(j > 0){
            if(A[j] < A[j-1]){ //smaller ele on right is not sorted
                end = j;
                break;
            }
            j--;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        //Step 3 : Get max & min from start to end
        for(int k=start; k<=end; k++){
            max = Math.max(max, A[k]);
            min = Math.min(min, A[k]);
        }

        //Step 4 : Check if min > all elements on left if no then update start Index
        for(int k=0; k<start; k++){
            if(A[k] > min){ //greater can't be on the left
                start = k;
            }
        }

        //Step 5 : Check if max < all elements on right if no then update end Index
        for(int k=n-1; k>end; k--){
            if(A[k] < max){ //smaller can't be on the right
                end = k;
            }
        }

        return new int[]{start, end};
    }
}
