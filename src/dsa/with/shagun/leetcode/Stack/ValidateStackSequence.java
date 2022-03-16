package dsa.with.shagun.leetcode.Stack;

import java.util.Stack;

public class ValidateStackSequence {
    public static void main(String[] args) {
        int[] pushed = new int[]{1,2,3,4,5};
        int[] popped = new int[]{4,5,3,2,1};
        System.out.println(validateStackSequences(pushed, popped));
    }


    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        /* Approach 1 : TC : O(N), SC:O(N)
        Stack<Integer> stack = new Stack<>();
        int i=0;
        for(int x : pushed){
            stack.push(x);
            while(!stack.isEmpty() && stack.peek() == popped[i]){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();*/

        //Approach 2 : TC : O(N), SC:O(1)
        int i=0; int j=0;
        for(int x : pushed){
           pushed[i] = x;
           i++;
            while(i>0 && pushed[i-1] == popped[j]){
                --i;
                ++j;
            }
        }
        return i==0;

        /*int i=0; int j=0;
        for(int x : pushed){
            pushed[i] = x;
            while(i>0 && pushed[i] == popped[j]){
                --i;
                ++j;
            }
            i++;
        }
        return i==0;*/
    }
}
