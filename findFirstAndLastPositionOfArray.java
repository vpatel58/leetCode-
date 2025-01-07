class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if(nums.length == 0 || nums == null) return new int[] {-1, -1};
        if(target < nums[0] || target > nums[nums.length - 1]) return new int[] {-1, -1};
        

        int first = firstOccurence(nums, target);
        if(first == -1) return new int[] {-1, -1};
        int last = lastOccurence(nums, target);
        return new int[] {first, last};
    }

    private int firstOccurence(int[] nums, int target){
        
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(target == nums[mid]){
                if(mid == 0 || nums[mid-1] < target){
                    return mid;
                }else{
                    high = mid - 1;
                }
            }else if(target < nums[mid]){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private int lastOccurence(int[] nums, int target){
        
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(target == nums[mid]){
                if(mid == nums.length - 1 || nums[mid+1] > target){
                    return mid;
                }else{
                    low = mid + 1;
                }
            }else if(target > nums[mid]){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
