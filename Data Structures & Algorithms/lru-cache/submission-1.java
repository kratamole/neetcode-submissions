class LRUCache {
    private int capacity;
    private Map<Integer, Node<Integer, Integer>> keyNodeMap = new HashMap<>();
    private MyQueue<Integer, Integer> keyUsage;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.keyUsage = new MyQueue<>(capacity);
    }
    
    public int get(int key) {
        if (this.keyNodeMap.containsKey(key)) {
            this.touch(key);
            return this.keyNodeMap.get(key).value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (!this.keyNodeMap.containsKey(key) && this.keyNodeMap.size() == this.capacity) {
            this.releaseLRUKey();
        }
        this.touch(key, value);
    }

    private void touch(int key) {
        Node<Integer, Integer> prevLastOp = this.keyNodeMap.get(key);
        if (prevLastOp != null) {
            this.keyUsage.delete(prevLastOp);
        }
        this.keyUsage.insert(key, prevLastOp.value);
        this.keyNodeMap.put(key, this.keyUsage.head);
    }

    private void touch(int key, int value) {
        Node<Integer, Integer> prevLastOp = this.keyNodeMap.get(key);
        if (prevLastOp != null) {
            this.keyUsage.delete(prevLastOp);
        }
        this.keyUsage.insert(key, value);
        this.keyNodeMap.put(key, this.keyUsage.head);
    }

    private void releaseLRUKey() {
        int lruKey = this.keyUsage.pop().key;
        this.keyNodeMap.remove(lruKey);
    }

    class MyQueue<K, V> {
        Node<K, V> head;
        Node<K, V> tail;
        int capacity;
        int size = 0;

        public MyQueue(int capacity) {
            this.capacity = capacity;
        }

        public Node<K, V> insert(K key, V value) {
            Node<K, V> newNode = new Node<>(key, value);
            if (this.head == null) {
                this.head = this.tail = newNode;
                size++;
            } else if (size < capacity) {
                this.head.prev = newNode;
                newNode.next = this.head;
                this.head = newNode;
                size++;
            } else {
                Node<K, V> popped = this.pop();
                this.insert(key, value);
                return popped;
            }
            return null;
        }

        public Node<K,V> pop() {
            if (this.tail == null) {
                return null;
            }
            size--;
            Node<K,V> res = this.tail;
            if (this.tail.prev != null) {
                this.tail.prev.next = null;
            }
            this.tail = this.tail.prev;
            res.next = res.prev = null;
            return res;
        }

        public boolean delete(Node<K, V> node) {
            if (this.head == null) {
                return false;
            }
            if (node == this.head) {
                if (node.next != null) {
                    node.next.prev = null;
                }
                this.head = node.next;
            } else if (node == this.tail) {
                if (node.prev != null) {
                    node.prev.next = null;
                }
                this.tail = node.prev;
            } else {
                if (node.prev != null) {
                    node.prev.next = node.next;
                }
                if (node.next != null) {
                    node.next.prev = node.prev;
                }
            }
            node.next = node.prev = null;
            size--;
            return true;
        }
    }

    class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
        Node<K, V> prev;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            Node<K, V> other = (Node<K, V>) o;
            return this.key.equals(other.key) && this.value.equals(other.value) && this.next == other.next && this.prev == other.prev;
        }
        @Override
        public int hashCode() {
            return Objects.hash(key, value, next, prev);
        }
    }
}
