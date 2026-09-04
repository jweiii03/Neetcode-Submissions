/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // Two passes, first to create the nodes and populate hashmap
        // Key is oldNode, Value is copied Node
        HashMap<Node, Node> oldToCopy = new HashMap<>();
        // Handle edge case of null mapping
        oldToCopy.put(null, null);

        //First pass
        Node temp = head;
        while (temp != null) {
            Node copyNode = new Node(temp.val);
            oldToCopy.put(temp, copyNode);
            temp = temp.next;
        }

        // Second pass, initialise next and random pointers
        temp = head;
        while (temp != null) {
            Node copiedNode = oldToCopy.get(temp);
            copiedNode.next = oldToCopy.get(temp.next);
            copiedNode.random = oldToCopy.get(temp.random);
            temp = temp.next;
        }

        return oldToCopy.get(head);
    }
}
