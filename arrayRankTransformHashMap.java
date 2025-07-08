class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] ar = arr.clone();
        Arrays.sort(ar);
        int rank = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : ar) {
            if (!map.containsKey(n)) {
                map.put(n, rank++);
            }
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int r = map.get(arr[i]);
            res[i] = r;
        }
        return res;
    }
}
