/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;

        int counter = 0;
        while (curr != null && counter < left - 1) {
            prev = curr;
            curr = curr.next;
            counter++;
        }

        ListNode last = prev;
        ListNode newEnd = curr;

        int i = 0;
        int n = (right - left) + 1;
        ListNode next = curr.next;
        while (curr != null && i < n) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
            i++;
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = curr;

        return head;
    }

}