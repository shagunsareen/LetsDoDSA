package dsa.with.shagun.scaler.advance.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestNodeInMaze {
    public class Solution {

        class Pair{
            int row;
            int col;
            int level;

            Pair(int r, int c, int l){
                this.row = r;
                this.col = c;
                this.level = l;
            }
        }

        private boolean isValid(int r, int c, int n, int m){
            if(r<0 || r>=n || c<0 || c>=m){
                return false;
            }
            return true;
        }

        int x[] = {1,-1,0,0};
        int y[] = {0,0,1,-1};

        public int solve(int[][] A, int[] B, int[] C) {

            int n = A.length;
            int m = A[0].length;

            //For shortest distance we apply BFS
            int row = B[0];
            int col = B[1];

            Queue<Pair> queue = new LinkedList<>();
            boolean[][] visited = new boolean[n][m];

            visited[row][col] = true;
            queue.add(new Pair(row, col, 0)); // this is the starting point

            while(!queue.isEmpty()){
                Pair pair = queue.poll();
                int r = pair.row;
                int c = pair.col;
                int l = pair.level;

                //check if this is the destination
                if(C[0] == r && C[1] == c){
                    return l;
                }

                //from here i can go to all 4 directions as stated in the question
                for(int i=0; i<4; i++){
                    int newRow = r;
                    int newCol = c;
                    int newStep = l;

                    //roll till we are getting valid 0s and till we are not hitting the wall
                    while(isValid(newRow,newCol,n,m) && A[newRow][newCol] == 0){
                        newRow += x[i];
                        newCol += y[i];
                        newStep++;
                    }

                    //since after the last move we have hit the wall hence distance should be counted only till (previousMove-1)
                    newRow -= x[i];
                    newCol -= y[i];
                    newStep--;

                    if(!visited[newRow][newCol]){
                        queue.add(new Pair(newRow, newCol, newStep));
                        visited[newRow][newCol] = true;
                    }
                }
            }

            return -1;
        }
    }
}
