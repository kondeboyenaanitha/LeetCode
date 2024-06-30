/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        Node newHead = new Node(-1);
        newHead.next = head;

        dfs(newHead, head);
        head.prev = null;

        return head;
    }
    
    // return the bottom element
    private Node dfs(Node prev, Node curr) {
        if (curr == null) {
            return prev;
        }
        prev.next = curr;
        curr.prev = prev;

        Node n = curr.next;
        prev = curr;

        if (curr.child != null) {
            Node next = curr.child;
            curr.child = null;

            prev = dfs(curr, next);
        }
        return dfs(prev, n);
    }
}