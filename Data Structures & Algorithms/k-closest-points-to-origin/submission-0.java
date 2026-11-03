class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Point2D> maxHeap = new PriorityQueue<>(Comparator.comparingInt((Point2D p) -> p.dist0).reversed());
        for (int[] point : points) {
            maxHeap.offer(new Point2D(point[0], point[1]));
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[][] res = new int[k][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            Point2D point = maxHeap.poll();
            res[i++] = new int[]{point.x, point.y};
        }
        return res;
    }

    class Point2D {
        int x;
        int y;
        int dist0;
        public Point2D(int x, int y) {
            this.x = x;
            this.y = y;
            this.dist0 = x*x + y*y;
        }
    }
}
