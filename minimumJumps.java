class Solution {
    
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        if (x == 0) return 0;
        Set<Integer> set = new HashSet<>();
        totalJumps = Integer.MAX_VALUE;
        for (int i = 0; i < forbidden.length; i++) {
            set.add(forbidden[i]);
        }
        boolean[][] visited = new boolean[6001][2];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        int jumps = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] state = q.poll();
                int pos = state[0];
                int isBackward = state[1];
                if (pos == x) return jumps;
                int forward = pos + a;
                if (forward <= 6000 && !set.contains(forward) && !visited[forward][0]) {
                    visited[forward][0] = true;
                    q.add(new int[] {forward, 0});
                }
                int backward = pos - b;
                if (isBackward == 0 && backward >= 0 && !set.contains(backward) && !visited[backward][1]) {
                    visited[backward][1] = true;
                    q.add(new int[] {backward, 1});
                }
            }
            jumps++;
        }
        return -1;
    }
}
