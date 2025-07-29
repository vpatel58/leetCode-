
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int l = 0, r = 0, sum = 0;
        while (r < arr.length) {
            sum += arr[r];
            while (sum > target && l <= r) {
                sum -= arr[l];
                l++;
            }
            if (sum == target) return new ArrayList<>(Arrays.asList(l + 1, r + 1));
            r++;
        }
        return new ArrayList<>(Arrays.asList(-1));
    }
}
