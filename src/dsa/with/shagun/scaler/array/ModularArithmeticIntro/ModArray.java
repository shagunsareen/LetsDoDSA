package dsa.with.shagun.scaler.array.ModularArithmeticIntro;

public class ModArray {

    public int solve(int[] A, int B) {

        long ans = 0;
        long fans = 1; // (10^0%P ==1)
        for(int i=A.length-1; i>=0 ; i--){
            ans = ans + (A[i]*fans)%B;
            fans = (fans*10)%B;  // to update 10^x value we need to update fans
            // fans %B since N can go till 10^5 i.e. number of elements in array can be this much so 10^n can lead to overflow
            ans = ans%B;
        }

        return (int) ans;
    }
}
