class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1 == null && nums2 == null) || (nums1.length == 0 && nums2.length == 0)) return 0.0;
        int n = nums1.length;
        int m = nums2.length;
        if (m < n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0;
        int high = n;
        while (low <= high) {
            int partX = low + (high - low) / 2;
            int partY = ((n + m) / 2) - partX;

            int l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            int l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            int r1 = partX == n ? Integer.MAX_VALUE : nums1[partX];
            int r2 = partY == m ? Integer.MAX_VALUE : nums2[partY];

            if (l1 <= r2 && l2 <= r1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max((double)l1,(double) l2) + Math.min((double)r1,(double) r2)) / 2;
                }
                return Math.min((double) r1, (double) r2);
            } else if (l1 > r2) {
                high = partX - 1;
            } else {
                low = partX + 1;
            }
        }
        return 0;
    }
}
