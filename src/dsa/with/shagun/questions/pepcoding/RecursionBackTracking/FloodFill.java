package dsa.with.shagun.questions.pepcoding.RecursionBackTracking;

import java.util.Scanner;

public class FloodFill {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        // If we don't mark cell visited then we will just roam between first and second cell and it will throw StackOverflowException.
        boolean[][] visited = new boolean[n][m];  // this is required to track which cells have been covered while traversing the path. When we read a cell mark it as visited but when we cover all paths from that cell then mark it unvisited so that we can consider the cell in next path traversal.
        floodfill(arr, 0, 0, "", visited);
    }

    // asf -> answer so far
    public static void floodfill(int[][] maze, int sr, int sc, String asf, boolean[][] visited) {

        //Base condition  -- check if row and col goes outside boundaries and if element value is 1 then don't traverse
        if (sr < 0 || sc < 0 || sr == maze.length || sc == maze[0].length || maze[sr][sc] == 1 || visited[sr][sc]) {  // check for value ==1  condition at last because if row is negative and we are checking for it's value then we can get arrayOutOfBoundException
            return;
        }

        if (sr == maze.length - 1 && sc == maze[0].length - 1) {  // when we reach end cell return the path traversed
            System.out.println(asf);
            return;
        }
        visited[sr][sc] = true;  // mark cell as visited

        floodfill(maze, sr - 1, sc, asf, visited);  //top
        floodfill(maze, sr, sc - 1, asf, visited); //left
        floodfill(maze, sr + 1, sc, asf, visited); //down
        floodfill(maze, sr, sc + 1, asf, visited); //right

        visited[sr][sc] = false;  // mark cell as unvisited for next path traversal
    }
}
