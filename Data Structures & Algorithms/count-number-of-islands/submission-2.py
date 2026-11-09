class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        ROWS = len(grid)
        COLS = len(grid[0])
        def dfs(row: int, col: int):
            if row < 0 or col < 0 or row >= ROWS or col >= COLS or grid[row][col] == "0":
                return
            
            grid[row][col] = "0"

            dfs(row-1, col)
            dfs(row+1, col)
            dfs(row, col-1)
            dfs(row, col+1)

        res = 0

        for row in range(0, ROWS):
            for col in range(0, COLS):
                if grid[row][col] == "1":
                    dfs(row, col)
                    res += 1

        return res