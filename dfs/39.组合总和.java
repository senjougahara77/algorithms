class Solution {
    List<List<Integer>> list;
    List<Integer> temp;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        list = new ArrayList<>();
        temp = new ArrayList<>();
        dfs(candidates, 0, target);
        return list;
    }

    public void dfs(int[] candidates, int idx, int target) {
        if (idx == candidates.length) return;
        if (target == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }
        // 不选择当前的数
        dfs(candidates, idx + 1, target);
        // 选择当前的数
        if (target >= candidates[idx]) {
            temp.add(candidates[idx]);
            dfs(candidates, idx, target - candidates[idx]);
            temp.remove(temp.size() - 1);
        }
    }
}
