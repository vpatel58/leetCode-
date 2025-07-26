class Solution {
    public int minimumDifference(int[] nums) {
        int N = nums.length;
        int res =  Integer.MAX_VALUE, totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int n = N / 2;
        List<List<Integer>> left = new ArrayList<>();
        List<List<Integer>> right = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            left.add(new ArrayList<>());
            right.add(new ArrayList<>());
        }
        for (int mask = 0; mask < (1 << n); mask++) {
            int size = 0, l = 0, r = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    size++;
                    l += nums[i];
                    r += nums[i + n];
                }
            }
            left.get(size).add(l);
            right.get(size).add(r);
        }

        for (int i = 0; i < n + 1; i++) {
            Collections.sort(right.get(i));
        }
        for (int size = 0; size < n + 1; size++) {
            for (int a : left.get(size)) {
                int b = (totalSum - (2 * a)) / 2;
                int rem = n - size;
                List<Integer> v = right.get(rem);
                int idx = Collections.binarySearch(v, b);

                if (idx < 0) idx = -idx - 1;

                if (idx < v.size()) {
                    res = Math.min(res, Math.abs(totalSum - 2 * (a + v.get(idx))));
                }

                if (idx > 0) {
                    int it = idx - 1;
                    res = Math.min(res, Math.abs(totalSum - 2 * (a + v.get(it))));
                }
            }
        }
        return res;
    }
}
