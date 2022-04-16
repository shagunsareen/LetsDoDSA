package dsa.with.shagun.questions.pepcoding.RecursionBackTracking;

import java.util.ArrayList;
import java.util.Scanner;

public class GetStairPaths { //TC : O(3^n) as for each state 3 recursive calls are made,  SC : O(1)
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(getStairPaths(n));
    }

    public static ArrayList<String> getStairPaths(int n) {
        //Base condition
        if (n == 0) {  // it is still a path since if we combine 1 to 0 we can reach 1
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        } else if (n < 0) { // it is not a path since if we combine -ve ele to  or 2 or 3 still it remains -ve .Hence, invalid paths
            return new ArrayList<>();
        }

        //Since we have 3 options to take steps we will get all paths from those 3 options
        ArrayList<String> onePathList = getStairPaths(n - 1);
        ArrayList<String> twoPathList = getStairPaths(n - 2);
        ArrayList<String> threePathList = getStairPaths(n - 3);

        ArrayList<String> res = new ArrayList<>();
        //Add 1 to onePathList paths to get all combinations if first step is 1
        for (String str : onePathList) {
            res.add(1 + str);
        }
        //Add 2 to twoPathList paths  to get all combinations if first step is 2
        for (String str : twoPathList) {
            res.add(2 + str);
        }

        //Add 3 to threePathList paths  to get all combinations if first step is 3
        for (String str : threePathList) {
            res.add(3 + str);
        }
        return res;
    }
}
