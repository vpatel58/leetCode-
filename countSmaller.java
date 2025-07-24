class Solution {

    class Pair {
        int val;
        int index;
        Pair (int val, int index) {
            this.val= val;
            this.index = index;
        }
    }
    int[] count;

    public List<Integer> countSmaller(int[] nums) {
        count = new int[nums.length];
        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(nums[i], i);
        }
        mergeSort(pairs, 0, nums.length - 1);
        List<Integer> ans = new ArrayList<>();
        for (int num : count) {
            ans.add(num);
        }
        return ans;
    }

    public Pair[] mergeSort(Pair[] pairs, int start, int end) {
        if (start == end) return new Pair[] {pairs[start]};

        int mid = (start + end) / 2;
        Pair[] firstHalf = mergeSort(pairs, start, mid);
        Pair[] secondHalf = mergeSort(pairs, mid + 1, end);
        return merge(firstHalf, secondHalf);
    }

    public Pair[] merge(Pair[] a, Pair[] b) {
        int i = 0, j = 0, k = 0;
        Pair[] res = new Pair[a.length + b.length];
        while (i < a.length && j < b.length) {
            if (a[i].val <= b[j].val) {
                res[k++] = b[j++];
            } else {
                count[a[i].index] += (b.length - j);
                res[k++] = a[i++];
            }
        }
        while (i < a.length) res[k++] = a[i++];
        while (j < b.length) res[k++] = b[j++];
        return res;
    }
}
