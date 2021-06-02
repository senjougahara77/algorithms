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
// Iteration
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return recur(root.left, root.right);
    }

    public boolean recur(TreeNode p, TreeNode q) {
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offer(p);
        dq.offer(q);
        while (!dq.isEmpty()) {
            p = dq.poll();
            q = dq.poll();
            if (p == null && q == null) continue;
            if ((p == null || q == null) || (p.val != q.val)) return false;
            dq.offer(p.left);
            dq.offer(q.right);
            dq.offer(p.right);
            dq.offer(q.left);
        }
        return true;
    }
}

// Recursion
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return recur(root.left, root.right);
    }

    public boolean recur(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && recur(p.left, q.right) && recur(p.right, q.left);
    }
}
