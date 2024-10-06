package com.cyberchickz.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Is_Anagram_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram1(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer num = mapS.get(c);
            if (num == null) {
                mapS.put(c, 0);
            } else {
                mapS.put(c, num + 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!mapS.containsKey(c)) {
                return false;
            } else {
                int num = mapS.get(c);
                if (num == 1) {
                    mapS.remove(c);
                } else {
                    mapS.put(c, num - 1);
                }
            }
        }
        System.out.println(
                mapS
        );
        return mapS.isEmpty();

    }
}
