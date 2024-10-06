package com.cyberchickz.leetcode;

public class Shortest_Unsorted_Continuous_Subarray_581 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int min = nums[n - 1];
        int max = nums[0];

        int start = -1;
        int end = -2;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - 1 - i]);

            if (nums[i] > max) {
                end = i;
            }

            if (nums[n - 1 - i] < min) {
                start = n - 1 - i;
            }
        }
        return end - start + 1;
    }
}
