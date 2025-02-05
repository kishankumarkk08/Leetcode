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
    public int numComponents(ListNode head, int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int value : nums) {
            list.add(value);
        }
        ListNode temp = head;
        int count = 0;
        while(temp != null) {
            if(list.contains(temp.val) && (temp.next == null || !list.contains(temp.next.val)) ) count++;
            temp = temp.next;
        }
        return count;
    }
}