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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length  == 0) return null;
        if(lists.length == 1) return lists[0];

        ListNode list = lists[0];
        for(int i = 1; i < lists.length; i++) {
            list = merge(list, lists[i]);
        }
        return list;
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode c = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                c.next = l1;
                l1 = l1.next;
            } else {
                c.next = l2;
                l2 = l2.next;
            }
            c = c.next;
        }
        if(l1 != null) {
            c.next = l1;
        } else if( l2 != null) {
            c.next = l2;
        }
        return dummy.next;
    }
}
