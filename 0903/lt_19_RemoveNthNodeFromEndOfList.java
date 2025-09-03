// 題目：LeetCode 19. Remove Nth Node From End of List

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy, slow = dummy;

        // fast 先走 n+1 步
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next; // 刪除節點
        return dummy.next;
    }
}

/*
解題思路：
1. 使用快慢指針，fast 先走 n+1 步。
2. fast 與 slow 一起走，直到 fast 到尾端。
3. 此時 slow 在刪除節點的前一個位置，調整指標完成刪除。
4. 時間複雜度 O(n)，空間複雜度 O(1)。
*/

