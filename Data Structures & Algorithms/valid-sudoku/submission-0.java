class Solution {
    public boolean isValidSudoku(char[][] board) {
        return isRowsColsValid(board) && isQuadrantsValid(board);
    }

    private boolean isRowsColsValid(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int[] rowDigCounter = new int[9];
            int[] colDigCounter = new int[9];
            for (int j = 0; j < 9; j++) {
                if(!(isCharValid(board, i, j, rowDigCounter) && isCharValid(board, j, i, colDigCounter))) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isQuadrantsValid(char[][] board) {
        for (int k = 0; k < 9; k++) {
            int[] digCounter = new int[9];
            for (int i = (k % 3) * 3; i < (k % 3) * 3 + 3; i++) {
                for (int j = (k / 3) * 3; j < (k / 3) * 3 + 3; j++) {
                    if(!isCharValid(board, i, j, digCounter)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isCharValid(char[][] board, int i, int j, int[] digCounter) {
        // System.out.println("i:" + i + "; j:" + j);
        char c = board[i][j];
        if (c == '.') {
            return true;
        }
        digCounter[c-'1'] += 1;
        return (digCounter[c-'1'] > 1) ? false : true;
    }
}
