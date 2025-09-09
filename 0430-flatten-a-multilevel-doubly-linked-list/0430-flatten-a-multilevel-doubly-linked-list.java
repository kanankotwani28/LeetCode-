/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {

        if(head == null)
        {
            return null;
        }

        flattenRec(head);
        return head;
    }

    public Node flattenRec(Node head)
    {
        Node cur = head;
        Node last = null;
        while(cur!= null)
        {
            Node next = cur.next;
            if(cur.child != null)
            {
                Node chead = cur.child;
                Node tail = flattenRec(cur.child);
                cur.next = chead;
                chead.prev = cur;
                if(next!=null)
                {
                    tail.next = next;
                    next.prev = tail;
                }
                cur.child = null;
                last = tail;   
                cur = next;
            }

            else
            {
                last = cur;
                cur = next;
            }
        }
        return last;
    }
}