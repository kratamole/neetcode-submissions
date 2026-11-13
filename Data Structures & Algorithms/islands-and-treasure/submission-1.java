class Solution {
    private final int LAND = Integer.MAX_VALUE;
    private final int WATER = -1;
    private final int CHEST = 0;

    private Set<int[]> visitedChests = new HashSet<>();

    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (n == 1 && m == 1) {
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == CHEST) {
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
        if (x > 0 && this.isLand(grid[x - 1][y])) {
            queue.offer(new int[]{x - 1, y, 1});
        }
        if (y > 0 && this.isLand(grid[x][y - 1])) {
            queue.offer(new int[]{x, y - 1, 1});
        }
        if (x < n - 1 && this.isLand(grid[x + 1][y])) {
            queue.offer(new int[]{x + 1, y, 1});
        }
        if (y < m - 1 && this.isLand(grid[x][y + 1])) {
            queue.offer(new int[]{x, y + 1, 1});
        }
        while (!queue.isEmpty()) {
            int[] coord = queue.poll();
            int i = coord[0];
            int j = coord[1];
            int d = coord[2];
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
        return num > CHEST;
    }
}
