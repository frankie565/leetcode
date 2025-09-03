// 題目：LeetCode 21. Merge Two Sorted Lists
// 給定兩個已排序的鏈結串列 list1 和 list2，合併成一個新的排序鏈結串列，並返回其頭節點。
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        // 其中一個串列還有剩餘節點，直接接上
        if (list1 != null) curr.next = list1;
        if (list2 != null) curr.next = list2;

        return dummy.next;
    }
}

/*
解題思路：
1. 使用虛擬頭節點 dummy 方便處理。
2. 同時遍歷 list1 和 list2，每次挑選較小的節點接到結果串列。
3. 若其中一個串列走完，將另一個剩餘部分直接接上。
4. 回傳 dummy.next 即為合併後的頭節點。
5. 時間複雜度 O(m+n)，空間複雜度 O(1)。
*/
