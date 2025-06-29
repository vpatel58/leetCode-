class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, dirs, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, int[][] dirs, String word, int r, int c, int idx) {
        //base  
        if (idx == word.length()) return true;
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == '#') return false;

        //logic
        
        if (board[r][c] == word.charAt(idx)) {
            char ch = board[r][c];
            board[r][c] = '#';
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (backtrack(board, dirs, word, nr, nc, idx + 1)) return true;
            }
            board[r][c] = ch;
        }
        
        return false;
    }
}
