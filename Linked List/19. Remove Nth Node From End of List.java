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
//     two pass
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         ListNode dummy = new ListNode(0, head);
//         int count = 0;
//         ListNode ptr = dummy;
//         while(ptr != null) {
//             ptr = ptr.next;
//             count++;
//         }
        
//         n = count - n - 1;
//         ptr = dummy;
//         while(n-- != 0) {
//             ptr = ptr.next;
//         }
//         ptr.next = ptr.next.next;
//         return dummy.next;
//     }

    // one pass, maintain a N+1 gap from beginner
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode second = head;
        while(n-- > 0){
            second = second.next;
        }
        ListNode first = dummy;
        
        while(second != null){
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }
}