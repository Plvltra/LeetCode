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
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] ans = new ListNode[k];
        ListNode ptr = root;
        int count = 0;
        while(ptr != null){
            ptr = ptr.next;
            count++;
        }
        
        int mean = count / k;
        int rest = count % k;
        ListNode last = new ListNode(0, root);
        ListNode head = root;
        for(int i = 0; i < k; i++){
            ans[i] = head;
            int size = mean;
            if(rest > 0){
                rest--;
                size++;
            }
            
            while(size-- > 0){
                last = head;
                head = head.next;  
            } 
            last.next = null;
        }
        return ans;
    }
}