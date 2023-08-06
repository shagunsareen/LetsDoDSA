package dsa.with.shagun.scaler.advance.Recursion;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    //TC:O(2^N) because there are these many elements to store for n bits
    //SC:O(2^N + N) because we need to store these many elements in list and N elements at max in recursion stack
    public static void main(String[] args) {
        grayCode(4);
    }

    public static List<Integer> grayCode(int N) {
        if (N==1) {
            List<Integer> baseList = new ArrayList<>();
            baseList.add(0);
            baseList.add(1);
            return baseList;
        }
        List<Integer> list = grayCode(N - 1);  // this will return list of elements with N-1 bits
        // copy that list into new list to include next bit numbers
        List<Integer> ans = new ArrayList<>(list);

        for (int i = list.size() - 1; i >= 0; i--) {//take opposite of list as we need only 1 bit difference in the numbers
            ans.add(list.get(i) + (1 << (N - 1)));
        }
        return ans;
    }
}
