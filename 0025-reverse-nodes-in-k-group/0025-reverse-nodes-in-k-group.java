/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head)
    {
        ListNode temp = head;
        ListNode prev = null;
        while(temp!=null)
        {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front ;
        }
        return prev;
    }

    public static ListNode getKth(ListNode temp , int k )
    {
        k-=1;
        while(temp!=null & k>0)
        {
            k--;
            temp = temp.next;
        }
        return temp;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = null;
        while(temp!=null)
        {
            ListNode kth = getKth(temp,k);
            if(kth == null)
            {
                if(prevLast!=null)
                {
                    prevLast.next = temp;
                }
                break;
            }
        ListNode nextNode = kth.next;
        kth.next = null;
        reverseList(temp);

        if(temp == head)
        {
            head = kth;
        }
        else
        {
            prevLast.next = kth;
        }
        prevLast = temp;
        temp = nextNode;
        }
        return head;
    }
}