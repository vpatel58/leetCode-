class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[] {};
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n2 < n1) {
            return intersect(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int low = 0;
        for (int i = 0; i < n1; i++) {
            int idx = binarySearch(nums2, low, n2 - 1, nums1[i]);
            if (idx != -1) {
                list.add(nums1[i]);
                low = idx + 1;
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == low || nums[mid - 1] < nums[mid]) {
                    return mid;
                }
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
         }
         return -1;
    }
}
