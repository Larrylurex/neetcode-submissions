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
    public boolean hasCycle(ListNode head) {
        ListNode cNode = head;
        while(cNode != null) {
            if(cNode.val == Integer.MAX_VALUE) {
                return true;
            } 
            cNode.val = Integer.MAX_VALUE;
            cNode = cNode.next;
        }
        return false;
    }
}
