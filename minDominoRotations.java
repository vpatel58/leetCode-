class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int val = findMinRotations(tops, bottoms, tops[0]);
        if (val != -1) return val;
        return findMinRotations(tops, bottoms, bottoms[0]);
    }

    public int findMinRotations(int[] tops, int[] bottoms, int target) {
            int topR = 0, botR = 0;
            for (int i = 0; i < tops.length; i++) {
                if (tops[i] != target && bottoms[i] != target) {
                    return -1;
                } else if (tops[i] != target) {
                    topR++;
                } else if (bottoms[i] != target) {
                    botR++;
                }
            }
            return Math.min(topR, botR);
        }
}
