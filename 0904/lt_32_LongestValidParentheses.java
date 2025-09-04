

import java.util.*;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // 初始基準點
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i); // 重設基準點
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }
}

/*
解題思路：
1. 使用 stack 紀錄索引，初始先壓入 -1 當基準點。
2. 遍歷字串：
   - 遇到 '(' → 壓入索引。
   - 遇到 ')' → 彈出一個索引：
       - 若 stack 為空，壓入當前索引作為新的基準點。
       - 否則計算當前長度 i - stack.peek() 更新最大值。
3. 結束後 maxLen 即為最長有效括號長度。
4. 時間複雜度 O(n)，空間複雜度 O(n)。
*/
