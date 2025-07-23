class Solution {
    Map<String, Boolean> map;
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        map = new HashMap<>();
        for(int len = 1; len < n;len++){
            if((sum * len) % n != 0)continue;
            if(find(nums,(sum * len) / n, len, 0))return true;
        }
        return false;
    }
    private boolean find(int[] nums, int sum, int len,int idx){
        if(len == 0) return sum == 0;
        if(sum < 0 || len + idx > nums.length)return false;
        String key = sum +"|" + len +"|"+ idx;
        if (map.containsKey(key)) return map.get(key);

        boolean res = find(nums,sum-nums[idx], len - 1, idx+1)|| find(nums, sum, len, idx + 1);
        map.put(key, res);
        return res;
    }
}
