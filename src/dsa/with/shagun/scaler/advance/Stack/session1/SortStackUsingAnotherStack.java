package dsa.with.shagun.scaler.advance.Stack.session1;

import java.util.Stack;

public class SortStackUsingAnotherStack {
    public static void main(String[] args) {
        Stack<Integer> sa = new Stack<>();
        sa.push(11);
        sa.push(100);
        sa.push(17);
        sa.push(5);
        Stack<Integer> res = stackSort(sa);
        while (!res.empty()) {
            System.out.println(res.pop());
        }
    }

    public static Stack<Integer> stackSort(Stack<Integer> s1) { //TC : O(NLogN), SC:O(N/2+logN) logN is for recursion stack

        //Break condition
        if (s1.size() <= 1) {
            return s1;
        }

        //Let's apply merge sort logic
        //Step1 : Find mid of stack size, divide into 2 stacks , then mergeStacks to sort them into 1
        int n = s1.size();
        Stack<Integer> s2 = new Stack<>();

        //Push half of the elements into other stack then compare both the stacks
        for (int i = 0; i < n / 2; i++) {
            s2.push(s1.pop());
        }
        s1 = stackSort(s1);
        s2 = stackSort(s2);

        return MergeStacks.mergeStacks(s1, s2);
    }
}
