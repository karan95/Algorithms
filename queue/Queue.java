class Queue {
    private Node first, last;
    private int n;
    private class Node {
        String item;
        Node next;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public void enqueue(String item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty())
            first = last;
        else
            oldlast.next = last;
    }
    public String dequeue() {
        String item = first.item;
        first = first.next;
        return item;
    }
    public int size() {
        Node firstSize = first;
        if (firstSize != null) {
            n++;
            while (firstSize.next != null) {
                firstSize = firstSize.next;
                n++;
            }
        }
        return n;
    }
    public String getValue() {
        Node firstCount = first;
        if (firstCount != null) {
            String item = firstCount.item;
            while (firstCount.next != null) {
                firstCount = firstCount.next;
                item += "," + firstCount.item;
            }
            return item;
        } else {
            return null;
        }
    }
    /* public static void main(String args[]) {
     *   Queue queue = new Queue();
     *   queue.enqueue("item1");
     *   queue.enqueue("item2");
     *   queue.enqueue("item3");
     *   String removedItem = queue.dequeue();
     *   System.out.println("Removed item from Queue:"+removedItem);
     *   int n = queue.size();
     *   System.out.println("Number of item in Queue:"+n);
     *   String items = queue.getValue();
     *   if (items != null) {
     *       System.out.println("Queue item(s):"+items);
     *   } else {
     *       System.out.println("There is no item in Queue");
     *   }
     * } */
}