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
    public void reorderList(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode secondHalf = slow.next;
        slow.next = null;

        
        ListNode prev = null;
        ListNode cur = secondHalf;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        // 2 4 6 8 10
        // 2 -> 4 -> 6 : 10 -> 8
        // 2 -> 10 -> 4
        cur = head;
        ListNode curRev = prev;
        while(cur != null && curRev != null) {
            ListNode cNext = cur.next; // 4 -> 6
            cur.next = curRev; // 2 -> 10 -> 8

            ListNode curRevNext = curRev.next; // 8 -> null
            curRev.next = cNext; // 

            cur = cNext;
            curRev = curRevNext;

        }
    }
}
