package dsa.with.shagun.leetcode.Array;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
       // System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(partitionLabels("eccbbbbdec"));
    }

    public static List<Integer> partitionLabels(String s) {
        int[] countArray = new int[26];

        //storing the max index of each element
        for (int i = 0; i < s.length(); i++) {
            countArray[s.charAt(i) - 'a'] = i;
        }

        //Get the partition
        int last = 0;
        int start = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            last = Math.max(last, countArray[s.charAt(i) - 'a']);
            if (last == i) {
                list.add(last - start + 1);
                start = last + 1;
            }
        }

        return list;
    }
}
