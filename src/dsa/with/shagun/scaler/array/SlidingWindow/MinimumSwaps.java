package dsa.with.shagun.scaler.array.SlidingWindow;

/*
Problem Description

Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.

Note: It is possible to swap any two elements, not necessarily consecutive.



Problem Constraints

1 <= length of the array <= 100000
-109 <= A[i], B <= 109



Input Format

The first argument given is the integer array A.
The second argument given is the integer B.



Output Format

Return the minimum number of swaps.



Example Input

Input 1:

 A = [1, 12, 10, 3, 14, 10, 5]
 B = 8
Input 2:

 A = [5, 17, 100, 11]
 B = 20


Example Output

Output 1:

 2
Output 2:

 1


Example Explanation

Explanation 1:

 A = [1, 12, 10, 3, 14, 10, 5]
 After swapping  12 and 3, A => [1, 3, 10, 12, 14, 10, 5].
 After swapping  the first occurence of 10 and 5, A => [1, 3, 5, 12, 14, 10, 10].
 Now, all elements less than or equal to 8 are together.
Explanation 2:

 A = [5, 17, 100, 11]
 After swapping 100 and 11, A => [5, 17, 11, 100].
 Now, all elements less than or equal to 20 are together.
 */
public class MinimumSwaps {

    //BRUTE FORCE APPROACH
    /*public int solve(int[] A, int B) {
        int count=0;

        //check if element is greater than B then swap it with element smaller than B
        for(int i=0; i<A.length; i++){
            //System.out.println("Count : "+count+ " i : "+i);

            if(A[i] > B){
                //System.out.println("Count : "+count+ " Greater ele : "+A[i] + " i : "+i);

                //get element to be swapped
                for(int j=A.length-1; j > i ; j--){
                    if(A[j] < B){
                        //System.out.println("greater ele : "+A[i]+" smaller ele  : "+A[j]);
                        A = swap(A, i, j);
                        count++;
                        //System.out.println("Swapped ,Count : "+count);
                        break;
                    }
                }
            }
        }

        return count;
    }

    private int[] swap(int[] A, int geIndex, int seIndex){
        int temp = A[geIndex];
        A[geIndex] = A[seIndex];
        A[seIndex] = temp;
        return A;
    }*/

    public int solve(int[] A, int B) {
        //Since we need min. no. of swaps we need to know how many smaller elements than B are present and how many minimum swaps are required to get all these elements together
        //Once we have window size we can check no. of swaps required in that window and store it in a global variable  & maintain min. value

        //Step1 : Find window size i.e. number of elements smaller than B
        int windowSize = 0;
        for(int i=0; i<A.length; i++){
            if(A[i] <= B){
                windowSize++;
            }
        }

        //Step2 : min. no. of swaps
        int l=0;
        int r=0;
        int ans = Integer.MAX_VALUE;
        int eleToSwap = 0;

        if(windowSize <= 1){ // if no element or 1 element exists then no swap is required
            return 0;
        }else{

            //Step2.1 : Get min. swaps required in first window. Here window size = no. of elements smaller than B
            while(r < windowSize){
                if(A[r] > B){
                    eleToSwap++;
                }
                r++;
            }
            ans = eleToSwap;

            //Now check for all other windows and update the ans with min. no. of swaps
            while(r < A.length){
                if(A[l] > B){
                    eleToSwap--;
                }
                if(A[r] > B){
                    eleToSwap++;
                }
                ans = Math.min(ans, eleToSwap);
                r++;
                l++;
            }
            return ans;
        }
    }
}
