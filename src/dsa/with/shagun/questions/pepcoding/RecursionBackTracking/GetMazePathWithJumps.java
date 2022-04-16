package dsa.with.shagun.questions.pepcoding.RecursionBackTracking;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePathWithJumps { //TC : O(3^(n+m)) How ? ,SC : O(1)
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

        ArrayList<String> hPaths;
        ArrayList<String> vPaths;
        ArrayList<String> dPaths;
        ArrayList<String> res = new ArrayList<>();
        int ms = 0;

        //since we can move n steps now we need to get paths considering 1,2,3 ..n steps where max step can be maxRow-minRow or maxCol-minCol
        //horizontal paths
        for (ms = 1; ms <= dc - sc; ms++) {
            hPaths = getMazePaths(sr, sc + ms, dr, dc);
            for (String hpath : hPaths) {
                res.add("h" + ms + hpath);
            }
        }

        //vertical paths
        for (ms = 1; ms <= dr - sr; ms++) {
            vPaths = getMazePaths(sr + ms, sc, dr, dc);
            for (String vpath : vPaths) {
                res.add("v" + ms + vpath);
            }
        }

        //diagonal paths
        for (ms = 1; ms <= dr - sr && ms <= dc - sc; ms++) {
            dPaths = getMazePaths(sr + ms, sc + ms, dr, dc);
            for (String dpath : dPaths) {
                res.add("d" + ms + dpath);
            }
        }

        return res;
    }
}

