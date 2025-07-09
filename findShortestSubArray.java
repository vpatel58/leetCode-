class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int degree = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[] {1 , i, i});
            } else {
                int[] info = map.get(nums[i]);
                info[0]++;
                info[2] = i;
            }
            
            degree = Math.max(degree, map.get(nums[i])[0]);
        }
        if (degree == 1) return 1;
        int len = Integer.MAX_VALUE;
        for (int[] info : map.values()) {
            if (info[0] == degree) {
                len = Math.min(len, info[2] - info[1] + 1);
            }
        }
        return len;
    }
}
