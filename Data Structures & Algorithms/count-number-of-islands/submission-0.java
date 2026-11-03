class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    this.bfs(grid, i, j);
                    // this.dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int row, int col)
    {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }
        if (grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        this.dfs(grid, row-1, col);
        this.dfs(grid, row, col-1);
        this.dfs(grid, row+1, col);
        this.dfs(grid, row, col+1);
    }

    private void bfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row, col});
        while (!queue.isEmpty()) {
            int[] coordinates = queue.poll();
            int i = coordinates[0];
            int j = coordinates[1];
            if (i > 0 && grid[i - 1][j] == '1') {
                grid[i - 1][j] = '0';
                queue.add(new int[]{i - 1, j});
            }
            if (j > 0 && grid[i][j - 1] == '1') {
                grid[i][j - 1] = '0';
                queue.add(new int[]{i, j - 1});
            }
            if (i < grid.length - 1 && grid[i + 1][j] == '1') {
                grid[i + 1][j] = '0';
                queue.add(new int[]{i + 1, j});
            }
            if (j < grid[0].length - 1 && grid[i][j + 1] == '1') {
                grid[i][j + 1] = '0';
                queue.add(new int[]{i, j + 1});
            }
        }
    }
}
