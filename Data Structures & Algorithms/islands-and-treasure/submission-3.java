class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (n == 1 && m == 1) {
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    this.updDistFromChest(grid, i, j, n, m);
                }
                // System.out.print((grid[i][j] >= 0 ? " " : "") + grid[i][j] + " ");
            }
            // System.out.println();
        }

        return;
    }

    private void updDistFromChest(int[][] grid, int x, int y, int n, int m) {
        Queue<int[]> queue = new ArrayDeque<>();
        
        int i = x;
        int j = y;
        int d = 0;
        if (i > 0 && this.isLand(grid[i - 1][j])) {
            queue.offer(new int[]{i - 1, j, d + 1});
        }
        if (j > 0 && this.isLand(grid[i][j - 1])) {
            queue.offer(new int[]{i, j - 1, d + 1});
        }
        if (i < n - 1 && this.isLand(grid[i + 1][j])) {
            queue.offer(new int[]{i + 1, j, d + 1});
        }
        if (j < m - 1 && this.isLand(grid[i][j + 1])) {
            queue.offer(new int[]{i, j + 1, d + 1});
        }
        while (!queue.isEmpty()) {
            int[] coord = queue.poll();
            i = coord[0];
            j = coord[1];
            d = coord[2];
            if (d < grid[i][j]) {
                grid[i][j] = d;
                if (i > 0 && this.isLand(grid[i - 1][j])) {
                    queue.offer(new int[]{i - 1, j, d + 1});
                }
                if (j > 0 && this.isLand(grid[i][j - 1])) {
                    queue.offer(new int[]{i, j - 1, d + 1});
                }
                if (i < n - 1 && this.isLand(grid[i + 1][j])) {
                    queue.offer(new int[]{i + 1, j, d + 1});
                }
                if (j < m - 1 && this.isLand(grid[i][j + 1])) {
                    queue.offer(new int[]{i, j + 1, d + 1});
                }
            }
        }
    }

    private boolean isLand(int num) {
        return num > 0;
    }
}
