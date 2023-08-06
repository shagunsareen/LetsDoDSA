package dsa.with.shagun.scaler.advance.Hashing.session2;

import java.util.HashSet;

public class CountRectangles {
    public static void main(String[] args) {
        int[] A = new int[]{1, 1, 2, 2};
        int[] B = new int[]{1, 2, 1, 2};
        System.out.println(solve(A, B));
    }

    //TC : O(n2) ,SC:O(n)
    public static int solve(int[] A, int[] B) {

        //approach 1 : if we take all 4 or 3 points variable this will be of O(n4) or O(n3)
        //approach 2 : let's fix diagonal points and then check if we have other 2 points or not

        HashSet<String> points = new HashSet<>();
        int count = 0;

        //put all points in set
        for (int i = 0; i < A.length; i++) {
            String pointVal = A[i] + "," + B[i];
            points.add(pointVal);
        }

        //fix (x1,y1) & (x2,y2) first such that x1!=x2 and y1!=y2 then only they will be diagonals. If x1=x2 and y1=y2 then those points are not diagonals
        for (int i = 0; i < A.length; i++) {

            //First point :(x1,y1) co-ordinate is A[i] & B[i]
            int x1 = A[i];
            int y1 = B[i];

            //Let's check what can be second co-ordinate i.e. (x2,y2) is A[j], B[j]
            for (int j = i + 1; j < B.length; j++) {
                int x2 = A[j];
                int y2 = B[j];

                // now check if x1!=x2 and y1!=y2 then find other two points else skip it
                if (x1 != x2 && y1 != y2) {//the two points chosen are diagonal points

                    //let's check for other two points - to check for other points we need to store it in hashmap/hashset
                    String ptr3 = x1 + "," + y2;
                    String ptr4 = x2 + "," + y1;
                    if (points.contains(ptr3) && points.contains(ptr4)) {
                        count++;
                    }
                }
            }
        }

        /**
         * Dividing by 2 because one rectangle we will be getting for (x1,y1) and (x2, y2)
         * and while looking for other combination we will encountering the opposite pair i.e. (x2, y2) & (x1,y1)
         * hence Dividing the count by 2.
         */
        return count/2;
    }
}
