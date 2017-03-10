import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MaxPriorityQueue<Key extends Comparable<Key>> {
    private Key[] pq;
    private int n;
    private int arraySize;
    public MaxPriorityQueue(int capacity) {
        pq = (Key[]) new Comparable[capacity+1];
    }
    public boolean isEmpty() {
        return n == 0;
    }
    public void insert(Key k) {
        if(n >= pq.length -1) resize(2 * pq.length);
        pq[++n] = k;
        swim(n);
    }
    public Key delMax() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key max = pq[1];
        swap(1, n--);
        sink(1);  
        pq[n+1] = null;
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        return max;
    }
    private void swim(int k) {
        while(k > 1) {
            int j = k/2;
            if(less(j, k)) {
                swap(j,k);
            }
            k = k/2; 
        }
    }
    private boolean less(int j, int k) {
        return pq[j].compareTo(pq[k]) < 0; 
    }
    private void swap(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
    private void sink(int key) {
        while( 2 * key <= n) {
            int j = 2 * key;
            if(j < n && less(j, j+1)) j++;
            if (!less(key, j)) break;
            swap(key, j);
            key = j;
        }
    }
    private void resize(int capacity) {
        Key[] temp = (Key[]) new Comparable[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }
    public static void main(String args[]) {
        MaxPriorityQueue<String> instancePq = new MaxPriorityQueue<String>(2);
        instancePq.insert("D");
        instancePq.insert("Z");
        instancePq.insert("A");
        String pop1 = instancePq.delMax();
        String pop2 = instancePq.delMax();
        String pop3 = instancePq.delMax();
        System.out.println(pop1);
        System.out.println(pop2);
        System.out.println(pop3);
    }
}