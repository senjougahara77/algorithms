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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<int[]> cnt = new ArrayList<>();
        dfs(root, 0, 0, cnt);
        Collections.sort(cnt, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            } else if (a[2] != b[2]) {
                return a[2] - b[2];
            }
            return a[0] - b[0];
        });
        if (cnt.size() == 0) return list;
        list.add(new ArrayList<>());
        int prev = cnt.get(0)[1];
        for (int[] node : cnt) {
            if (prev != node[1]) {
                prev = node[1];
                list.add(new ArrayList<>());
            }
            int t = list.size() - 1;
            list.get(t).add(node[0]);
        }
        return list;
    }

    public void dfs(TreeNode root, int x, int y, List<int[]> cnt) {
        if (root == null) return;
        dfs(root.left, x - 1, y + 1, cnt);
        dfs(root.right, x + 1, y + 1, cnt);
        cnt.add(new int[]{root.val, x, y});
    }
}
