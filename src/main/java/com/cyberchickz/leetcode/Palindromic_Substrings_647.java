package com.cyberchickz.leetcode;

public class Palindromic_Substrings_647 {

    static public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public int countSubstrings_BruteForce(String s) {
        int length = s.length();
        int count = 0;

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (isPalindrome(s, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public int countSubstrings_Optimize(String s) {
        int length = s.length();
        int count = 0;
        boolean[][] palindrome = new boolean[length][length];

        for (int size = 1; size < length; size++) {
            for (int i = 0; i < length - size + 1; i++) {
                if (s.charAt(i) == s.charAt(i + size - 1) && (size < 3 || palindrome[i + 1][i + size - 2])) {
                    palindrome[i][i + size - 1] = true;
                    count++;
                }
            }
        }
        return count;
    }


    int length = 0;
    int count = 0;

    public int countSubstrings(String s) {
        length = s.length();

        for (int i = 0; i < length; i++) {
            i = countAndReturnNextIndex(s, i);
        }
        return count;
    }

    public int countAndReturnNextIndex(String s, int k) {

        int left = k - 1;
        int right = k;
        while (right < length - 1 && s.charAt(right) == s.charAt(right + 1)) {
            right++;
        }
        int countOfSameChar = right - left;
        if (countOfSameChar >= 1) {
            count += (countOfSameChar * (countOfSameChar + 1)) / 2;
        }
        int nextIndex = right++;
        while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return nextIndex;

    }
}
