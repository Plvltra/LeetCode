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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode oddtail = head;
        ListNode evenhead = head.next;
        ListNode eventail = evenhead;
        while(eventail != null && eventail.next != null){
            ListNode next1 = eventail.next;
            ListNode next2 = eventail.next.next;
            oddtail.next = next1;
            eventail.next = next2;
            oddtail = next1;
            eventail = next2;
        }
        oddtail.next = evenhead;
        return head;
    }
}