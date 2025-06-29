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
    public ListNode findNode(ListNode temp, int k)
    {
        int cnt = 1 ;
        while(temp!=null)
        {
            if(cnt == k)
                return temp;
            cnt++;
            temp = temp.next;
        }
        return temp;
    }
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || k==0)
            return head;
        ListNode tail = head ;
        int len = 1;
        while(tail.next!=null)
        {
            len++;
            tail = tail.next;
        }
        if(k%len == 0)
            return head;
        
        k = k%len;
        tail.next = head;
        ListNode nthNode = findNode(head,len-k);
        head =  nthNode.next;
        nthNode.next = null;
          return head;
    }
}