class Solution {
    public int[][] diagonalSort(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!map.containsKey(i - j)) {
                    map.put(i - j, new ArrayList<>());
                }
                map.get(i - j).add(grid[i][j]);
            }
        }
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            Collections.sort(list);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - j < 0) {
                    grid[i][j] = map.get(i - j).get(i);
                } else {
                    grid[i][j] = map.get(i - j).get(j);
                }
            }
        }
        return grid;
    }
}
