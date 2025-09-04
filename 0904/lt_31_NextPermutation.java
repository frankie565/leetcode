

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // 1. 找到第一個遞減的位置 i
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // 2. 從右側找到第一個大於 nums[i] 的數字 j
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // 3. 交換 nums[i], nums[j]
            swap(nums, i, j);
        }

        // 4. 翻轉 i 之後的部分
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }
}

/*
解題思路：
1. 從右往左找到第一個「降序點」i，表示需要從這裡開始調整。
2. 在 i 右側找到第一個比 nums[i] 大的元素 j，交換兩者。
3. 將 i 右側的子陣列翻轉，得到最小的遞增序列。
4. 若整個陣列是降序，直接翻轉為最小遞增序列。
5. 時間複雜度 O(n)，空間複雜度 O(1)。
*/
