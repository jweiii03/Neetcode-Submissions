class MyHashSet {
    private static final int BUCKET_COUNT = 10000;

    private final ArrayList<LinkedList<Integer>> buckets;

    public MyHashSet() {
        buckets = new ArrayList<>(BUCKET_COUNT);

        // ArrayList capacity is not the same as its size.
        // We must explicitly insert every bucket.
        for (int i = 0; i < BUCKET_COUNT; i++) {
            buckets.add(new LinkedList<>());
        }
    }
    
    public void add(int key) {
        int hashVal = key % BUCKET_COUNT;
        LinkedList<Integer> bucket = buckets.get(hashVal);

        // A HashSet should not contain duplicate values.
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }
    
    public void remove(int key) {
        int hashVal = key % BUCKET_COUNT;
        LinkedList<Integer> bucket = buckets.get(hashVal);

        // LinkedList<Integer> overloads remove():
        // remove(int) treats the argument as an index, while remove(Object) removes a value.
        // Convert key to Integer to ensure the value is removed instead of the element at index key.
        if (bucket.contains(key)) {
            bucket.remove(Integer.valueOf(key));
        }
    }
    
    public boolean contains(int key) {
        int hashVal = key % BUCKET_COUNT;
        return buckets.get(hashVal).contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */