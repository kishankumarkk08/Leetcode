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
    public int[] nextLargerNodes(ListNode head) {
        ArrayList <Integer> list = new ArrayList<>();
        ListNode slow = head;
        while(slow != null) {
            ListNode fast = slow.next;
            int nextGreater = 0;
            while(fast != null) {
                if(fast.val > slow.val) {
                    nextGreater = fast.val;
                    break;
                }
                fast = fast.next;
            }
            list.add(nextGreater);
            slow = slow.next;
        }

        int ans[] = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}