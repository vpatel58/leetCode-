class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    public boolean backtrack(char[][] board, int row, int col) {
        if (col == board[0].length) {
            row++;
            col = 0;
        }
        if (row == board.length) return true;
        if (board[row][col] == '.') {
            for (char num = '1'; num <= '9'; num++) {
                if (isValid(board, row, col, num)) {
                    board[row][col] = num;
                    if (backtrack(board, row, col + 1)) return true; 
                    board[row][col] = '.';
                }
            }
            return false;
        }
        return backtrack(board, row, col + 1);
    }

    public boolean isValid(char[][] board, int row, int col, char num) {
        for (int j = 0; j < board[0].length; j++) {
            if (board[row][j] == num) return false;
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num) return false;
        }
        int gr = (row / 3) * 3;
        int gc = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[gr + i][gc + j] == num) return false;
            }
        }
        return true;
    }
}
