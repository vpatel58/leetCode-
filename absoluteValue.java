class Solution {
    public int maxAbsValExpr(int[] a, int[] b) {

        int c1min = Integer.MAX_VALUE;
        int c1max = Integer.MIN_VALUE;
        int c2min = Integer.MAX_VALUE;
        int c2max = Integer.MIN_VALUE;
        int c3min = Integer.MAX_VALUE;
        int c3max = Integer.MIN_VALUE;
        int c4min = Integer.MAX_VALUE;
        int c4max = Integer.MIN_VALUE;

        for(int i = 0; i < a.length; i++) {

            c1min = Math.min(a[i] + b[i] + i, c1min);
            c1max = Math.max(a[i] + b[i] + i, c1max);
            c2min = Math.min(b[i] - a[i] + i, c2min);
            c2max = Math.max(b[i] - a[i] + i, c2max);
            c3min = Math.min(a[i] - b[i] + i, c3min);
            c3max = Math.max(a[i] - b[i] + i, c3max);
            c4min = Math.min(i - a[i] - b[i], c4min);
            c4max = Math.max(i - a[i] - b[i], c4max);
    
        }

        return Math.max(
            Math.max(c1max - c1min, c2max - c2min),
            Math.max(c3max - c3min, c4max - c4min));
    }
}
