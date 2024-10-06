package com.cyberchickz.leetcode;

import java.util.*;

public class Anagram_Groups_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ansMap = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (ansMap.containsKey(key)) {
                ansMap.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                ansMap.put(key, list);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : ansMap.entrySet()) {
            ans.add(new ArrayList<>(entry.getValue()));
        }
        return ans;
    }
}
