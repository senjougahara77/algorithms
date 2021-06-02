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
class Solution {
    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int n = preorder.length;
        for (int i = 0; i < n; ++i) {
            map.put(inorder[i], i);
        }
        return recur(0, n, 0, n);
    }

    public TreeNode recur(int ps, int pe, int is, int ie) {
        if (ps == pe) return null;
        int root_val = preorder[ps];
        TreeNode root = new TreeNode(root_val);
        int root_id = map.get(root_val);
        int left_len = root_id - is;
        root.left = recur(ps + 1, ps + left_len + 1, is, root_id);
        root.right = recur(ps + left_len + 1, pe, root_id + 1, ie);
        return root;
    }
}
