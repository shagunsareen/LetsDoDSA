package dsa.with.shagun.scaler.advance.TwoPointer;

public class AnotherCountRectangle {
        public int solve(int[] A, int B) {

            //since arrays are sorted and we need to find pairs so two pointers can be used.
            //This can be done using brute froce approach as well where we see all pairs which can be possible but that will take time complexity as O(n2)

            //hence, we will see how can we see in one pass approach i.e. 2 pointers
            int l=0;
            int b=A.length-1;
            long count = 0;
            long mod = 1000000007;

            while(l<=b){

                long area = (long) A[l] * A[b];
                if(area >= B){ // sum is greater than B then move the right ptr to left
                    b--;
                }else{
                    //this is what we require hence check no. of elements and get the pairs
                    long elements = b-l+1; //1 is added because of 1 based indexing , pairs would be l*b, l*b-1, L*b-2, till we reach l from b
                    long pairs = (2*elements-1)%mod;
                    count =  (count%mod +  pairs%mod)%mod;  // (A+B)%X = (A%X + B%X)%X
                    l++;
                }
            }

            return (int)(count%mod);
        }
}
