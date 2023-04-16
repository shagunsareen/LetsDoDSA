package dsa.with.shagun.scaler.array.InterviewQuestions;

public class MultipleLeftRotationsOfArray {
    public int[][] solve(int[] A, int[] B) {

        int n = A.length;
        int m = B.length;

        int[][] res = new int[m][n];

        for(int i=0; i<B.length; i++){
            B[i] = B[i]%n;

            int[] temp = new int[n]; // Passing copy of A in order to not loose the initial array.

            for(int j=0;j<n;j++)
                temp[j]=A[j];

            res[i] = rotate(temp, B[i], n);
        }

        return res;
    }

    private int[] rotate(int[] arr, int k, int n){
        arr = reverse(arr, 0, n-1);
        arr = reverse(arr, 0, n-k-1);
        arr = reverse(arr, n-k, n-1);
        return arr;
    }

    private int[] reverse(int[] arr, int start, int end){

        int i=start;
        int j= end;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] =  temp;
            i++;
            j--;
        }

        return arr;
    }
}
