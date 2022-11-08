package dsa.with.shagun.scaler.Strings;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(solve("scaler"));
        System.out.println(solve("academy"));
    }

    //TC: O(N), SC: O(N)
    public static String solve(String A) {
        char[] ch = A.toCharArray();
        int start=0;
        int end=ch.length-1;

        for (int i=0; i<ch.length; i++){
            if(start<=end) {
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start++;
                end--;
            }
        }
        return String.valueOf(ch);
    }
}
