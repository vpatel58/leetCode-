class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer>[] rows = new HashSet[9];
        HashSet<Integer>[] cols = new HashSet[9];
        HashSet<Integer>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch == '.') continue;
                int num = ch - '0';
                int boxIdx = (i / 3) * 3 + (j / 3);
                if (rows[i].contains(num) || cols[j].contains(num) || boxes[boxIdx].contains(num)) {
                    return false;
                }
                rows[i].add(num);
                cols[j].add(num);
                boxes[boxIdx].add(num);
            }
        }
        return true;
    }
}
