
class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (backtrack(board)) {
                                return true;
                            }
                            board[i][j] = '.'; // 回溯
                        }
                    }
                    return false; // 無法填入
                }
            }
        }
        return true; // 填滿成功
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int k = 0; k < 9; k++) {
            if (board[row][k] == c) return false; // 檢查列
            if (board[k][col] == c) return false; // 檢查行
            int r = (row / 3) * 3 + k / 3;
            int d = (col / 3) * 3 + k % 3;
            if (board[r][d] == c) return false;   // 檢查 3x3 小方格
        }
        return true;
    }
}

/*
解題思路：
1. 使用回溯法 (Backtracking)。
2. 遍歷棋盤：
   - 若遇到 '.' 嘗試填入數字 1~9。
   - 每次填入時檢查是否合法 (行、列、3x3 方格)。
3. 若當前選擇合法，遞迴繼續填下一格。
4. 若無法填入，回溯重試。
5. 當所有空格填滿，解決方案完成。
6. 時間複雜度最壞 O(9^(81))，但剪枝後實際遠小於此。
7. 空間複雜度 O(1)，因為只在原陣列操作。
*/
