package dsa.with.shagun.scaler.advance.Graph;

public class NumberOfIslands {

    int[] x = {1,-1,0,0,-1,-1,1,1};
    int[] y = {0,0,1,-1,-1,1,-1,1};

    public int solve(int[][] A) {
        int n = A.length; //rows
        int m = A[0].length; //columns
        int count = 0;

        for(int i=0; i<n ;i++){
            for(int j=0; j<m; j++){
                if(A[i][j]==1){ // non-visited but is land
                    count++;
                    dfs(i,j, A, n, m);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, int[][] A, int n, int m){
        A[i][j] = 2; //mark it as visited

        //check for all 8 directions and see till where can we get the land and run dfs on that
        for(int k=0; k<8;k++){
            int row = i + x[k];
            int col = j + y[k];

            if(isValid(row, col, n, m) && A[row][col]==1){
                dfs(row, col, A, n ,m);
            }
        }
    }

    private boolean isValid(int row, int col, int n, int m){
        if(row <0|| row>=n || col<0 || col>=m){
            return false;
        }
        return true;
    }
}
