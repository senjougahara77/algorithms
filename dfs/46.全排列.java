class Solution {
    List<List<Integer>> list;
    int[] visited;
    public List<List<Integer>> permute(int[] nums) {
        list = new ArrayList<>();
        visited = new int[nums.length];
        dfs(nums, new ArrayList<>());
        return list;
    }
    public void dfs(int[] nums, List<Integer> temp) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (visited[i] == 1) continue;
            temp.add(nums[i]);
            visited[i] = 1;
            dfs(nums, temp);
            visited[i] = 0;
            temp.remove(temp.size() - 1);
        }
    }
}
