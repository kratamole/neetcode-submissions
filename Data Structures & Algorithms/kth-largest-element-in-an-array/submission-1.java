class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = this.getMinHeapRepeatedInsertion(nums, k);
        return minHeap.peek();
    }

    // O(NlogN)
    private Queue<Integer> getMinHeapRepeatedInsertion(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<Integer>();
        for (int n : nums) {
            minHeap.offer(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap;
    }
}
