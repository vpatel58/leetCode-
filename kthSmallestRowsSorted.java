class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        List<Integer> temp = new ArrayList<>();
        for (int num : mat[0]) {
            temp.add(num);
        }

        for (int i = 1; i < n; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j < temp.size(); j++) {
                for (int l = 0; l < m; l++) {
                    curr.add(temp.get(j) + mat[i][l]);
                }
            }
            Collections.sort(curr);
            temp.clear();
            int size = Math.min(k + 1, curr.size());
            for (int j = 0; j < size; j++) {
                temp.add(curr.get(j));
            }
        }
        return temp.get(k - 1);
    }
}
