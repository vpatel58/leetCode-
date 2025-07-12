class Solution {
    public int distributeCandies(int[] candyType) {
        Arrays.sort(candyType);
        int n = candyType.length;
        int count = 1;
        int type = candyType[0];
        for (int i = 0; i < candyType.length; i++) {
            if (candyType[i] != type) {
                count++;
                type = candyType[i];
            }
        }
        if ((n / 2) >= count) return count;
        if ((n / 2) < count) return n / 2;
        return -1;
    }
}
