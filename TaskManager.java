class Pair {
    int userId;
    int priority;

    Pair(int userId, int priority) {
        this.userId = userId;
        this.priority = priority;
    }
}

class TaskManager {
    HashMap<Integer, Pair> map = new HashMap<>();
    TreeSet<Integer> set;

    public TaskManager(List<List<Integer>> tasks) {
        map = new HashMap<>();
        set = new TreeSet<>((t1, t2) -> {
            Pair p1 = map.get(t1);
            Pair p2 = map.get(t2);
            if (p1.priority != p2.priority) {
                return Integer.compare(p2.priority, p1.priority);
            }
            return Integer.compare(t2, t1);
        });
        for (List<Integer> task : tasks) {
            map.put(task.get(1), new Pair(task.get(0), task.get(2)));
            set.add(task.get(1));
        }
    }

    public void add(int userId, int taskId, int priority) {
        map.put(taskId, new Pair(userId, priority));
        set.add(taskId);
    }

    public void edit(int taskId, int newPriority) {
        set.remove(taskId);
        Pair p = map.get(taskId);
        p.priority = newPriority;
        set.add(taskId);
    }

    public void rmv(int taskId) {
        set.remove(taskId);
        map.remove(taskId);
    }

    public int execTop() {
        if (set.size() == 0) return -1;
        int taskId = set.first();
        set.remove(taskId);
        Pair p = map.get(taskId);
        int id = p.userId;
        map.remove(taskId);
        return id;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
