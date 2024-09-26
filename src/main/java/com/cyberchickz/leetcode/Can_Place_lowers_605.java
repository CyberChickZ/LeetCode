package com.cyberchickz.leetcode;

public class Can_Place_lowers_605 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
//        System.out.println(solution.canPlaceFlowers(new int[]{0, 0, 1, 0, 1}, 1));
        System.out.println(solution.canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2));

    }
}

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int left = flowerbed[0] == 0 ? -1 : 0;
        int right = 0;
        int len = flowerbed.length;

        while (right < len) {
            if (flowerbed[right] == 1) {
                n = plantAndReturnVolume(left, right - 1, n);
                left = right + 1;
            } else {
                if (right + 1 == len) {
                    n = plantAndReturnVolume(left, right + 1, n);
                }
            }
            right++;
        }
        return n <= 0;
    }

    // @ * * * * * * * @
    public int plantAndReturnVolume(int left, int right, int n) {
        int zeros = (right - left + 1);
        if (zeros - 2 <= 0) {
            return n;
        } else {
            System.out.printf("         remain=%s\n\n", n - (zeros - 2) / 2);
            return n - (zeros - 1) / 2;
        }
    }
}