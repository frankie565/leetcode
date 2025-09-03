// 題目：LeetCode 30. Substring with Concatenation of All Words
// 給定字串 s 和字串陣列 words，找出所有子字串的起始索引，
// 這些子字串恰好是 words 中所有單詞的串聯（順序不限）。

import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        Map<String, Integer> wordMap = new HashMap<>();
        for (String w : words) {
            wordMap.put(w, wordMap.getOrDefault(w, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            int left = i, count = 0;
            Map<String, Integer> seen = new HashMap<>();

            for (int right = i; right + wordLen <= s.length(); right += wordLen) {
                String word = s.substring(right, right + wordLen);

                if (wordMap.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;

                    while (seen.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    if (count == wordCount) {
                        res.add(left);
                    }
                } else {
                    seen.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return res;
    }
}

/*
解題思路：
1. 每個單詞長度相同，總長度 = words.length * wordLen。
2. 建立 wordMap 保存 words 的單詞頻率。
3. 使用滑動視窗：
   - 每次取 wordLen 長度的字串，檢查是否在 wordMap 中。
   - 若存在，加入 seen，若某單詞超出需求，縮小左邊界。
   - 若 count == words.length，說明找到一個解，記錄 left。
4. 若遇到不在 wordMap 的單詞，清空視窗並重置。
5. 時間複雜度 O(n * wordLen)，空間複雜度 O(words.length)。
*/
