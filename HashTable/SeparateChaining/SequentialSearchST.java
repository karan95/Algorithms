public class SequentialSearchST<Key, Value> {
    int n;
    private Node first;
    SequentialSearchST() {}
    private class Node {
        private Key key;
        private Value value;
        private Node next;
        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    public int size() {
        return n;
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }
    public void put(Key key, Value value) {
        if (key == null) System.out.println("key is null(put)");
        if (value == null) {
            delete(key);
            return;
        }
        for (Node k = first; k != null; k = k.next) {
            if (key.equals(k.key)) {
                k.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
        n++;
    }
    public Value get(Key key) {
        if (key == null) System.out.println("key is null(get)");
        for (Node k = first; k != null; k = k.next) {
            if (key.equals(k.key)) {
                return k.value;
            }
        }
        return null;
    }
    public void delete(Key key) {
        if (key == null) System.out.println("Key is null(delete)");
        first = delete(first, key);
    }
    private Node delete(Node x, Key key) {
        if(x == null) return null;
        if(key.equals(x.key)) {
            n--;
            return x.next;  
        }
        x.next = delete(x.next, key);
        return x;
    }
    public static void main(String args[]) {
        SequentialSearchST<String, String> hashTable = new SequentialSearchST<String, String>();
        hashTable.put("item1","js");
        hashTable.put("item2","ts");
        hashTable.put("item3","java");
        hashTable.put("item4","html");
        String item1 = hashTable.get("item1");
        System.out.println("data:"+item1);
        int size = hashTable.size();
        System.out.println("size:"+size);
        boolean isEmpty = hashTable.isEmpty();
        hashTable.delete("item4");
        int size2 = hashTable.size();
        System.out.println("size:"+size2);
        System.out.println("isEmpty:"+isEmpty);
    }
}