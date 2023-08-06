package dsa.with.shagun.scaler.array.SubArrays;

import java.util.ArrayList;

public class GenerateAllSubArrays {

    public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A) {

        //CAN"T SOLVE THIS QUESTION WITH ARRAYS
        /*int length = (A.length*(A.length+1))/2;

        int[][] res = new int[length][];
        int superArrayIndex =0;

        //to get all subarrays we need to fix start & end of subarray first
        for(int s=0; s<A.length; s++){ // fixing start
            for(int e=0; e<A.length; e++){ // fixing end
                for(int i=s; i<=e; i++){ // iterating over subarrays one by one
                    res[superArrayIndex][e-s+1] = A[i];
                }
            }
        }*/

        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();  // TC : O(n^3), SC:O(N^2)
        int n = A.size();
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j <n ; j++){
                ArrayList<Integer> v = new ArrayList<Integer>();
                for(int k = i ; k <= j ; k++){
                    v.add(A.get(k));
                }
                ans.add(v);
            }
        }
        return ans;
    }
}
