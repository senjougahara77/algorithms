class Solution {
    List<List<Integer>> list;
    List<Integer> temp;
    public List<List<Integer>> combinationSum3(int k, int n) {
        list = new ArrayList<>();
        temp = new ArrayList<>();
        dfs(n, k, 1, 0);
        return list;
    }
    public void dfs(int n, int k, int idx, int sum) {
        if (temp.size() == k && sum == n) {
            list.add(new ArrayList<>(temp));
            return;
        }
        if (idx == 10 || sum > n || temp.size() > k) return;
        temp.add(idx);
        dfs(n, k, idx + 1, sum + idx);
        temp.remove(temp.size() - 1);
        dfs(n, k, idx + 1, sum);
    }
}
