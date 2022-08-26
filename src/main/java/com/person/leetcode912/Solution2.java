package com.person.leetcode912;

import java.util.Arrays;

public class Solution2 {

    private void mergeSort(int[] nums) {
    }

    public int[] sortArray(int[] nums) {
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 7, 10, 20, 15, 22, 18, 5, 30, 12, 3 };
        System.out.println("原始資料：" + Arrays.toString(nums));
        System.out.println("排序後：" + Arrays.toString(new Solution1().sortArray(nums)));
    }
}
