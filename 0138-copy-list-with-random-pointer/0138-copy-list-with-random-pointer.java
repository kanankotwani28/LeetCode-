/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Create clones and interleave them
        Node cur = head;
        while (cur != null) {
            Node clone = new Node(cur.val);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }

        // Step 2: Assign random pointers to clones
        cur = head;
        while (cur != null) {
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        // Step 3: Separate original and cloned lists
        cur = head;
        Node pseudoHead = head.next;
        while (cur != null) {
            Node clone = cur.next;
            cur.next = clone.next;
            clone.next = (clone.next != null ? clone.next.next : null);
            cur = cur.next;
        }

        return pseudoHead;
    }
}
