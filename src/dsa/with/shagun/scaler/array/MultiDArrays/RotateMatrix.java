package dsa.with.shagun.scaler.array.MultiDArrays;

public class RotateMatrix {
    public static void main(String[] args) {
        solve(new int[][]{{1, 2},
                        {3, 4}});
    }

    public static void solve(int[][] A) {
        int n = A.length;

        // take transpose
        for(int i=0; i<n; i++){//TC : O(N2)
            for(int j=0; j<i; j++){
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }

        //Reverse elements
        for(int r=0; r<n ;r++){  //TC : O(N)
            //take each row and reverse elements
            int start=0; int last=n-1;
            while(start<last){  //TC : O(N)
                int temp = A[r][start];
                A[r][start] = A[r][last];
                A[r][last] = temp;
                start++;
                last--;
            }
        }
    }
}
