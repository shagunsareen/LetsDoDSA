package dsa.with.shagun.leetcode.HashMap;

import java.util.*;

public class MyHashMap {

    /* // Approach 1 : TC : O(1) but SC : O(range of elements)

    int[] hashMap = null;

    public MyHashMap() {
        hashMap = new int[1000001];
        Arrays.fill(hashMap, -1); // Fill it with -1 because if no value exists for key we need to return -1
    }

    public void put(int key, int value) {
        hashMap[key] = value;
    }

    public int get(int key) {
        return hashMap[key];
    }

    public void remove(int key) {
        put(key, -1);
    }*/

    LinkedList<MapEntry>[] hashMap = null;
    public static int initialCapacity = 0;

    public MyHashMap() {
        initialCapacity = 1500;
        hashMap = new LinkedList[initialCapacity];
    }

    int getKeyHash(int key) {
        return key % initialCapacity;
    }

    public void put(int key, int value) {
        //get bucket index where to insert
        int hashIndex = getKeyHash(key);

        //check if LL is null, create LL if null
        if (hashMap[hashIndex] == null) {
            hashMap[hashIndex] = new LinkedList<MapEntry>();
            hashMap[hashIndex].add(new MapEntry(key, value)); // if LL was null add new pair
        } else {
            //check if same key exists , if yes then upate the value
            for (MapEntry e : hashMap[hashIndex]) {
                if (e.mapKey == key) {
                    e.mapValue = value;
                    return;
                }
            }
            hashMap[hashIndex].add(new MapEntry(key, value));  // if no such key exists add new pair
        }
    }

    public int get(int key) {
        int hashIndex = getKeyHash(key);
        LinkedList<MapEntry> listEntries = hashMap[hashIndex];
        //Base case if LL is null
        if (listEntries == null) return -1;
        //check for key
        for (MapEntry e : listEntries) {
            if (e.mapKey == key) {
                return e.mapValue;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hashIndex = getKeyHash(key);
        MapEntry toRemove = null;
        if (hashMap[hashIndex] == null) {
            return; // if no LL exists at that location then simply return
        } else {
            for (MapEntry e : hashMap[hashIndex]) {
                if (e.mapKey == key)
                    toRemove = e;
            }
            if(toRemove == null) return;
            hashMap[hashIndex].remove(toRemove);
        }
    }

    class MapEntry {
        int mapKey;
        int mapValue;

        MapEntry(int key, int value) {
            this.mapKey = key;
            this.mapValue = value;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

