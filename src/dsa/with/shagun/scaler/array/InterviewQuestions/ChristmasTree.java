package dsa.with.shagun.scaler.array.InterviewQuestions;

public class ChristmasTree {
    public int solve(int[] A, int[] B) {

        //Brute Force : for loop for every selecting all 3 trees and then taking sum for them
        // TC :O(n3), SC :O(1)

        //Better approach : For every element check for smaller elements on left & calculate min cost,
        // check for greater elements on right & calculate min cost, then add current ele cost to min cost
        // TC :O(n2), SC:O(1)

        //Step1 : Iterate for every element in the first array

        int minCost = Integer.MAX_VALUE;

        for (int i = 1; i < A.length; i++) {

            int minLeftCost = Integer.MAX_VALUE;
            int minRightCost = Integer.MAX_VALUE;

            //check for min. cost on the left
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) { //smaller ele exists
                    minLeftCost = Math.min(minLeftCost, B[j]);
                }

                //System.out.println("A[i] : "+A[i] +" , B[j] : "+B[j] +" , minLeft : "+minLeftCost);
            }

            //check for min. cost on the right
            for (int k = i + 1; k < A.length; k++) {
                if (A[i] < A[k]) { //greater ele exists
                    minRightCost = Math.min(minRightCost, B[k]);
                }
                //System.out.println("A[i] : "+A[i] +" , B[k] : "+B[k] +" , minRightCost : "+minRightCost);
            }

            //calculate overall mincost
            if (minLeftCost != Integer.MAX_VALUE && minRightCost != Integer.MAX_VALUE) {
                minCost = Math.min(minCost, minLeftCost + B[i] + minRightCost);
            }
            // System.out.println("MinCost: "+minCost);
        }

        if (minCost != Integer.MAX_VALUE) {
            return minCost;
        }

        return -1;
    }
}
