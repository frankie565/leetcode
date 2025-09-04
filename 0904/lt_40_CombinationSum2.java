
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // 先排序，方便去重
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
            // 去重：同一層遞迴不能選相同的數字
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, path, res); // 下一層從 i+1 開始，避免重複使用
            path.remove(path.size() - 1);
        }
    }
}

/*
解題思路：
1. 與 Combination Sum I 不同，這裡每個數字只能使用一次。
2. 先排序，確保相同數字會連在一起，方便去重。
3. 回溯時，如果 i > start 且 candidates[i] == candidates[i-1]，則跳過，避免重複組合。
4. 每次遞迴呼叫 backtrack 時，index 從 i+1 開始，避免數字被重複使用。
5. 時間複雜度：O(2^n)，因為需要遍歷所有可能子集。
6. 空間複雜度：O(n)，主要來自遞迴深度。
*/
