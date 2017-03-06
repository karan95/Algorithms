class Stack {
    private Node first = null;
    private class Node {
        String item;
        Node next;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }
    public String pop() {
        String item;
        if (first != null) {
            item = first.item;
            first = first.next;
            return item;
        } else {
            return null;
        }
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
    /* public static void main(String[] args) {
     *   Stack stack = new Stack();
     *   stack.push("item 1");
     *   stack.push("item 2");
     *   stack.push("item 3");
     *   String popedValue = stack.pop();
     *   if (popedValue != null) {
     *       System.out.println("Poped value:"+popedValue);
     *   } else {
     *       System.out.println("There is no item in stack to pop.");
     *   }
     *   System.out.println("Is Empty:"+stack.isEmpty());
     *   String items = stack.getValue();
     *   if (items != null) {
     *       System.out.println("Stack item(s) from top to bottom:"+items);
     *   } else {
     *       System.out.println("There is no item in stack");
     *   }
     *   // A stack with N items uses ~40Nbytes. 
     * } */
}