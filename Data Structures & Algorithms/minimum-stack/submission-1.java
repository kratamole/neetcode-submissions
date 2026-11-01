class MinStack {
    Node<int[]> tail;
    public MinStack() {
    }
    
    public void push(int val) {
        Node<int[]> newNode;
        if (this.tail == null) {
            newNode = new Node(new int[]{val, val});
        } else {
            newNode = new Node(new int[]{val, Math.min(val, this.tail.val[1])});
            newNode.prev = this.tail;
        }
        this.tail = newNode;
    }
    
    public void pop() {
        this.tail = this.tail.prev;
    }
    
    public int top() {
        return this.tail.val[0];
    }
    
    public int getMin() {
        return this.tail.val[1];
    }

    class Node<T> {
        T val;
        Node<T> prev;

        public Node(T val) {
            this.val = val;
            this.prev = null;
        }
    }
}
