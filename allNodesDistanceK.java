/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Pair {
    TreeNode root;
    int dist;
    Pair(TreeNode root, int dist) {
        this.root = root;
        this.dist = dist;
    }
}
class Solution {
    List<Integer> list;
    HashMap<TreeNode, TreeNode> map;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        list = new ArrayList<>();
        map = new HashMap<>();
        map.put(root, null);
        getParentChildMapping(root);

        Queue<Pair> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
      
        q.add(new Pair(target, 0));
        visited.add(target);
        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode curr = p.root;
            int dist = p.dist;
            if (dist == k) list.add(curr.val);
            if (curr.left != null && !visited.contains(curr.left)) {
                visited.add(curr.left);
                q.add(new Pair(curr.left, dist + 1));
            }

            if (curr.right != null && !visited.contains(curr.right)) {
                visited.add(curr.right);
                q.add(new Pair(curr.right, dist + 1));
            }

            if (map.get(curr) != null && !visited.contains(map.get(curr))) {
                visited.add(map.get(curr));
                q.add(new Pair(map.get(curr), dist + 1));
            }
        }
        return list;
    }
    
    private void getParentChildMapping(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                map.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                map.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }
}
