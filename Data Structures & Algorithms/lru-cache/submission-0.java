// Use a Doubly Linked List and HashMap
class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    int capacity;
    HashMap<Integer, Node> cache; 
    Node leastRecent;
    Node mostRecent;

    public LRUCache(int capacity) {
        // Create two ends, one end representing most recently used, other least recently used
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.leastRecent = new Node(0,0); // Left side
        this.mostRecent = new Node(0,0); // Right side
        this.leastRecent.next = this.mostRecent;
        this.mostRecent.prev = this.leastRecent;
    }
    
    public int get(int key) {
        // Search for node via hashmap -> O(1)
        // Then if exist, delete Node from its position and then add it to Most recently used end
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            shiftToMostRecent(node);
            return node.val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        // Check if exist -> If exist, update node val and shift to most recently used end
        // If dont exist -> Add new node at most recently used end
        if (cache.containsKey(key)) {
            // Remove from linkedlist
            remove(cache.get(key));
        }

        Node newNode = new Node(key, value);
        cache.put(key, newNode); // Overwrite or add new node
        shiftToMostRecent(newNode); // Shift to most recently used side

        // Check if cache is full
        if (cache.size() > capacity) {
            // Remove least recently used
            Node removedNode = leastRecent.next;
            cache.remove(removedNode.key); 
            remove(removedNode);
        }
    }

    // Helper functions
    public void remove(Node node) {
        Node prev = node.prev;
        Node front = node.next;
        prev.next = front;
        front.prev = prev;
    }

    public void shiftToMostRecent(Node node) {
        Node temp = mostRecent.prev;
        temp.next = node;
        node.prev = temp;
        node.next = mostRecent;
        mostRecent.prev = node;
    }
}
