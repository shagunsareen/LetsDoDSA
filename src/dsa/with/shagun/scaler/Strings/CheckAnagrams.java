package dsa.with.shagun.scaler.Strings;

import java.util.HashMap;
import java.util.Map;

public class CheckAnagrams {
    public int solve(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();

        Map<Character, Integer> freqA = new HashMap<>();
        Map<Character, Integer> freqB = new HashMap<>();

        for(int i=0; i<a.length; i++){
            freqA.put(a[i], freqA.getOrDefault(a[i], 0)+1);
        }

        for(int i=0; i<b.length; i++){
            freqB.put(b[i], freqB.getOrDefault(b[i], 0)+1);
        }

        return freqA.equals(freqB) ? 1 : 0;

        //Alternative data structure
        /*
            int[] freq1 = new int[26];
            int[] freq2 = new int[26];
            for(int i = 0 ; i < A.length() ; i++){
                freq1[A.charAt(i) - 'a']++;
                freq2[B.charAt(i) - 'a']++;
            }
            for(int i = 0 ; i < 26 ; i++){
                if(freq1[i] != freq2[i]){
                    return 0;
                }
            }
            return 1;
         */
    }
}
