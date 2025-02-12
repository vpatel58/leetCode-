class Solution {
    static int minJumps(int[] arr) {
        // code here
        int n = arr.length;
        if (arr[0] == 0) return -1;
        if (n == 1) return 0;

        //initialize variables
        int maxReach = arr[0];
        int steps = arr[0];
        int jumps = 1;

        for (int i = 1; i < n; i++) {
            if (i == n - 1) return jumps;

            //update maxReach
            maxReach = Math.max(maxReach, i + arr[i]);
            //update steps
            steps--;

            if (steps == 0) {
                jumps++;
                if (i >= maxReach) return -1;
                steps = maxReach - i;
            }
        }
        return -1;
    }
}