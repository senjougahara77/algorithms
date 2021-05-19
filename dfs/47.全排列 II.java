class Solution {
    List<List<Integer>> list;
    int[] visited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        list = new ArrayList<>();
        visited = new int[nums.length];
        Arrays.sort(nums);
        dfs(nums, new ArrayList<Integer>());
        return list;
    }

    public void dfs(int[] nums, List<Integer> temp) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (visited[i] == 1) continue;
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) continue;
            temp.add(nums[i]);
            visited[i] = 1;
            dfs(nums, temp);
            visited[i] = 0;
            temp.remove(temp.size() - 1);
        }
    }
}
