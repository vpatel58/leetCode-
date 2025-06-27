class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        list.add(0);
        set.add(0);
        int total = 1 << n;
        helper(total, list, set);
        return list;
    }

    private boolean helper(int total, List<Integer> list,HashSet<Integer> set) {
        //base
        if (list.size() == total) return true;
        //logic
        int curr = list.get(list.size() - 1);
        for (int i = 0; i < 32; i++) {
            int next = curr ^ (1 << i);//flip one bit
            if (!set.contains(next)) {
                list.add(next);
                set.add(next);
                if (helper(total, list, set)) return true;
                list.removeLast();
                set.remove(next);
            }
        }
        return false;
    }
}
