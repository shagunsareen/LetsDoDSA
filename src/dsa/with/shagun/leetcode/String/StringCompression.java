package dsa.with.shagun.leetcode.String;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        //System.out.println(compress(new char[]{'a'}));
        // System.out.println(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));

    }

    public static int compress(char[] chars) {
       /* int count =1;
        String newStr = String.valueOf(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                if (count > 1) {
                    newStr += count;
                    count = 1;
                }
                newStr = newStr + chars[i];
            } else {
                count++;
            }
        }
        if(count>1){
            newStr += count;
        }
        chars = newStr.toCharArray();
        return chars.length;*/

        int index = 0;
        int indexAns = 0;
        while (index < chars.length) {
            char currentChar = chars[index];
            int count = 0;
            while (index < chars.length && chars[index] == currentChar) {
                count++;
                index++;
            }
            chars[indexAns++] = currentChar;
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray())
                    chars[indexAns++] = c;
            }
        }
        return indexAns;
    }
}
