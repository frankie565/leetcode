
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            // 左半邊有序
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // 右半邊有序
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}

/*
解題思路：
1. 使用二分搜尋，時間複雜度 O(log n)。
2. 判斷哪一半是有序的：
   - 若 nums[left] <= nums[mid]，則左半有序。
   - 否則右半有序。
3. 判斷 target 是否落在有序的一半：
   - 若在範圍內，縮小到該半區間。
   - 否則搜尋另一半。
4. 若找到則返回索引，否則返回 -1。
5. 時間複雜度 O(log n)，空間複雜度 O(1)。
*/
