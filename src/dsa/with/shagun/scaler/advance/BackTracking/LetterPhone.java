package dsa.with.shagun.scaler.advance.BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LetterPhone {
    ArrayList<String> res;

    public ArrayList<String> letterCombinations(String A) {

        //Take a map to store all characters against a digit
        Map<Character, String> map = new HashMap<>();
        map.put('0', "0");
        map.put('1', "1");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        res = new ArrayList<>();

        StringBuilder strB = new StringBuilder();
        //0 is the starting index of the string
        getCombination(strB, map, A, 0);

        return res;
    }

    //I have to iterate over all characters of a particular digit in the given string
    //and form all combinations with all characters of the second digit
    private void getCombination(StringBuilder currSb, Map<Character, String> map, String input, int index) {

        //Base condition
        if (index == input.length()) {
            res.add(currSb.toString());
            return;
        }

        //suppose string is 23 then first character is 2
        char c = input.charAt(index);
        String currMappedStr = map.get(c);

        //to iterate over all the mapping characters of the string of digit 2 i.e. abc
        for (int i = 0; i < currMappedStr.length(); i++) {
            char appendCharToStr = currMappedStr.charAt(i);
            //DO
            currSb.append(appendCharToStr);

            getCombination(currSb, map, input, index + 1);

            //UNDO
            currSb.deleteCharAt(currSb.length() - 1); //remove the last appended character
        }
    }
}