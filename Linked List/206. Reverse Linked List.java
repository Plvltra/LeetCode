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
//      Recursively
//      public ListNode reverseList(ListNode head) {
//         if(head == null || head.next == null){
//             return head;
//         }
//         ListNode next = head.next;
//         ListNode ans = reverseList(next);
//         next.next = head;
//         head.next = null;
//         return ans;
//     }
    
    // Iteratively
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    
    // 头插法，构造一个不存在的头其next为null，依次将node插入之间
    // public ListNode reverseList(ListNode head) {
    // ListNode newHead = new ListNode(-1);
    // while (head != null) {
    //     ListNode next = head.next;
    //     head.next = newHead.next;
    //     newHead.next = head;
    //     head = next;
    // }
    // return newHead.next;
    // }
}