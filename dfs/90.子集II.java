class Solution {
    List<List<Integer>> list;
    List<Integer> temp;
    int n;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        n = nums.length;
        list = new ArrayList<>();
        temp = new ArrayList<>();
        Arrays.sort(nums);
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

        while (idx < n - 1 && nums[idx] == nums[idx + 1]) idx++;
        temp.remove(temp.size() - 1);
        dfs(nums, idx + 1);
    }
}
