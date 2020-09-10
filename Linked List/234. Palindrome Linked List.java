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
    public boolean isPalindrome(ListNode head) {
        int count = 0;
        ListNode ptr = head;
        while(ptr != null) {
            count++;
            ptr = ptr.next;
        }
        
        int half = count/2;
        ListNode pivot = head;
        while(half-- != 0) {
            pivot = pivot.next;
        }
        ListNode back = reverse(pivot);
        
        while(back != null){
            if(head.val != back.val){
                return false;
            }
            head = head.next;
            back = back.next;
        }
        return true;
    }
    
//     public boolean isPalindrome(ListNode head) {
//         ListNode fast = head;
//         ListNode slow = head;
//         while(fast != null && fast.next != null) {
//             fast = fast.next.next;
//             slow = slow.next;
//         }
//         slow = reverse(slow);
//         fast = head;
        
//         while(slow != null){
//             if(fast.val != slow.val){
//                 return false;
//             }
//             fast = fast.next;
//             slow = slow.next;
//         }
//         return true;
//     }
    
    private ListNode reverse(ListNode head){
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
    
}