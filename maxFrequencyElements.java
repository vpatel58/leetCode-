class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            max = Math.max(map.get(nums[i]), max);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == max) count++;
        }
        return count;
    }
}
