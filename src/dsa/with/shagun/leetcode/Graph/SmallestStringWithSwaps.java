package dsa.with.shagun.leetcode.Graph;

import dsa.with.shagun.leetcode.UnionFind.UnionFind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SmallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        char[] str = s.toCharArray();

        //Key : ParentId, Value : Group of characters corresponding to the parentId
        //PriorityQueue is taken so that we get the smallest character first on polling
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();

        UnionFind uf = new UnionFind(str.length); // this will assign parentId to char's index itself

        //For every pair we unify and make common parents using unionFind
        for (List<Integer> pair : pairs) {
            uf.unify(pair.get(0), pair.get(1));
        }

        //Forming group : Processing each char of string to check to which group it belongs and updating group for the same parentId
        for (int i = 0; i < str.length; i++) {
            int parentId = uf.getAbsoluteParent(i); // returns to which group char belongs to

            PriorityQueue pq = map.getOrDefault(parentId, new PriorityQueue<>());  // returns group corresponding to ParentId
            pq.offer(str[i]); // Add char to the group
            map.putIfAbsent(parentId, pq); // update group in map
        }

        //Form the answer String after getting the smallest char from that group of PQ
        for (int i = 0; i < str.length; i++) {
            int parentId = uf.getAbsoluteParent(i);
            str[i] = map.get(parentId).poll(); // This returns smallest char from that group
        }
        return new String(str);
    }
}
