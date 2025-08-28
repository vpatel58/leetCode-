class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!map.containsKey(i - j)) {
                    map.put(i - j, i - j < 0 ? new PriorityQueue<>() : new PriorityQueue<>(Collections.reverseOrder()));
                }
                map.get(i - j).add(grid[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i - j < 0) {
                    grid[i][j] = map.get(i - j).poll();
                } else {
                    grid[i][j] = map.get(i - j).poll();
                }
            }
        }
        return grid;
    }
}
