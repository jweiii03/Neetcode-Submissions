class Node {
    int key;
    int value;
    Node next;

    public Node() {
        key = -1;
        value = -1;
        next = null;
    }

    public Node(int key, int value, Node next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}

class MyHashMap {
    public final int BUCKET_SIZE = 10001;
    public Node[] hm;
    
    public MyHashMap() {
        this.hm = new Node[BUCKET_SIZE];
        // Initialise a dummy node at each index 
        for (int i = 0; i < BUCKET_SIZE; i++) {
            this.hm[i] = new Node();
        }
    }

    public int getHash(int key) {
        return key % BUCKET_SIZE;
    }

    public void put(int key, int value) {
        int hashVal = getHash(key);
        Node dummy = hm[hashVal];
        // Check if value already exist
        Node temp = dummy.next;
        while (temp != null) {
            if (temp.key == key) {
                temp.value = value;
                return;
            }
            temp = temp.next;
        }

        // If cannot be found, insert at front of list in this bucket
        temp = dummy.next;
        Node newNode = new Node(key, value, temp);
        dummy.next = newNode;
    }
    
    public int get(int key) {
        int hashVal = getHash(key);
        Node dummy = hm[hashVal];
        // Check if value already exist
        Node temp = dummy.next;
        while (temp != null) {
            if (temp.key == key) {
                return temp.value;
            }
            temp = temp.next;
        }

        return -1;
    }
    
    public void remove(int key) {
        int hashVal = getHash(key);
        Node prev = hm[hashVal];
        // Check if value already exist
        Node front = prev.next;
        while (front != null) {
            if (front.key == key) {
                prev.next = front.next;
                front.next = null;
                return;      
            }
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