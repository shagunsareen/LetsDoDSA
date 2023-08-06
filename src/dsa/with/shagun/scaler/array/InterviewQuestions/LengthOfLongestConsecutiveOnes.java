package dsa.with.shagun.scaler.array.InterviewQuestions;

public class LengthOfLongestConsecutiveOnes {

    public static void main(String[] args) {
        //System.out.println(solve("000000000000000"));
        System.out.println(solve("11010110000000000"));
    }

    public static int solve(String A) {  // TC : O(3N) as each element is touched atmost 3 times , SC : O(1)

        char[] ch = A.toCharArray();
        int n = ch.length;
        int ans = 0;
        int onesCount = 0;

        //count total 1s in array
        for (int i = 0; i < n; i++) {
            if (ch[i] - '0' == 1) onesCount++;
        }
        if(onesCount==0)   // IMP EDGE CASE
            return ans;

        // iterate over every element to get max consecutive 1s
        for (int i = 0; i < n; i++) {
            int lCount = 0;
            int rCount = 0;
            //check if element is zero, then go inside swap logic otherwise not required
            if (ch[i] - '0' == 0) {
                //count left consecutive 1's
                for (int l = i - 1; l >= 0; l--) {
                    if (ch[l] - '0' == 1) lCount++;
                    else break;  // i.e. if zero is found then exit
                }
                //count right consecutive 1's
                for (int r = i + 1; r < n; r++) {
                    if (ch[r] - '0' == 1) rCount++;
                    else break;  // i.e. if zero is found then exit
                }

                //check if we have extra 1 to swap or not
                if (onesCount == lCount + rCount) { // if left and right count of 1s is total count of 1s then we don't have any extra 1 to swap
                    ans = Math.max(lCount + rCount, ans);
                } else {
                    ans = Math.max(lCount + rCount + 1, ans); // this extra 1 can be added only if its present i.e get total count of 1s in array to check if we can add this or not
                }
            }
        }
        if (ans == 0) return ch.length; // i.e. if ans has not changed meaning all elements in array were zero // IMP EDGE CASE
        return ans;
    }
}
