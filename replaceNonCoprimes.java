class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        int i = 0;
        while (i < list.size() - 1) {
            int a = list.get(i), b = list.get(i + 1);
            int g = gcd(a, b);

            if (g > 1) {
                int lcm = (int) ((long) a * b / g); // use long to prevent overflow
                list.remove(i);     // remove a
                list.remove(i);     // remove b (now at index i)
                list.add(i, lcm); 

                if (i > 0) i--;
            } else {
                i++;
            }
        }
        return list;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
