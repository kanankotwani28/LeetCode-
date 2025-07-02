public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // Find midpoint and split
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;  // split into [head...prev] and [slow...end]

        // Recursive sort
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        // Merge sorted halves
        return merge(left, right);
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0), tail = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) { tail.next = a; a = a.next; }
            else { tail.next = b; b = b.next; }
            tail = tail.next;
        }
        tail.next = (a != null) ? a : b;
        return dummy.next;
    }
}

