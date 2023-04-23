package dsa.with.shagun.scaler.array.InterviewQuestions.Two;

public class SpecialIndex {

    public int solve(int[] A) {

        //since we need sum of even and odd indices , we can create prefixEven array and prefixOdd array
        int[] prefixEven = new int[A.length];
        int[] prefixOdd = new int[A.length];

        prefixEven[0] = A[0];
        prefixOdd[0] = 0;
        int se = Integer.MIN_VALUE;
        int so = Integer.MIN_VALUE;

        for(int i=1; i<A.length;i++){
            if(i%2==0){ // it is an even index
                prefixEven[i] = prefixEven[i-1] + A[i];
                prefixOdd[i] = prefixOdd[i-1];
            }else{
                prefixEven[i] = prefixEven[i-1];
                prefixOdd[i] = prefixOdd[i-1] + A[i];
            }
        }

        //consider each element is deleted once and check if sum of even index == sum of odd indexes
        int n = A.length;
        int count = 0;
        for(int j=0; j<n; j++){
            if(j==0){
                se = prefixOdd[n-1] - prefixOdd[j];
                so = prefixEven[n-1] - prefixEven[j];
            }else{
                se = prefixEven[j-1] + prefixOdd[n-1] - prefixOdd[j];
                so = prefixOdd[j-1] + prefixEven[n-1] - prefixEven[j];
            }

            if(se==so){
                count++;
            }
        }

        return count;
    }
}
