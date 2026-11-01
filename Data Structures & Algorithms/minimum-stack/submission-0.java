class MinStack {
    Node<Integer> tail;
    public MinStack() {
    }
    
    public void push(int val) {
        Node<Integer> newNode = new Node(val);
        if (this.tail != null) {
            newNode.prev = this.tail;
        }
        this.tail = newNode;
    }
    
    public void pop() {
        this.tail = this.tail.prev;
    }
    
    public int top() {
        return this.tail.val;
    }
    
    public int getMin() {
        Node<Integer> iter = this.tail;
        int res = Integer.MAX_VALUE;
        while (iter != null) {
            res = res <= iter.val ? res : iter.val;
            iter = iter.prev;
        }
        return res;
    }

    class Node<T> {
        T val;
        Node<T> prev;

        public Node(T val) {
            this.val = val;
            this.prev = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            Node<T> other = (Node<T>) o;
            return this.val.equals(other.val) && this.prev == other.prev;
        }
    }
}
