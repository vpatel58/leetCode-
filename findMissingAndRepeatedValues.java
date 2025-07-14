class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int num = n * n;
        int[] fre = new int[num + 1];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                fre[grid[i][j]]++;
                sum += grid[i][j];
            }
        }
        int a = 0;
        for (int i = 1; i < fre.length; i++) {
            if (fre[i] == 2) a = i;
        }
        int supp = (num * (num + 1)) / 2;
        int b = supp - (sum - a);
        return new int[] {a, b};
    }
}
