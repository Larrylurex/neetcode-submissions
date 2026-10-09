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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode preSlow = null;
        ListNode fast = head;
        int i = 0;

        // 1 2 | 2        
        while(fast != null) { // f = 2
            fast = fast.next; // f = null
            if(i >= n) { //1 >= 2  
                preSlow = slow; 
                slow = slow.next; 
            }
            i++; // i = 1
        }

        if(preSlow != null) {
            preSlow.next = slow.next;
            return head;
        } else {
            return slow.next;
        }
        
    }
}
