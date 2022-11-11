package dsa.with.shagun.scaler.Strings;

import netscape.security.UserTarget;

public class ReverseSentence {
    public static void main(String[] args) {
       // System.out.println(solve("scaler_academy_is_the_best"));
        System.out.println(solve("crulgzfkif gg ombt vemmoxrgf    qoddptokkz op xdq hv "));

    }

    public static String solve(String s) {

        //Approach 1: more time complexity

        /*int start = 0;
        int end = A.length() - 1;

        if(A.charAt(start) == ' '){
            start++;
        }
        if(A.charAt(end) == ' '){
            end--;
        }
        A = A.substring(start,end+1);
        //reverse whole string first
        String reversedA = reverseString(A, start, end);
        reversedA = reversedA.replaceAll("[ ]+", " ");

        int p1 = 0;
        int p2 = 0;
        //reverse word by word before space is encountered
        while (p2 < reversedA.length()) {
            //increment p2 till we get the space ,then reverse p1 and p2-1
            while (p2 < reversedA.length() && reversedA.charAt(p2) != ' ') {
                p2++;
            }
            *//*while(reversedA.charAt(p2) == ' '){
                p2++;
            }*//*
            reversedA = reverseString(reversedA, p1, p2 - 1);
            p1 = p2 + 1;
            p2 = p1;
        }

        return reversedA;
    }

    private static String reverseString(String A, int start, int end) {
        char[] ch = A.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (start <= end) {
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start++;
                end--;
            }else{
                break;
            }
        }
        return String.valueOf(ch);
    }*/

        //Approach 2 : One pass solution (optimised approach)
        StringBuilder res = new StringBuilder();
        StringBuilder buf = new StringBuilder();

        for(int i = s.length()-1; i>=0; i--)
        {
            char c = s.charAt(i);
            if(c!=' ') buf.append(c);
            else create(res, buf);
        }

        create(res, buf);
        return res.toString();
    }

    private static void create(StringBuilder res, StringBuilder buf)
    {
        int i = buf.length()-1;

        while(i>=0){
            if(i==buf.length()-1 && res.length()>0) res.append(' ');
            res.append(buf.charAt(i));
            i--;
        }
        buf.setLength(0);
    }
}
