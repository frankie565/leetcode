

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start,
                           List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, path, res); // 可重複使用
            path.remove(path.size() - 1);
        }
    }
}

/*
解題思路：
1. 使用回溯 (Backtracking)。
2. 每次從 candidates[start..end] 嘗試選取數字。
3. 若 target 減至 0，代表找到合法組合，加入結果。
4. 若 target < 0，代表不合法，直接返回。
5. 因為允許數字重複使用，所以遞迴呼叫時仍傳 i，而不是 i+1。
6. 時間複雜度：O(T)，其中 T 為解空間大小。
7. 空間複雜度：O(target)，主要來自遞迴深度與暫存路徑。
*/
