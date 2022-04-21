package com.person.leetcode78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {

    /**
     * 78. Subsets
     * Given an integer array nums of unique elements, return all possible subsets (the power set).
     * The solution set must not contain duplicate subsets. Return the solution in any order.
     *
     * Constraints：
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     * All the numbers of nums are unique.
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int totalSet = (int) Math.pow(2, nums.length);

        for (int i = 0; i < totalSet; i++) {
            int sum = i;
            List<Integer> set = new ArrayList<>();

            for (int j = nums.length - 1; j >= 0; j--) {
                int pow = (int) Math.pow(2, j);

                if (sum - pow >= 0) {
                    sum -= pow;
                    set.add(nums[j]);
                }
            }

            result.add(set);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        int[] nums = new int[] { 1, 2, 3 };
        List<List<Integer>> result = solution.subsets(nums);

        result.forEach(sub -> {
            System.out.println(Arrays.toString(sub.toArray()));
        });
    }
}
