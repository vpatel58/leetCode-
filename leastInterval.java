class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFre = 0;
        int maxCount = 0;
        for (int i = 0; i < tasks.length; i++) {
            char c = tasks[i];
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFre = Math.max(maxFre, map.get(c));
        }
        for (char key : map.keySet()) {
            if (map.get(key) == maxFre) {
                maxCount++;
            }
        }
        int partitions = maxFre - 1;
        int empty = partitions * (n - (maxCount - 1));
        int incompelete = tasks.length - (maxFre * maxCount);
        int idle = Math.max(0, empty - incompelete);

        return tasks.length + idle;
    }
}
