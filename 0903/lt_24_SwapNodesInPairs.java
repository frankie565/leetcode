// 題目：LeetCode 24. Swap Nodes in Pairs
// 給定一個鏈結串列，兩兩交換相鄰節點並返回頭節點。
// 不允許改變節點的值，只能改變節點之間的連結。
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = curr.next.next;

            // 交換節點
            first.next = second.next;
            second.next = first;
            curr.next = second;

            // 移動到下一組
            curr = first;
        }

        return dummy.next;
    }
}

/*
解題思路：
1. 使用虛擬頭節點 dummy 方便處理。
2. 每次取兩個相鄰節點 first 和 second，進行交換：
   - first.next 指向 second.next
   - second.next 指向 first
   - curr.next 指向 second
3. 將 curr 移動到 first，繼續處理下一組。
4. 時間複雜度 O(n)，空間複雜度 O(1)。
*/
