class Solution {
    List<List<Integer>> list;
    List<Integer> temp;
    int n;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        list = new ArrayList<>();
        temp = new ArrayList<>();
        n = candidates.length;
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return list;
    }

    public void dfs(int[] candidates, int idx, int target) {
        if (target == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }
        if (idx == n) return;
        // 选择当前的数 
        if (target >= candidates[idx]) {
            temp.add(candidates[idx]);
            dfs(candidates, idx + 1, target - candidates[idx]);
            while (idx < n - 1 && candidates[idx] == candidates[idx + 1]) idx++;
            temp.remove(temp.size() - 1);
        }

        // 不选择当前的数
        dfs(candidates, idx + 1, target);
    }
}
