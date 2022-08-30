package com.person.leetcode912;

import java.util.Arrays;

public class Solution2 {

    private int[] merge(int[] left, int[] right, int[] result) {
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

        return result;
    }

    private void mergeSort(int[] nums) {
        int[] temp = new int[nums.length];

        for (int n = 1; n < nums.length; n *= 2) {
            int endIndex = nums.length - n;
            for (int i = 0; i < endIndex; i += 2 * n) {
                int leftStartIndex = i;
                int leftEndIndex = leftStartIndex + n;
                int rightStartIndex = leftEndIndex;
                int rightEndIndex = Integer.min(rightStartIndex + n, nums.length);

                int[] left = Arrays.copyOfRange(nums, leftStartIndex, leftEndIndex);
                int[] right = Arrays.copyOfRange(nums, rightStartIndex, rightEndIndex);
                merge(left, right, temp);

                System.out.println(String.format("Left (%d, %d) : %s", leftStartIndex, leftEndIndex, Arrays.toString(left)));
                System.out.println(String.format("right (%d, %d) : %s", rightStartIndex, rightEndIndex, Arrays.toString(right)));
                System.out.println(String.format("right (%d, %d) : %s\n", leftStartIndex, rightEndIndex, Arrays.toString(temp)));

                for (int j = leftStartIndex; j < rightEndIndex; j++)
                    nums[j] = temp[j - leftStartIndex];
            }
        }
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums);
        return nums;
    }

    public static void main(String[] args) {
//        int[] nums = { 7, 10, 20, 15, 22, 18, 5, 30, 12, 3 };
        int[] nums = { 7, 10, 20, 15, 22, 18, 5 };
        System.out.println("原始資料：" + Arrays.toString(nums));
        System.out.println("排序後：" + Arrays.toString(new Solution2().sortArray(nums)));
    }
}
