package dsa.with.shagun.scaler.advance.Stack.session2;

import java.util.Stack;

public class RedundantBraces {
    public static void main(String[] args) {
        String str = "((a+b))";
        String str1 = "(a+(a+b))";
        String str2 = "a+b";
        String str3 = "(a)";
        String str4 = "(a+(a))";
        /*System.out.println(braces(str));
        System.out.println(braces(str1));
        System.out.println(braces(str2));
        System.out.println(braces(str3));*/
        System.out.println(braces(str4));
    }

    // ------ REDUNDANT IS WHEN WE HAVE NO OPERATOR WITHIN BRACKETS OR WHEN WE HAVE DUPLICATE BRACKETS ))
    public static int braces(String A) {
        int N=A.length();
        Stack<Character> stk=new Stack<>();

        for(int i=0;i<N;i++){
            char ch=A.charAt(i);

            if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='(')
                stk.push(ch);

            else if(ch==')' && stk.peek()=='(') return 1;               //if there's no operator behind ')' -- it has redundant braces

            else if(ch==')' && stk.peek()!='('){
                while(stk.peek()!='(')
                    stk.pop();                                      //keep removing till stack has '(' as peek element
                stk.pop();                                      //remove the '(' bracket also -- till this point valid exp part has been removed from stack
            }
        }
        return 0;
    }
}

// didn't work for some test cases
/*
Stack<Character> stack = new Stack<>();
        boolean isRedundant = false;
        for (char ch : A.toCharArray()) {
            if (ch != ')') { //  push all chars to stack until we get closed bracket
                stack.push(ch);
            } else {
                char top = stack.peek();
                // everytime we get closing paranthesis we have to reset this to see if there is any operator between them or not
                // ALSO SINCE WE ARE POPPING TILL WE ELEMENT IS NOT '('. IF INCOMING CHAR IS ')' AND TOP OF STACK HAS '(' THEN IT"S REDUNDANT
                isRedundant = true;
                while (!stack.empty() && top != '(') {
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        isRedundant = false; // if it has operators then it's not redundant
                    }
                    top = stack.peek();
                    stack.pop();
                }
            }
        }
        if (isRedundant) {
            return 1;
        }
        return 0;
 */

//wrong logic
        /*boolean charInsideBraces = false;
        boolean noBrackets = true;

        for (char ch : A.toCharArray()) {
            //check if string has brackets or not
            if (ch == '(' || ch == ')') {
                noBrackets = false;
            }

            //  push all chars to stack until we get closed bracket
            if (ch != ')') {
                stack.push(ch);
            } else {
                charInsideBraces = false;
                // if ch==')', pop until top of stack is '('
                while (!stack.empty() && stack.peek() != '(') {
                    stack.pop();
                    charInsideBraces = true;
                }
                stack.pop(); // to pop the closing braces.
            }
        }
        if(noBrackets){
            return 0;
        }
        return !charInsideBraces ? 1 : 0;*/

