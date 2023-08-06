package dsa.with.shagun.scaler.Strings;

public class UpperCase {
    public static void main(String[] args) {
        System.out.println(to_upper(new char[]{'S', 'c', 'A', 'L', 'E', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y'}));
    }

    //TC : O(N), SC :O(1)
    public static char[] to_upper(char[] A) {
        // since 32 if converted to binary has 5th bit set. And lowercase letters have 5th bit set , so 1 xor 1 will be 0 which is 5th bit in uppercase letters
        for(int i=0;i<A.length;i++){
            if(A[i]>=97 && A[i]<=122){
                A[i] = (char) (A[i]^32);
            }
        }
        return A;
    }
}
