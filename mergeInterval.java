class Solution {
    class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int[][] merge(int[][] intervals) {
        List<Interval> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(list, (a, b) -> a.start - b.start);
        if (list.size() == 1) 
            return new int[][] { { list.get(0).start, list.get(0).end } };
        List<Interval> res = new ArrayList<>();
        Interval prev = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Interval curr = list.get(i);
            if (curr.start <= prev.end) {
                prev.end = Math.max(prev.end, curr.end);
            } else {
                res.add(prev);
                prev = curr;
            }
        }
        res.add(prev);
        int[][] ans = new int[res.size()][];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = new int[] {res.get(i).start, res.get(i).end};
        }
        return ans;
    }
}
