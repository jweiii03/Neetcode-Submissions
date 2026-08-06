class Node {
    int key, val;
    Node next;

    public Node(int key, int val, Node next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }

    public Node() {
        this.key = -1;
        this.val = -1;
        this.next = null;
    }
}

class MyHashMap {
    public Node[] buckets;
    public static final int BUCKET_SIZE = 10000;

    public MyHashMap() {
        this.buckets = new Node[10000];
        for (int i = 0; i < BUCKET_SIZE; i++) {
            buckets[i] = new Node();
        }
    }

    public int hash(int key) {
        return key % BUCKET_SIZE;
    }
    
    public void put(int key, int value) {
        int hashedVal = hash(key);
        Node currNode = buckets[hashedVal];
        while (currNode != null) {
            if (currNode.key == key) {
                currNode.val = value;
                return;
            }
            currNode = currNode.next;
        }

        // Else add at the front
        Node temp = buckets[hashedVal];
        Node newNode = new Node(key, value, null);
        newNode.next = temp.next;
        temp.next = newNode;
    }
    
    public int get(int key) {
        int hashedVal = hash(key);
        Node temp = buckets[hashedVal];
        while (temp != null) {
            if (temp.key == key) {
                return temp.val;
            }
            temp = temp.next;
        }

        return -1;
    }
    
    public void remove(int key) {
        int hashedVal = hash(key);
        Node back = buckets[hashedVal];
        Node front = back.next;
        while (front != null) {
            if (front.key == key) {
                back.next = front.next;
                front.next = null;
                return;
            }
            back = front;
            front = front.next;
        }
        return;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */