class ListNode {
    int key, val;
    ListNode next;

    public ListNode(int key, int val, ListNode next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }

    public ListNode() {
        this(-1, -1, null);
    }
}

class MyHashMap {
    private ListNode[] map;
    public static final int BUCKET_SIZE = 1000;

    public MyHashMap() {
        map = new ListNode[BUCKET_SIZE];
        for (int i = 0; i < BUCKET_SIZE; i++) {
            map[i] = new ListNode();
        }
    }

    public void put(int key, int value) {
        int hashVal = key % BUCKET_SIZE;
        ListNode temp = map[hashVal].next;
        while (temp != null) {
            // Update existing key-value in hashmap
            if (temp.key == key) {
                temp.val = value;
                return;
            }
            temp = temp.next;
        }
        
        // Add new key-value at start of linked list
        ListNode dummy = map[hashVal];
        ListNode node = new ListNode(key, value, null);
        node.next = dummy.next;   // point new node at old first-real-node
        dummy.next = node;        // point dummy at new node
    }

    public int get(int key) {
        int hashVal = key % BUCKET_SIZE;
        ListNode temp = map[hashVal].next;
        while (temp != null) {
            if (temp.key == key) {
                return temp.val;
            }
            temp = temp.next;
        }
        return -1;
    }

    public void remove(int key) {
        int hashVal = key % BUCKET_SIZE;
        ListNode back = map[hashVal];
        ListNode front = back.next;
        while (front != null) {
            if (front.key == key) {
                back.next = front.next;
                front.next = null;
                return;
            }
            back = front;
            front = front.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */