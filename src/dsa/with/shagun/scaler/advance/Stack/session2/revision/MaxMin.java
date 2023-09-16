package dsa.with.shagun.scaler.advance.Stack.session2.revision;

import java.util.Arrays;
import java.util.Stack;

public class MaxMin {
    public int solve(int[] A) {

        //To get the contribution of each element, check in how many subarrays it will be maximum and in how many it will be minimum
        //it will be maximum in subarrays till we get previous greater element and next greater element.
        //it will be minimum in subarrays till we get previous smaller element and next smaller element.
        //To consider this for every element , I need to get PGE and NGE, PSE and NSE.

        int[] psi = previousSmallerIndex(A);
        int[] nsi = nextSmallerIndex(A);
        int[] pgi = previousGreaterIndex(A);
        int[] ngi = nextGreaterIndex(A);

        long countCurrEleMaxInSub;
        long countCurrEleMinInSub;

        long sum = 0;
        int mod = 1000 * 1000 * 1000+7;
        if (A.length == 1) return A[0];

        //calculate CONTRIBUTION for every element in the array
        for(int i=0; i<A.length; i++){

            countCurrEleMaxInSub = (long) (i - pgi[i]) * (ngi[i] - i);
            long currEleMaxContri = (countCurrEleMaxInSub * A[i]) % mod;

            countCurrEleMinInSub = (long) (i - psi[i]) * (nsi[i] - i);
            long currEleMinContri = (countCurrEleMinInSub * A[i]) % mod;

            //we have to calculate sunm of difference of max - min
            sum = (sum % mod + (currEleMaxContri % mod - currEleMinContri % mod) % mod) % mod;
        }
        return (int) ((sum + mod) % mod);
    }

    public int[] previousSmallerIndex(int[] A){
        Stack<Integer> stack = new Stack<Integer>();

        //resultant index array
        int n = A.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && A[stack.peek()] >= A[i]){
                stack.pop(); //until we get the smaller element
            }

            if(!stack.isEmpty() && A[stack.peek()] < A[i]){
                res[i] = stack.peek();
            }

            stack.push(i);
        }
        return res;
    }

    public int[] nextSmallerIndex(int[] A){
        Stack<Integer> stack = new Stack<Integer>();

        //resultant index array
        int n = A.length;
        int[] res = new int[n];
        Arrays.fill(res, A.length);

        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && A[stack.peek()] >= A[i]){
                stack.pop(); //until we get the smaller element
            }

            if(!stack.isEmpty() && A[stack.peek()] < A[i]){
                res[i] = stack.peek(); //got the smaller element and stored it as a result
            }

            stack.push(i);
        }
        return res;
    }

    //This is to get the previous greater element
    public int[] previousGreaterIndex(int[] A){
        Stack<Integer> stack = new Stack<Integer>();

        //resultant index array
        int n = A.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && A[stack.peek()] <= A[i]){
                stack.pop(); //until we get the smaller element
            }

            if(!stack.isEmpty() && A[stack.peek()] > A[i]){
                res[i] = stack.peek(); //store the greater element
            }

            stack.push(i);
        }
        return res;
    }

    public int[] nextGreaterIndex(int[] A){
        Stack<Integer> stack = new Stack<Integer>();

        //resultant index array
        int n = A.length;
        int[] res = new int[n];
        Arrays.fill(res, A.length);

        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && A[stack.peek()] <= A[i]){
                stack.pop(); //until we get the smaller element
            }

            if(!stack.isEmpty() && A[stack.peek()] > A[i]){
                res[i] = stack.peek();
            }

            stack.push(i);
        }
        return res;
    }
}
