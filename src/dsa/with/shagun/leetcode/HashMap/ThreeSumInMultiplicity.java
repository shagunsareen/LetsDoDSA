package dsa.with.shagun.leetcode.HashMap;

import java.util.HashMap;
import java.util.Map;

public class ThreeSumInMultiplicity { //TC : O(n2) SC :O(n)
    public int threeSumMulti(int[] arr, int target) {
        long ans = 0;
        Map<Integer, Long> freqMap = new HashMap<Integer, Long>();
        //storing elements with frequencies
        for (int el : arr) {
            long freq = freqMap.getOrDefault(el, 0L); //Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.
            freqMap.put(el, freq + 1);
        }

        for (Integer el1 : freqMap.keySet()) {
            for (Integer el2 : freqMap.keySet()) {
                int el3 = target - el1 - el2;
                if (freqMap.containsKey(el3)) {
                    long freq1 = freqMap.get(el1);
                    long freq2 = freqMap.get(el2);
                    long freq3 = freqMap.get(el3);

                    if (el1 < el2 && el2 < el3) {  // this is to count just one combo and not all similar combinations
                        ans += freq1 * freq2 * freq3;
                    } else if (el1 == el2 && el2 != el3) {
                        ans += freq3 * (freq1 * (freq1 - 1)) / 2;
                    } else if (el1 == el2 && el2 == el3) {
                        ans += (freq1 * (freq1 - 1) * (freq1 - 2)) / 6;
                    }
                }
                ans = (long) (ans % (Math.pow(10, 9) + 7));
                //ans = ans % (1e9 + 7);
            }
        }
        return (int) ans;
    }
}
