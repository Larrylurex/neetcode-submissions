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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode s = new ListNode(0);
        ListNode cs = s;
        int carryOver = 0;
        while(l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + carryOver;
            cs.next = new ListNode(sum % 10);
            carryOver = sum / 10;
            cs = cs.next;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if(carryOver != 0) {
           cs.next =  new ListNode(carryOver);
        }
        
        return s.next;
    }
}
