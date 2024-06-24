package dsa.with.shagun.scaler.advance.Graph.Session2;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCell {
    public int[][] solve(int[][] A) {

        //multi source BFS, put all 1's to the queue first so that we can traverse the distance from them of 0's
        int n = A.length;
        int m = A[0].length;

        int[][] res = new int[n][m];

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(A[i][j] == 1){
                    res[i][j] = 0;
                    queue.add(new int[]{i,j});
                }else{
                    res[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        while(!queue.isEmpty()) {

            int[] point = queue.poll();

            //go to all the four directions
            for(int k = 0; k<4; k++){
                int x1 = point[0] + dx[k];
                int y1 = point[1] + dy[k];

                if(x1 >= 0  && x1 < n && y1 >= 0 && y1 < m){ //if the point is valid te=hen calculate the distance
                    //check if this is 0
                    if(res[x1][y1] > res[point[0]][point[1]] + 1){
                        res[x1][y1] = res[point[0]][point[1]] + 1; //we maintain the minimum distance
                        queue.add(new int[]{x1, y1});
                    }
                }
            }
        }
        return res;
    }
}
