/*
* Problem with fixed sized array is underflow and overflow.
* We are allowing null items to be added.
* Holdig referecne to the object which are no loger needed.
*/
class StackusingArray {
    private int N = 0;
    private String[] s;
    private int arrayLimit;
    public StackusingArray(int capacity) {
        arrayLimit = capacity;
        s = new String[capacity];
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public void push(String item) {
        if(N < arrayLimit) {
            s[N++] = item;
        } else {
            System.out.println("Stack is Full");
        }
    }
    public String pop() {
        int popIndex = N-1;
        if (popIndex >= 0) {
            String item = s[--N];
            return item;
        } else {
            return null;
        }
    }
    public String getValue() {
        String items= "";
        for (int i = N-1; i > -1; i--) {
            if (i == N-1) {
                items = s[i];
            } else {
                items += ","+s[i];
            }
        }
        return items;
    }
    /*
    * public static void main(String[] args) {
    *    StackusingArray stack = new StackusingArray(4);
    *    stack.push("item 1");
    *    stack.push("item 2");
    *    stack.push("item 3");
    *    stack.push("item 4");
    *    stack.push("item 5");
    *    String popedValue = stack.pop();
    *    if (popedValue != null) {
    *        System.out.println("Poped value:"+popedValue);
    *    } else {
    *        System.out.println("There is no item in stack to pop.");
    *    }
    *    System.out.println("Is Empty:"+stack.isEmpty());
    *    String items = stack.getValue();
    *    if (items != "") {
    *        System.out.println("Stack item(s) from top to bottom:"+items);
    *    } else {
    *        System.out.println("There is no item in stack.");
    *    }
    * } */
}