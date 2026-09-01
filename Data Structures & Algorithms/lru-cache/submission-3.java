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
    Node leastRecentEnd;
    Node mostRecentEnd;
    int capacity;
    HashMap<Integer, Node> cache; // For O(1) access of nodes

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        leastRecentEnd = new Node(0,0); // right most
        mostRecentEnd = new Node(0,0); // left most
        mostRecentEnd.next = leastRecentEnd;
        leastRecentEnd.prev = mostRecentEnd;
    }

    public int get(int key) {
        // Access hashmap if got key, if dont have return -1
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node curr = cache.get(key);
        deleteNode(curr);
        insertNodeAtMostRecent(curr);
        return curr.val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node curr = cache.get(key);
            deleteNode(curr);
            cache.remove(key);
        }

        Node newNode = new Node(key, value);
        insertNodeAtMostRecent(newNode);
        cache.put(key, newNode);
        // Check if exceed capacity;
        if (cache.size() > capacity) {
            Node leastRecent = leastRecentEnd.prev;
            cache.remove(leastRecent.key);
            deleteNode(leastRecent);
        }  
    }

    public void deleteNode(Node node) {
        Node temp = node.prev;
        temp.next = node.next;
        node.next.prev = temp;
        node.next = null;
        node.prev = null;
    }

    public void insertNodeAtMostRecent(Node node) {
        Node temp = mostRecentEnd.next;
        mostRecentEnd.next = node;
        node.prev = mostRecentEnd;
        temp.prev = node;
        node.next = temp;
    }
}

