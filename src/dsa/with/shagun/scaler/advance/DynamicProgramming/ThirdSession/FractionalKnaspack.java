package dsa.with.shagun.scaler.advance.DynamicProgramming.ThirdSession;

import java.util.Arrays;

public class FractionalKnaspack {
    public int solve(int[] A, int[] B, int C) {
        //Greedy with happiness/weight works here
        //so we need an array which stores value/weight for each object and we will check if object can be considered till we don't reach the capacity
        int n = A.length;
        double[][] perUnitArr = new double[n][3];  //because we have to store fractional value for value/weight

        for(int i=0; i<n; i++){
            perUnitArr[i][0] = (double)A[i]; //storing value
            perUnitArr[i][1] = (double)B[i]; //storing weight
            perUnitArr[i][2] = (double)A[i]/B[i];
            //System.out.println("A : "+ perUnitArr[i][0]+", B : "+ perUnitArr[i][1]+", Ratio : "+ perUnitArr[i][2]);
        }

        Arrays.sort(perUnitArr, (a, b) -> Double.compare(b[2], a[2]));

        double ans = 0;
        double weightLeft = (double)C;
        //System.out.println(weightLeft);

        for(int i=0; i<n; i++){

            if(weightLeft >= perUnitArr[i][1]){
                ans += perUnitArr[i][0]*100;  //add value
                weightLeft -= perUnitArr[i][1]; //deduct curr object's weight from weightLeft
            }else{
                //now since we can't consider the whole weight we have to take fractional weights
                //System.out.println("Ans : "+ans+ ", weightLeft: "+weightLeft+", perUnitArr[i][2]  : "+perUnitArr[i][2]);
                ans += weightLeft*perUnitArr[i][2]*100;

                //System.out.println("Ans : "+(int)ans+ ", weightLeft : "+weightLeft + " Math.floor(ans) : "+Math.floor(ans));
                //return (int)(Math.round(ans));
                return (int)(Math.floor(ans));
            }
            //System.out.println("Ans : "+(int)ans);
        }
        return (int)(Math.floor(ans));
    }
}
