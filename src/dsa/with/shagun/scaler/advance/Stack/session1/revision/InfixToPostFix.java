package dsa.with.shagun.scaler.advance.Stack.session1.revision;

import java.util.HashMap;
import java.util.Stack;

public class InfixToPostFix {

    public String solve(String A) {

        // To store the precedence of the operators we can use hashmap
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('^',3);
        map.put('/',2);
        map.put('*',2);
        map.put('-',1);
        map.put('+',1);
        map.put('(',-1);

        //Append all alphabetical letters to strBuilder
        StringBuilder str = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<A.length(); i++){
            char ch = A.charAt(i);

            if (Character.isLowerCase(ch)) {
                str.append(ch);
            }

            if(ch == '('){
                stack.push(ch); //push it no matter what operators are in the stack
            }
            if(ch == '^' || ch == '*' || ch == '/' || ch == '+' || ch == '-'){

                if(stack.isEmpty()){
                    stack.push(ch); //no comparison of precedence
                }else{
                    //if operator is of lower precedence, first pop all the higher precedence operators and then push this lower one into the stack
                    while(!stack.isEmpty() && map.get(stack.peek()) >= map.get(ch)){
                        str.append(stack.pop()); // then pop the elements from the stack till we reach lower precedence operators
                    }
                    //if operator is of higher precedence then push into the stack
                    stack.push(ch);
                }
            }
            if(ch == ')'){
                //pop till we reach opening bracket
                while(stack.peek()!='('){
                    str.append(stack.pop());
                }
                stack.pop(); // this is to pop opening bracket
            }
        }

        while(!stack.isEmpty()){
            str.append(stack.pop());
        }

        return str.toString();
    }
}
