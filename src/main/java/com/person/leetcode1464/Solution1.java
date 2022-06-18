package com.person.leetcode1464;

public class Solution1 {

    public int maxProduct(int[] nums) {
        int result = 1;

        for (int i = 1; i <= 2; i++) {
            int endIndex = nums.length - i;
            this.createMaxHeapTree(nums, 0, endIndex);
            this.swap(nums, 0, endIndex);
            result *= (nums[endIndex] - 1);
        }

        return result;
    }

    private void createMaxHeapTree(int[] nums, int beginIndex, int endIndex) {
        for (int i = endIndex; i > beginIndex; i--) {
            boolean even = i % 2 == 0;
            int parentIndex = even ? (i - 2) / 2 : (i - 1) / 2;

            if (nums[parentIndex] < nums[i]) {
                this.swap(nums, parentIndex, i);
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 3, 4, 5, 2 };
        System.out.println(new Solution1().maxProduct(nums));
    }
}
