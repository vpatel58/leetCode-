class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        int left = 0;
        int right = n - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int ld = x - arr[mid];
            int rd = arr[mid + k] - x;
            if (ld > rd) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        for (int i = left; i < left + k; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}
