// 題目：LeetCode 28. Find the Index of the First Occurrence in a String (strStr)
// 給定字串 haystack 和 needle，返回 needle 在 haystack 中第一次出現的索引，若不存在則返回 -1。

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        if (n == 0) return 0;

        for (int i = 0; i <= m - n; i++) {
            if (haystack.substring(i, i + n).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}

/*
解題思路：
1. 遍歷 haystack，每次取長度為 needle.length 的子字串。
2. 若子字串等於 needle，返回當前索引 i。
3. 若遍歷結束仍無匹配，返回 -1。
4. 時間複雜度 O((m-n+1) * n)，最壞情況下等於 O(m*n)。
5. 空間複雜度 O(1)。
*/
