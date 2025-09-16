class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        for (int num : nums) {
            list.add(num);
        
            while (list.size() > 1) {
                int a = list.get(list.size() - 2);
                int b = list.get(list.size() - 1);
                int g = gcd(a, b);
                if (g > 1) {
                    list.remove(list.size() - 1);
                    list.remove(list.size() - 1);
                    list.add(lcm(a, b));
                } else {
                    break;
                }
            }
        }
        
        return list;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public int lcm(int a, int b) {
        return (int)((long)a * b / gcd(a, b));
    }
}
