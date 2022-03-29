package dsa.with.shagun.leetcode.TwoDArray;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix { // TC : O(n*m)  // SC : space taken by arraylist
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        spiralOrder(arr);
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int rs = 0;
        int cs = 0;
        int re = matrix.length - 1;
        int ce = matrix[0].length - 1;
        int te = (re+1) * (ce+1);
        int count = 0;
        while (count < te) {
            //top wall
            for (int i = cs; i <= ce && count < te; i++) {
                list.add(matrix[rs][i]);
                count++;
            }
            rs++;

            //right wall
            for (int i = rs; i <= re && count < te; i++) {
                list.add(matrix[i][ce]);
                count++;
            }
            ce--;

            //bottom wall
            for (int i = ce; i >= cs && count < te; i--) {
                list.add(matrix[re][i]);
                count++;
            }
            re--;

            //left wall
            for (int i = re; i >= rs && count < te; i--) {
                list.add(matrix[i][cs]);
                count++;
            }
            cs++;

        }
        return list;
    }
}
