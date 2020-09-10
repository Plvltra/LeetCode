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
    public ListNode swapPairs(ListNode head) {
//	Iterative
//         ListNode dummy = new ListNode();
//         ListNode end = dummy;
//         while(head != null && head.next != null) {
//             ListNode first = head;
//             ListNode second = head.next;
//             ListNode third = head.next.next;
//             end.next = second;
//             end.next.next = first;
            
//             end = first;
//             head = third;
//         }
//         end.next = head;
//         return dummy.next;

//	Recursive
//         if(head == null || head.next == null) {
//             return head;
//         }
//         ListNode second = head.next;
//         head.next = swapPairs(second.next);
//         second.next = head;
//         return second;


        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode end = dummy;
        while(end.next != null && end.next.next != null) {
            ListNode first = end.next;
            ListNode second = end.next.next;
            
            end.next = second;
            first.next = second.next;
            second.next = first;
            end = first;
        }
        return dummy.next;
    }
}