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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cLeft = list1;
        ListNode cRight = list2;
        ListNode mergedHead = null;
        ListNode cMerged = null;
        while (cLeft != null || cRight != null) {
            int cVal;
            if((cLeft != null && cRight != null && cLeft.val < cRight.val) || cRight == null) {
                cVal = cLeft.val;
                cLeft = cLeft.next;
            } else {
                cVal = cRight.val;
                cRight = cRight.next;
            }
            System.out.println(cVal);
            if(cMerged == null)  {
                cMerged = new ListNode(cVal);
                mergedHead = cMerged;
            } else {
                cMerged.next = new ListNode(cVal);
                cMerged = cMerged.next;
            }
        }
        return mergedHead;
    }
}