package dsa.with.shagun.scaler.advance.Stack.session1;

import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {
        /*push(1);
        push(2);
        push(-2);
        System.out.println(getMin());
        pop();
        System.out.println(getMin());
        System.out.println(top());*/

        /*push2(1);
        push2(2);
        push2(-2);*/
        push2(644643544);
        System.out.println(getMin2());
        /*pop2();
        System.out.println(getMin2());
        System.out.println(top2());*/
    }

    //Approach 1 : maintaing min in minStack and updating it when push and pop happens
    //TC : O(N), SC:O(N)
    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> minStack = new Stack<>();

    public static void push(int x) {
        stack.push(x);
        //push min ele to minStack
        if (minStack.empty()) {
            minStack.push(x);
        } else {
            if (x < minStack.peek()) {
                minStack.push(x);
            }
        }
    }

    public static void pop() {
        int top;
        if (!stack.empty()) {
            top = stack.pop();
            //if popped element is min then pop from minStack
            if (!minStack.empty() && minStack.peek() == top) {
                minStack.pop();
            }
        }
    }

    public static int top() {
        if (!stack.empty()) {
            return stack.peek();
        }
        return -1;
    }

    public static int getMin() {
        if (!minStack.empty() && !stack.empty()) {
            return minStack.peek();
        }
        return -1;
    }

    //Approach 2 : Without using minStack space, TC :O(N), SC:O(1)
    //Store element as (e * dummy_value + minSoFar),
    // TOP = stack.peek() / dummy_value,
    // MINSOFAR = stack.peek() % dummy_value
    static int minSoFar = Integer.MAX_VALUE;
    static int dummyValue = 2;
    static int originalVal;

    public static void push2(int x) {
        originalVal = x;
        //update min whenever a new element is inserted
        if (stack.empty() || x <= minSoFar) {
            minSoFar = x;
        }
        //The element will store element value and also min value till this insertion point
        int x1 = x * dummyValue + minSoFar;
        stack.push(x1);
    }

    public static void pop2() {
        if (!stack.empty()) {
            stack.pop();
        }
    }

    public static int top2() {
        if (!stack.empty()) {
            return stack.peek() / dummyValue;
        }
        return -1;
    }

    public static int getMin2() {
        if (stack.empty()) {
            return -1;
        } else {
            return stack.peek() % dummyValue == 0 ? dummyValue : stack.peek() % dummyValue;
        }
    }


    //Approach 3 : With storing min element and current element everytime there is a min. change and popping 2 elements if its min element
    int minSoFar3 = Integer.MAX_VALUE;
    Stack<Integer> stack3 = new Stack<>();

    public  void push3(int x) {
        //update min whenever a new element is inserted
        if (stack3.empty() || x <= minSoFar3) {
            stack3.push(minSoFar3);
            minSoFar3 = x;
        }
        stack3.push(x);
    }

    public  void pop3() {
        if (!stack3.empty()) {
            if(stack3.peek()==minSoFar3){
                stack3.pop();
                minSoFar=stack3.pop();
            }else{
                stack3.pop();
            }
        }
    }

    public  int top3() {
        if (!stack.empty()) {
            return stack.peek();
        }
        return -1;
    }

    public  int getMin3() {
        if (stack.empty()) {
            return -1;
        } else {
            return minSoFar;
        }
    }

}
