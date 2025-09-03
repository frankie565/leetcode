

class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}

/*
解題思路：
1. 使用雙指針：fast 遍歷整個陣列，slow 指向下一個有效位置。
2. 當 nums[fast] != val，將該元素移到 nums[slow]，並 slow++。
3. 遍歷完成後，slow 即為新陣列長度。
4. 時間複雜度 O(n)，空間複雜度 O(1)。
*/
