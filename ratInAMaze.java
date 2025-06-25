class Solution {
    // Function to find all possible paths
    ArrayList<String> ans;
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ans = new ArrayList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        helper(maze, 0, 0, visited, "");
        Collections.sort(ans);
        return ans;
    }
    
    private void helper(int[][] maze, int row, int col, boolean[][] visited, String path) {
        //base
        if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length || visited[row][col] || maze[row][col] == 0) return;
        
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            ans.add(path);
            return;
        }
        //logic
        visited[row][col] = true;
        helper(maze, row, col - 1, visited, path + "L");
        helper(maze, row - 1, col, visited, path + "U");
        helper(maze, row, col + 1, visited, path + "R");
        helper(maze, row + 1, col, visited, path + "D");
        visited[row][col] = false;
    }
}
