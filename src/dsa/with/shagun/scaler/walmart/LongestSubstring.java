package dsa.with.shagun.scaler.walmart;

import java.util.HashMap;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        // put the character along with the last index of that element so that we can restart the string
        HashMap<Character, Integer> map = new HashMap();

        int start=0;
        int end=0;
        int maxLength = 0;

        if(s.length()==1){
            return 1;
        }

        while(end < s.length()){
            char ch = s.charAt(end);

            //char is not present in the map hence non repeating hence move to next char i.e. increment end
            if(!map.containsKey(ch)){
                map.put(ch, end);
            }else{
                //if we got repeating char that means consider new substring
                start = Math.max(map.get(ch)+1, start);
                if(map.get(ch) < start){
                    map.remove(ch);
                    map.put(ch, end);
                }else{
                    map.replace(ch, end);
                }
            }
            System.out.println(end+"-"+start);
            maxLength = Math.max(maxLength, end-start+1);
            System.out.println(maxLength);
            end++;
        }

        return maxLength;
    }
}
