public class SeparateChainingHashST<Key, Value> {
    private int n; // number of key-value pair
    private int m; // size of hash table
    private static final int DEFAULT_SIZE = 4;
    private SequentialSearchST<Key, Value>[] st;
    public SeparateChainingHashST() {
       this(DEFAULT_SIZE); 
    }
    public SeparateChainingHashST(int m) {
        this.m = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }
    public int size() {
        return n;
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    } 
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("first argument to get() is null");
        int i = hash(key);
        return st[i].get(key);
    }
    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (value == null) {
            delete(key);
            return;
        }
        int i = hash(key);
        System.out.println("hash code:"+i);
        if (!st[i].contains(key)) n++;
        st[i].put(key, value);
    }
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");

        int i = hash(key);
        if (st[i].contains(key)) n--;
        st[i].delete(key);
    } 
    public static void main(String args[]) {
        SeparateChainingHashST<String, String> hashTable = new SeparateChainingHashST<String, String>();
        hashTable.put("item1", "java");
        String item1 = hashTable.get("item1");
        int size = hashTable.size();
        System.out.println("size:"+size);
        System.out.println("item:"+item1);
    }
}