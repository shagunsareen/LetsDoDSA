package dsa.with.shagun.scaler.advance.Stack.session1.revision;

import java.util.Stack;

public class CheckTwoBracketExpression {
    public int solve(String A, String B) {

        char[] signsA = calculateSigns(A);
        char[] signsB = calculateSigns(B);

        for(int i=0; i<signsA.length; i++){
            if(signsA[i] != signsB[i]){
                return 0;
            }
        }
        return 1;
    }

    public char[] calculateSigns(String str){
        //This is to store the global sign
        Stack<Character> globalOperator = new Stack<>();

        char[] localOperators = new char[26];

        char localOperator = '+'; //let's consider the default sign to be positive

        for(int i=0; i < str.length(); i++){

            char ch = str.charAt(i);

            if(ch == '+' || ch=='-'){
                //let's calculate the sign as per global operator
                if(globalOperator.isEmpty()){
                    localOperator = ch;
                }else{
                    localOperator = calculateSign(globalOperator.peek(), ch);
                }
                continue;
            }else if(ch == '('){
                globalOperator.push(localOperator); //update the globalOperator since the sign before the braces is the globalOperator now
                continue;
            }else if(ch == ')'){
                //pop the globalOperator since the internal expression is properly evaluated
                globalOperator.pop();
                continue;
            }

            localOperators[ch - 'a'] = localOperator;
        }

        return localOperators;
    }

    public char calculateSign(char operand1, char operand2){
        if((operand1 == '+' && operand2 == '-') || (operand1 == '-' && operand2 == '+')){
            //change the sign to return negative sign
            return '-';
        }

        return '+'; //for other scenarios
    }
}
