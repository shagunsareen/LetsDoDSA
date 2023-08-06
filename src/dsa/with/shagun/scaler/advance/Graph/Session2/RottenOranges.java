package dsa.with.shagun.scaler.advance.Graph.Session2;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    int[] x = {1, -1, 0, 0};
    int[] y = {0, 0, 1, -1};

    public int solve(int[][] A) {

        int n = A.length; //rows
        int m = A[0].length; //columns
        int maxLevel = Integer.MIN_VALUE;

        Queue<Pair> q = new LinkedList<>();

        //put the first rotten element in the queue
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                //we have to run BFS on every node this we don't know from where we can get ans
                if(A[i][j]==2){
                    //if oranges are rotten push them to queue
                    q.add(new Pair(i,j,0));
                }
            }
        }

        while(!q.isEmpty()){
            int r = q.peek().rowIndex;
            int c = q.peek().colIndex;
            int level = q.peek().level;
            q.poll();

            maxLevel = Math.max(maxLevel, level);

            for(int k=0; k<4; k++){
                int ri = r + x[k];
                int ci = c + y[k];

                if(isValid(ri, ci, n, m ) && A[ri][ci] == 1){ // if the neighbour node is not rotten and is fresh
                    A[ri][ci] = 2; // these will become rotten , hence push them to queue
                    q.add(new Pair(ri,ci,level+1));
                }
            }
        }

        //once all the nodes are traversed check if there is any fresh orange still left
        for(int i=0; i<n; i++){
            for(int  j=0; j<m; j++){
                if(A[i][j]==1){
                    return -1;
                }
            }
        }

        //else return maxLevel
        return maxLevel;
    }

    private boolean isValid(int r, int c, int n, int m){
        if(r<0 || r>=n || c<0 || c>=m){
            return false;
        }
        return true;
    }

    class Pair{
        int rowIndex;
        int colIndex;
        int level;

        Pair(int row, int col, int level){
            this.rowIndex = row;
            this.colIndex = col;
            this.level = level;
        }
    }
}
