class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int start = 0; start < n; start++) {
            int fuel = 0;
            boolean canTravel = true;
            for (int i = 0; i < n; i++) {
                int idx = (start + i) % n;
                fuel += gas[idx] - cost[idx];
                if (fuel < 0) {
                    canTravel = false;
                    break;
                }
            }
            if (canTravel) return start;
        }
        return -1;
    }
}
