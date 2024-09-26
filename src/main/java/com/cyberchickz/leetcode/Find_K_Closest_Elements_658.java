package com.cyberchickz.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Find_K_Closest_Elements_658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i = findIndex(arr, x);
        System.out.printf("findIndex i = %d\n", i);
        int left = i - 1;
        int right = i + 1;
        List<Integer> res = new ArrayList<>();

        res.add(arr[i]);
        k = k - 1;

        while (k > 0) {
            int leftDiff = left >= 0 ? Math.abs(arr[left] - x) : Integer.MAX_VALUE;
            int rightDiff = right < arr.length ? Math.abs(arr[right] - x) : Integer.MAX_VALUE;

            if (leftDiff <= rightDiff) {
                res.add(arr[left--]);
            } else {
                res.add(arr[right++]);
            }
            k--;
        }
        return res.stream().sorted().toList();
    }

    public int findIndex(int[] arr, int x) {
        int len = arr.length;
        int left = 0;
        int right = len - 1;

        if (arr[left] >= x) {
            return left;
        }

        if (arr[right] <= x) {
            return right;
        }

        while (right - left > 1) {
            int pivot = (left + right) / 2;
            if (arr[pivot] == x) {
                return pivot;
            } else if (arr[pivot] < x) {
                left = pivot;
            } else {
                right = pivot;
            }
        }
        return Math.abs(arr[left] - x) <= Math.abs(arr[right] - x) ? left : right;
    }

    public List<Integer> findClosestElements_Optimize(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (arr.length == 0 || k == 0) {
            return res;
        }
        int left = 0;
        int right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] <= arr[mid + k] - x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }

        return res;
    }
}

