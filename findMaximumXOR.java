class Solution {
    class Node {
        Node[] child;
        Node() {
            child = new Node[2];
        }
    }
    Node root;
    
    public void insert(int num) {
        Node curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (curr.child[bit] == null) {
                curr.child[bit] = new Node();
            }
            curr = curr.child[bit];
        }
    }
    public int findMaximumXOR(int[] nums) {
        root = new Node();
        for (int i = 0; i < nums.length; i++) {
            insert(nums[i]);
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, getMax(nums[i]));
        }
        return result;
    }

    public int getMax(int num) {
        Node curr = root;
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (curr.child[1 - bit] != null) {
                curr = curr.child[1 - bit];
                ans = ans | 1 << i;
            } else {
                curr = curr.child[bit];
            }    
        }
        return ans;
    }

}
