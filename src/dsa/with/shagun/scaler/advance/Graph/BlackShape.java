package dsa.with.shagun.scaler.advance.Graph;

public class BlackShape {
        int[] x = {0, 0, 1, -1};
        int[] y = {1, -1, 0, 0};
        int count = 0;
        boolean[][] visited;

        public int black(String[] A) {
            // This is connected components problem
            // We can traverse the entire graph using DFS
            int n = A.length;
            int m = A[0].length();
            visited = new boolean[n][m];

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    //check if this not is not visited and if it is equal to X then count it as one component
                    if(A[i].charAt(j) == 'X' && !visited[i][j]){
                        count++;
                        dfs(A, i, j, visited);
                    }
                }
            }
            return count;
        }


        private void dfs(String[] A, int i, int j, boolean[][] visited){
            //mark it as visited
            visited[i][j] = true;

            //go in all the four directions if it is X and not visited
            for(int k=0; k<4; k++){
                int x1 = i + x[k];
                int y1 = j + y[k];

                if(isValidPoint(x1, y1, A) && !visited[x1][y1] && A[x1].charAt(y1)=='X'){
                    dfs(A, x1, y1, visited);
                }
            }
        }


        private boolean isValidPoint(int x, int y, String[] A){
            if(x<0 || y<0 || x >= A.length || y >= A[0].length()){
                return false;
            }
            return true;
        }
}
