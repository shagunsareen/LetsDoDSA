package dsa.with.shagun.leetcode.HashSet;

import java.util.LinkedList;
import java.util.List;

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
public class MyHashSet {

    //Approach 1 : With Array
   /* boolean[] hashSet = null;

    public MyHashSet() {
        hashSet = new boolean[1000001];
    }

    public void add(int key) {
        hashSet[key] = true;
    }

    public void remove(int key) {
        hashSet[key] = false;
    }

    public boolean contains(int key) {
        return hashSet[key];
    }*/

    //Approach 2 : TC :O(N)
    int initialCapacity = 0;
    List<Integer>[] hashSet = null;

    public MyHashSet() {
        initialCapacity = 1500;
        hashSet = new List[initialCapacity];  // Kind of 2D Array as on every index we have a linked list
    }

    int getKeyHash(int key) {
        return key % initialCapacity;
    }

    public void add(int key) {
        int hashIndex = getKeyHash(key);

        //check first if LL exists at that index or not
        if (hashSet[hashIndex] == null) {
            hashSet[hashIndex] = new LinkedList<>(); //create if no LL exists
        }

        //check if key exists already or not
        if (!hashSet[hashIndex].contains(key)) {
            hashSet[hashIndex].add(key);
        }
    }

    public void remove(int key) {
        int hashIndex = getKeyHash(key);
        if(contains(key)){
            hashSet[hashIndex].remove(hashSet[hashIndex].indexOf(key));
        }
    }

    public boolean contains(int key) {
        int hashIndex = getKeyHash(key);
        if (hashSet[hashIndex] == null || hashSet[hashIndex].indexOf(key) == -1) {
            return false;
        }
        return true;
    }
}


