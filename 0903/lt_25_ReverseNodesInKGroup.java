// 題目：LeetCode 25. Reverse Nodes in k-Group
// 給定一個鏈結串列，每 k 個節點為一組進行反轉，返回修改後的鏈結串列。
// 若最後一組節點不足 k 個，則保持原樣。
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroup = dummy;

        while (true) {
            ListNode kth = getKth(prevGroup, k);
            if (kth == null) break;

            ListNode nextGroup = kth.next;

            // 反轉 k 個節點
            ListNode prev = kth.next;
            ListNode curr = prevGroup.next;

            while (curr != nextGroup) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            // 接回鏈表
            ListNode tmp = prevGroup.next;
            prevGroup.next = kth;
            prevGroup = tmp;
        }

        return dummy.next;
    }

    // 找到從 node 開始的第 k 個節點，若不足 k 個則回傳 null
    private ListNode getKth(ListNode node, int k) {
        while (node != null && k > 0) {
            node = node.next;
            k--;
        }
        return node;
    }
}

/*
解題思路：
1. 使用 dummy 節點方便處理頭部反轉。
2. 每次檢查是否存在 k 個節點，若不足則結束。
3. 若有 k 個節點，進行反轉：
   - 使用 prev, curr 指標逐一翻轉節點。
   - 翻轉完成後將子串鏈接回原串列。
4. 更新 prevGroup 指向下一組起始節點，繼續處理。
5. 時間複雜度 O(n)，每個節點僅被反轉一次。
6. 空間複雜度 O(1)。
*/
