

class Solution {
    public String countAndSay(int n) {
        String result = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char prev = result.charAt(0);

            for (int j = 1; j < result.length(); j++) {
                char c = result.charAt(j);
                if (c == prev) {
                    count++;
                } else {
                    sb.append(count).append(prev);
                    count = 1;
                    prev = c;
                }
            }
            sb.append(count).append(prev);
            result = sb.toString();
        }

        return result;
    }
}

/*
解題思路：
1. 基本規則：
   - n=1 時，序列為 "1"。
   - n=2 時，讀出前一項 "1" → "11" (一個 1)。
   - n=3 時，讀出 "11" → "21" (兩個 1)。
   - n=4 時，讀出 "21" → "1211" (一個 2，一個 1)。
2. 使用迴圈逐層生成序列。
3. 對前一項字串做 Run-Length Encoding (連續字符壓縮描述)。
4. 時間複雜度 O(n * m)，其中 m 為字串長度，空間複雜度 O(m)。
*/
