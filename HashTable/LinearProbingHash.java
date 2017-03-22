class LinearProbingHash<Key, Value> {
    private static final int HASH_DEFAULT_SIZE = 10;
    int n; // number of data in table
    int m; // size of hash table
    Key[] keys;
    Value[] vals;
    public LinearProbingHash() {
        this(HASH_DEFAULT_SIZE);
    }
    public LinearProbingHash(int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[]) new Object[m];
        vals = (Value[]) new Object[m];
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
    private void resize(int size) {
        LinearProbingHash<Key, Value> temp = new LinearProbingHash<Key, Value>(size);
        for (int i=0; i < m; i++) {
            if(keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m = temp.m;
    }
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains is null");
        return get(key) != null;
    }
    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("key in argument is null(get)");
        if (value == null) {
            delete(key);
            return;
        }
        if ( n >= m/2) resize(2*m);

        int i;
        for (i = hash(key); keys[i] != null; i = (i+1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = value;
                return;
            }
        }
        keys[i] = key;
        vals[i] = value;
        n++;
    }
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get is null");
        for(int i = hash(key); keys[i] != null; i = (i+1) % m) {
            if(keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete is null");
        if(!contains(key)) return;

        int i = hash(key);
        while(!key.equals(keys[i])) {
            i = (i+1) % m;
        }
        keys[i] = null;
        vals[i] = null;

        // rehash allKeys
        i = (i+1) % m;
        while (keys[i] != null) {
            Key keyRehash = keys[i];
            Value valRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            n--;
            put(keyRehash, valRehash);
            i = (i+1) % m;
        }
        n--;

        // halves size of array if 1/8 full or less
        if (n > 0 && n <= m/8) resize(m/2);
    }
    public static void main(String args[]) {
        LinearProbingHash<String, String> hashTable = new LinearProbingHash<String, String>(2);
        hashTable.put("demo","karan");
        hashTable.put("dafemo","af");
        hashTable.put("af","fww");
        hashTable.put("afww","kaafran");
        hashTable.delete("demo");
        String demoData = hashTable.get("demo");
        String demoData2 = hashTable.get("dafemo");
        String demoData3 = hashTable.get("afww");
        System.out.println("data:"+demoData+", "+demoData2+", "+demoData3);
    }
}