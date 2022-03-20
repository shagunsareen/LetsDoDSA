package dsa.with.shagun.leetcode.Array;

public class DominoeRotations {
    public static void main(String[] args) {
        //System.out.println(minDominoRotations(new int[]{2,1,2,4,2,2}, new int[]{5,2,6,2,3,2}));
        System.out.println(minDominoRotations(new int[]{3,5,1,2,3}, new int[]{3,6,3,3,4}));
    }

    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int[] countTop = new int[7]; int[] countBottom = new int[7]; int[] same = new int[7];
        int n = tops.length;

        //count arrays
        for (int i=0; i<n; i++){
            countTop[tops[i]]++;
            countBottom[bottoms[i]]++;

            if(tops[i] == bottoms[i]){
                same[tops[i]]++;
            }
        }

        //return the lowest possible rotation
        for (int i = 1; i<=6; i++){
            if(countTop[i] + countBottom[i] - same[i] == n){
                return n - Math.max(countTop[i], countBottom[i]);
            }
        }

        return -1;
    }

}
