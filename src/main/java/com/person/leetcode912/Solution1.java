package com.person.leetcode912;

import java.util.Arrays;

public class Solution1 {

    private void merge(int[] left, int[] right, int[] result) {
        int leftIdx = 0, rightIdx = 0, resultIdx = 0;

        while (leftIdx < left.length && rightIdx < right.length) {
            if (left[leftIdx] <= right[rightIdx]) {
                result[resultIdx++] = left[leftIdx++];
            } else {
                result[resultIdx++] = right[rightIdx++];
            }
        }

        while (leftIdx < left.length)
            result[resultIdx++] = left[leftIdx++];

        while (rightIdx < right.length)
            result[resultIdx++] = right[rightIdx++];

    }

    private void mergeSort(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return;
        }

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = nums[i];
        }

        for (int i = mid; i < n; i++) {
            right[i - mid] = nums[i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(left, right, nums);
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums);
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 7, 10, 20, 15, 22, 18, 5, 30, 12, 3 };
        System.out.println("原始資料：" + Arrays.toString(nums));
        System.out.println("排序後：" + Arrays.toString(new Solution1().sortArray(nums)));
    }
}
