package dsa.with.shagun.leetcode.TwoPointer;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        int skipS = 0;
        int skipT = 0; //these will tell how many chars have to be skipped at a point in a particular string
        int i = s.length() - 1;
        int j = t.length() - 1; //start loop from back such that if we encounter # then we know which element we need to skip

        while (i >= 0 || j >= 0) {

            //s string
            while (i >= 0) {
                if (s.charAt(i) == '#') { //check if current char is # .If yes then increment skipS value
                    skipS++;
                    i--;
                } else if (skipS > 0) { //if current char is not # then check skip value
                    skipS--;
                    i--;
                } else { // if current char is not # and skipS>0 then keep pointer at that place only
                    break;
                }
            }

            //t string
            while (j >= 0) {
                if (t.charAt(j) == '#') { //check if current char is # .If yes then increment skipT value
                    skipT++;
                    j--;
                } else if (skipT > 0) { //if current char is not # then check skip value
                    skipT--;
                    j--;
                } else { // if current char is not # and skipT>0 then keep pointer at that place only
                    break;
                }
            }

            // Now that we have the char at particular index let's compare
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {  // If values don't match then return false
                return false;
            } else if ((i >= 0) != (j >= 0)) {
                return false;
            }

            i--;  // if both above conditions are not true then decrement pointer
            j--;
        }
        return true;
    }
}
