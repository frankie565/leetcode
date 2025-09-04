
import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    if (!seen.add(num + " in row " + i) ||
                        !seen.add(num + " in col " + j) ||
                        !seen.add(num + " in box " + (i / 3) + "-" + (j / 3))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

/*
解題思路：
1. 數獨規則：
   - 每一行數字 1-9 不可重複。
   - 每一列數字 1-9 不可重複。
   - 每一個 3x3 小方格數字 1-9 不可重複。
2. 使用 HashSet 儲存：
   - "5 in row 0"
   - "5 in col 8"
   - "5 in box 0-2"
   若有重複，直接返回 false。
3. 遍歷整個 9x9 棋盤，驗證所有非 '.' 的格子。
4. 時間複雜度 O(81) ≈ O(1)，空間複雜度 O(81) ≈ O(1)。
*/
