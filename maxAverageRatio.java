class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int[] clas : classes) {
            double p = (double) clas[0];
            double t = (double) clas[1];
            double gain = (t - p) / (t * (t + 1));
            pq.add(new double[] {gain, p, t});
        }
        while (extraStudents-- > 0) {
            double[] clas = pq.poll();
            double p = clas[1];
            double t = clas[2];
            p++;
            t++;
            double gain = (t - p) / (t * (t + 1));
            pq.add(new double[] {gain, p, t});
        }
        double res = 0.0;
        while (!pq.isEmpty()) {
            double[] clas = pq.poll();
            double pass = (double) clas[1];
            double total = (double) clas[2];
            res += (pass / total);
        }
        return res / (double) classes.length;
    }
}
