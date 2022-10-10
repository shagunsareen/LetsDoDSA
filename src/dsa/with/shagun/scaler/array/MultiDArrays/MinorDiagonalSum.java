package dsa.with.shagun.scaler.array.MultiDArrays;

public class MinorDiagonalSum {
    public static void main(String[] args) {
        System.out.println(solve(new int[][]{
                {47, -59, 20, 33, 20, -47, -87, -59, 85},
                {8, -67, 48, -10, -23, -68, -28, 62, -94},
                {-50, 77, -39, -57, 15, 71, 44, 13, -53},
                {-30, 43, -92, -94, 42, 37, 95, 7, 19},
                {-1, 92, -85, 20, -53, -16, 31, -95, 4},
                {-62, 49, 0, 53, -93, -61, -49, 86, 97},
                {62, -26, -1, -38, 59, -93, -93, 12, -90},
                {78, 85, 90, 89, -65, 5, 48, 40, -86},
                {-79, -68, -89, 90, -40, 47, 68, -25, 92}
        }));
    }

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int solve(final int[][] A) {
        int r = 0;
        int c = A.length-1;
        int sum = 0;

        while(r<A.length && c>=0){
            sum += A[r][c];
            r++;
            c--;
        }

        return sum;  //TC : O(N), SC :O(1)


        /*int sum =0;
        int c=A.length;

        for(int r=1; r<=A.length; r++){
            sum += A[r-1][c-1];
            c--;
        }
        return sum;*/
    }
}
