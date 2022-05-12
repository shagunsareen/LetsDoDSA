package dsa.with.shagun.leetcode.RecursionBacktracking;

import java.util.*;
import java.util.stream.Collectors;

public class PermutationsTwo {
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 2}).toString());
    }

    static List<List<Integer>> list;

    public static List<List<Integer>> permuteUnique(int[] nums) {
        list = new ArrayList<>();
        ArrayList<Integer> subList = new ArrayList<>();

        Set<List<Integer>> set = new HashSet<>();

        boolean[] visited = new boolean[nums.length];

        solve(nums, visited, set, subList);

        list = set.stream().distinct().collect(Collectors.toList());


        return list;
    }

    private static void solve(int[] arr, boolean[] visited, Set<List<Integer>> ansSet, List<Integer> subList) {
        if (subList.size() == arr.length) {
            ansSet.add(new ArrayList<>(subList));
            return;
        }

        for (int i = 0; i <= arr.length - 1; i++) {
            if(!visited[i]){
                subList.add(arr[i]);
                visited[i] = true;
                solve(arr, visited, ansSet, subList);
                visited[i] = false;
                subList.remove(subList.size()-1);
            }
        }
    }
}
