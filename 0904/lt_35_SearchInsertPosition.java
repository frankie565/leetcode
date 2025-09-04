


class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left; // 插入位置
    }
}

/*
解題思路：
1. 使用二分搜尋，找到目標值或其應插入位置。
2. 若 nums[mid] == target → 回傳 mid。
3. 若 nums[mid] < target → 搜尋右半邊。
4. 若 nums[mid] > target → 搜尋左半邊。
5. 若未找到，left 即為插入位置。
6. 時間複雜度 O(log n)，空間複雜度 O(1)。
*/
