class Solution {
    List<List<Integer>> list;
    List<Integer> temp;
    int n;
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        list = new ArrayList<>();
        temp = new ArrayList<>();
        dfs(nums, 0);
        return list;
    }

    public void dfs(int[] nums, int idx) {
        if (idx == n) {
            list.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        dfs(nums, idx + 1);
        temp.remove(temp.size() - 1);
        dfs(nums, idx + 1);
    }
}
