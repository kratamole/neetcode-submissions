class KthLargest {
    private final Queue<Integer> minHeap;
    private final Integer heapSize;
    
    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue();
        this.heapSize = k;
        for (int num : nums) {
            this.add(num);
        }
    }
    
    public int add(int val) {
        if (this.minHeap.size() < this.heapSize) {
            this.minHeap.add(val);
        } else if (val > this.minHeap.peek()) {
            this.minHeap.remove();
            this.minHeap.add(val);
        }
        return this.minHeap.peek();
    }
}
