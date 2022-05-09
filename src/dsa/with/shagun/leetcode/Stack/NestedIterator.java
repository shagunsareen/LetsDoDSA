package dsa.with.shagun.leetcode.Stack;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
public class NestedIterator implements Iterator<Integer> { // TC : O(n) ,SC :O(n)
    Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {  //Initializes the iterator with the nested list nestedList
        stack = new Stack<>();
        initialize(nestedList);
    }

    private void initialize(List<NestedInteger> nestedList) {  // read each element of nested List and then separate that out and push to stack
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() { // Returns the next integer in the nested list
        if (!hasNext()) {
            return null;
        }
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() { // Returns true if there are still some integers in the nested list and false otherwise
        while (!stack.isEmpty() && !stack.peek().isInteger()) { // check if stack is not empty and it's a list
            initialize(stack.pop().getList()); // get that list and push elements one by one
        }
        return !stack.isEmpty();
    }
}
