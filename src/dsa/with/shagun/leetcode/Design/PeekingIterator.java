package dsa.with.shagun.leetcode.Design;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PeekingIterator implements Iterator<Integer> {

    Integer next = null;
    Iterator<Integer> itr = null;
    boolean noSuchElement;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        itr = iterator;
        advanceIterator();
    }

    private void advanceIterator() {
        if (itr.hasNext()) {
            next = itr.next();
        } else {
            noSuchElement = true;
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() { // Returns the next element in the array and moves the pointer to the next element.
        if (noSuchElement) {
            throw new NoSuchElementException();
        }
        Integer currentValue = next;
        advanceIterator();
        return currentValue;
    }

    @Override
    public boolean hasNext() { // Returns true if there are still elements in the array
        return !noSuchElement;
    }
}
