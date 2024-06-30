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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode currNode = head;
        ListNode nextNode = head.next;
        ListNode afterNode = nextNode.next;

        while(afterNode != null){
            nextNode.next = currNode;
            currNode = nextNode;
            nextNode = afterNode;
            afterNode = afterNode.next;
        }
        nextNode.next = currNode;
        head.next = null;
        head = nextNode;
        return head;
    }
}