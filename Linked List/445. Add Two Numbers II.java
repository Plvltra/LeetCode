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
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         Stack<Integer> s1 = new Stack<>();
//         while(l1 != null) {
//             s1.push(l1.val);
//             l1 = l1.next;
//         }
//         Stack<Integer> s2 = new Stack<>();
//         while(l2 != null) {
//             s2.push(l2.val);
//             l2 = l2.next;
//         }
        
//         ListNode head = null;
//         int carry = 0;
//         while(!s1.empty() || !s2.empty() || carry != 0) {
//             int val1 = (s1.empty())? 0 : s1.pop();
//             int val2 = (s2.empty())? 0 : s2.pop();
//             int sum = val1 + val2 + carry;
//             ListNode newhead = new ListNode(sum % 10);
//             newhead.next = head;
            
//             carry = sum / 10;
//             head = newhead;
//         }
//         return head;
//     }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode l3 = new ListNode();
        ListNode tail = l3;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 == null)? 0 : l1.val;
            int val2 = (l2 == null)? 0 : l2.val;
            int sum = val1 + val2 + carry;
            tail.next = new ListNode(sum % 10);
            
            carry = sum / 10;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            tail = tail.next;
        }
        return reverse(l3.next);
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}