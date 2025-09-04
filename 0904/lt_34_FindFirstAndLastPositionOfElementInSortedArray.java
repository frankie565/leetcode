
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findBound(nums, target, true);
        int last = findBound(nums, target, false);
        return new int[]{first, last};
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1, result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                if (isFirst) {
                    right = mid - 1; // 繼續往左找
                } else {
                    left = mid + 1;  // 繼續往右找
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}

/*
解題思路：
1. 使用二分搜尋找 target 的第一次與最後一次出現位置。
2. 第一次出現：
   - 找到 target 後，繼續往左找直到沒有。
3. 最後一次出現：
   - 找到 target 後，繼續往右找直到沒有。
4. 若 target 不存在，返回 [-1, -1]。
5. 時間複雜度 O(log n)，空間複雜度 O(1)。
*/
