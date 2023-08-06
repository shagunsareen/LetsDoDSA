package dsa.with.shagun.scaler.array.CarryForward;

public class PickFromBothSides {
    public int solve(int[] A, int B) {

        int n = A.length;
        int sum = Integer.MIN_VALUE;
        int currSum = 0;


        //first consider all leftmost elements are removed hence take sum of those elements
        for(int i=0; i<B; i++){
            currSum += A[i];
        }

        int back = B-1; //storing index of last element till where we went from leftside
        sum = currSum;

        //consider L:B-1 R:1, L:B-2 R:2, L:B-3 R:3 and so on till L:0 R:B
        for(int j=n-1; j>=n-B; j--){
            currSum = currSum - A[back]; //removing 1-1 element from left and increasing those many elements on the right
            currSum = currSum + A[j]; // considering rightmost element
            back--;
            sum = Math.max(sum, currSum);
        }

        return sum;
    }
}
