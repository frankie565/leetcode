// 題目：LeetCode 29. Divide Two Integers
// 給定兩個整數 dividend 和 divisor，實現整數除法，不可使用乘法、除法與 mod 運算。
// 若結果超過 32 位元整數範圍，則回傳 INT_MAX (2^31 - 1)。

class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // 避免溢出
        }

        // 判斷結果正負號
        boolean negative = (dividend < 0) ^ (divisor < 0);

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int result = 0;

        while (a >= b) {
            long temp = b, multiple = 1;
            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            a -= temp;
            result += multiple;
        }

        return negative ? -result : result;
    }
}

/*
解題思路：
1. 特判：若 dividend = INT_MIN 且 divisor = -1，會溢出，回傳 INT_MAX。
2. 使用位運算加速：
   - 每次將 divisor 乘 2 (左移) 找到最大能減去的倍數。
   - 減去後累加倍數，直到 dividend < divisor。
3. 判斷結果正負號，最後回傳。
4. 時間複雜度 O(log n)，因為每次倍增 divisor。
5. 空間複雜度 O(1)。
*/
