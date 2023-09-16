package dsa.with.shagun.scaler.advance.Stack.session2.revision;

import java.util.Arrays;
import java.util.Stack;

public class MaximumRectangle {
    public int solve(int[][] A) {

        //This is the extension of area of histogram approach , here we will take each row as an input to the histogram question

        //First let's just take column sum since we need to check the area in the entire matrix and not just one row

        //Generate column sum prefix array
        int M = A[0].length; //columns
        int N = A.length; //rows

        for(int j=0; j < M; j++){ //columns
            for(int i=1; i < N; i++){ //rows

                //if the current element is zero then ignore else add the previous element to It
                if(A[i][j] != 0){
                    A[i][j] = A[i][j] + A[i-1][j];
                }else {
                    A[i][j] = 0;
                }
            }
        }

        //Now that we have a prefix column sum array
        //Once we have this updated array, we need to pass this to histogram logic to get the results
        int ans = 0;
        int res = 0;
        for(int i=0; i<N; i++){
            ans = largestRectangleArea(A[i]); //one by one each row is being considered as a histogram
            res = Math.max(res, ans);
        }

        return res;
    }

    public int largestRectangleArea(int[] A){

        int max_area = 0;

        //area : height*width
        //height : A[i]
        //width : smallestOnRight - smallestOnLeft - 1

        //getLeftSmallerIndex
        int[] LSI = getLeftSmallerIndex(A);

        //getRightSmallerIndex
        int[] RSI = getRightSmallerIndex(A);

        //consider each element as the height of the rectangle
        for(int i=0; i<A.length; i++){
            int height = A[i];

            int R = RSI[i]; //right smaller index
            int L = LSI[i]; //left smaller index

            int width = R - L - 1; // R-L+1 is the width including R and L but we have to exclude both so (R - L + 1)-2 = R-L-1

            int current_area = height * width;

            max_area = Math.max(max_area, current_area); //update the max area
        }

        return max_area;
    }


    public int[] getLeftSmallerIndex(int[] A){
        Stack<Integer> stack = new Stack<>();

        int[] res = new int[A.length];
        Arrays.fill(res, -1); //default values filled

        for(int i=0; i<A.length; i++){
            //for the current element check the nearest smaller element index
            while(!stack.isEmpty() && A[stack.peek()] >= A[i]){
                stack.pop();
            }

            if(!stack.isEmpty() && A[stack.peek()] < A[i]){
                res[i] = stack.peek();  //we are storing the index and not the element
            }

            stack.push(i);
        }

        return res;
    }

    public int[] getRightSmallerIndex(int[] A){
        Stack<Integer> stack = new Stack<Integer>();

        int[] res = new int[A.length];
        Arrays.fill(res, A.length); //because we are storing index and not element

        for(int i=A.length-1; i>=0; i--){

            while(!stack.isEmpty() && A[stack.peek()] >= A[i]){
                stack.pop();
            }

            if(!stack.isEmpty() && A[stack.peek()] < A[i]){
                res[i] = stack.peek();
            }

            stack.push(i); //inserting index and not the element
        }

        return res;
    }
}
