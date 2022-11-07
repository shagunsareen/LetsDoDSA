package dsa.with.shagun.scaler.Strings;

public class LowerCase {
    public static void main(String[] args) {
        System.out.println(to_lower(new char[]{'S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0'}));
    }
    public static char[] to_lower(char[] A) {  //TC : O(N), SC :O(1)
        for(int i=0;i<A.length;i++){
            if(A[i]>=65 && A[i]<=90){
                A[i] = (char) (A[i]^32);
            }
        }
        return A;
    }

    /*public ArrayList<Character> to_lower(ArrayList<Character> A) {
        for(int i = 0; i < A.size(); ++i){
            A.set(i, Character.toLowerCase(A.get(i)));
        }
        return A;
    }*/
}
