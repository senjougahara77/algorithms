/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// Recursion
class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 0);
        return list;
    }

    public void dfs(TreeNode root, int d) {
        if (root == null) return;
        if (d == list.size()) {
            list.add(new ArrayList<Integer>());
        }
        list.get(d).add(root.val);
        dfs(root.left, d + 1);
        dfs(root.right, d + 1);
    }
}
// Iteration
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        if (root == null) return list;
        dq.add(root);
        while (!dq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = dq.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = dq.pollLast();
                temp.add(node.val);
                if (node.left != null) dq.addFirst(node.left);
                if (node.right != null) dq.addFirst(node.right);
            }
            list.add(temp);
        }
        return list;
    }
}
