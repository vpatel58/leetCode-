// User function Template for Java

class Solution {
    static int assignMiceHoles(int N, int[] M, int[] H) {
        // code here
        Arrays.sort(M);
        Arrays.sort(H);
        
        int time = 0;
        for (int i = 0; i < M.length; i++) {
            int t = Math.abs(M[i] - H[i]);
            time = Math.max(time, t);
        }
        return time;
    }
};
