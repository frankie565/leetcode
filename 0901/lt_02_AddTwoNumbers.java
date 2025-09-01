
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class lt_02_AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); 
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;

            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }

    
    public static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int v : arr) {
            curr.next = new ListNode(v);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();
    }

   
    public static void main(String[] args) {
        ListNode l1 = buildList(new int[]{2,4,3});
        ListNode l2 = buildList(new int[]{5,6,4});
        printList(addTwoNumbers(l1, l2)); 

        ListNode l3 = buildList(new int[]{0});
        ListNode l4 = buildList(new int[]{0});
        printList(addTwoNumbers(l3, l4)); 

        ListNode l5 = buildList(new int[]{9,9,9,9,9,9,9});
        ListNode l6 = buildList(new int[]{9,9,9,9});
        printList(addTwoNumbers(l5, l6)); 
    }
}
