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

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy; // dummy

        while (true) {

            ListNode kth = getKth(groupPrev, k); // 3
            if (kth == null) return dummy.next;

            ListNode groupNext = kth.next; // 4 5 6

            ListNode prev = groupNext; // 4 5 6
            ListNode c = groupPrev.next; // 1 2 3
            while(c != groupNext) {
                ListNode tmp = c.next; // 4
                c.next = prev; // 3-> 2 -> 1 -> 4 -> 5 -> 6
                prev = c; // 3 -> 2 -> 1 -> 4 -> 5 -> 6
                c = tmp; //  4 -> 5 -> 6
            }

            ListNode tmp = groupPrev.next; // dummy -> (1 -> 4 -> 5 -> 6)
            groupPrev.next = kth; // dummy -> 3 -> 2 -> 1 -> 4 -> 5 -> 6
            groupPrev = tmp; // 1
        }
    }


    private ListNode getKth(ListNode curr, int k) {
        ListNode c = curr;
        while (k > 0) {
            if (c == null) return null;
            c = c.next;
            k--;
        }
        return c;
    }
}
