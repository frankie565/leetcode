// 題目：LeetCode 23. Merge k Sorted Lists
// 給定一個由 k 條已排序鏈結串列組成的陣列 lists，將所有串列合併成一個排序好的鏈結串列並返回。

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // 初始化：將每個串列的頭節點放入最小堆
        for (ListNode node : lists) {
            if (node != null) pq.offer(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }
}

/*
解題思路：
1. 使用最小堆 (PriorityQueue) 儲存 k 條鏈表的當前節點。
2. 每次從堆中取出最小節點，接到結果鏈表後，若該節點有下一個節點則放回堆中。
3. 重複直到堆為空。
4. 時間複雜度 O(N log k)，N 為所有節點總數，k 為串列數。
5. 空間複雜度 O(k)，因為堆中最多存 k 個節點。
*/
