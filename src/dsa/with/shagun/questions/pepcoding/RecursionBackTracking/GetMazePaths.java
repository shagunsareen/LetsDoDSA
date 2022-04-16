package dsa.with.shagun.questions.pepcoding.RecursionBackTracking;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePaths { //TC : O(2^n) because for each state 2 recursion calls are made //SC : O(1)
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        System.out.println(getMazePaths(1, 1, n, m));
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        //Base condition
        if (sr == dr && sc == dc) {
            ArrayList<String> blank = new ArrayList<>();
            blank.add("");
            return blank;
        }

        ArrayList<String> hPaths = new ArrayList<>();
        ArrayList<String> vPaths = new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();

        if (sc < dc) { // conditional check to avoid out of bound index
            hPaths = getMazePaths(sr, sc + 1, dr, dc);
        }
        if (sr < dr) {
            vPaths = getMazePaths(sr + 1, sc, dr, dc);
        }

        for (String hpath : hPaths) {
            res.add("h" + hpath);
        }
        for (String vpath : vPaths) {
            res.add("v" + vpath);
        }
        return res;
    }
}
