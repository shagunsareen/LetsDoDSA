package dsa.with.shagun.scaler.advance.Stack.session2.revision;

import java.util.Stack;

public class SortStackUsingStack {
    public int[] solve(int[] A) {
        //To sort a stack first i need to convert an array to a stack
        Stack<Integer> inputStack = new Stack<>();
        for(int i : A){
            inputStack.push(i);
        }

        Stack<Integer> ansStack = divideStack(inputStack);

        //convert the answer to array
        int[] res = new int[ansStack.size()];

        int i=0;
        while(!ansStack.isEmpty()){
            res[i] = ansStack.pop();
            i++;
        }

        return res;
    }

    //now that we have the stack let's sort it using mergeSort
    //For mergeSort we need to divide the stack into 2 stacks and then send it to merge function to sort
    public Stack<Integer> divideStack(Stack<Integer> stack1){

        //as we can't divide this stack further into parts
        if(stack1.isEmpty() || stack1.size() == 1){
            return stack1;
        }

        int newStackSize = stack1.size()/2;
        Stack<Integer> stack2 = new Stack<Integer>();

        //Insert half of the elements into the other stack
        for(int i=0; i<newStackSize; i++){
            //System.out.println("Pushed into stack 2 : "+ stack1.peek());
            stack2.push(stack1.pop());
        }

        stack1 = divideStack(stack1); //divided till sorted stack is returned
        stack2 = divideStack(stack2);

        return mergeStacks(stack1, stack2);
    }


    //This is the merge function to merge sorted stacks.
    public Stack<Integer> mergeStacks(Stack<Integer> s1, Stack<Integer> s2){

        Stack<Integer> sortedStack = new Stack<Integer>();

        while(!s1.isEmpty() && !s2.isEmpty()){
            if(s1.peek() < s2.peek()){
                sortedStack.push(s1.pop()); //push the smaller value into the stack first so that we get a sorted stack
            }else{
                sortedStack.push(s2.pop());
            }
        }

        //if s1 is null then push s2 stacks elements to resStack
        while(!s2.isEmpty()){
            sortedStack.push(s2.pop());
        }

        //if s2 is null then push s2 stacks elements to resStack
        while(!s1.isEmpty()){
            sortedStack.push(s1.pop());
        }

        //now that we have a sortedStack, we have to reverse it since stack follows LIFO i.e. Last In First Out
        //so this will give ans in decreasing order but we need it in increasing order
        return reverse(sortedStack);
    }

    public Stack<Integer> reverse(Stack<Integer> stack){
        Stack<Integer> reverseStack = new Stack<Integer>();

        while(!stack.isEmpty()){
            reverseStack.push(stack.pop());
        }

        return reverseStack;
    }
}
