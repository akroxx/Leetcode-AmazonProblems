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
    public int pairSum(ListNode head) {
        
        //Find the middle of LL
        ListNode middle = findMidde(head);

        //Reverse second half of LL
        ListNode second = reverse(middle);

        int max = Integer.MIN_VALUE;
        while(head != null && second != null){
            max = Math.max(max, head.val + second.val);
            head = head.next;
            second = second.next;
        }

        return max;
    }

    public ListNode findMidde(ListNode head){
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        

        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
            // temp = null;
        }

        return prev;
    }
}