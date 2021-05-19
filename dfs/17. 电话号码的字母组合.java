class Solution {
    List<String> list;
    StringBuilder sb;
    String[] init = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        list = new ArrayList<String>();
        sb = new StringBuilder();
        if (digits == null || digits.length() == 0) return list;
        dfs(digits, 0);
        return list;
    }
    public void dfs(String digits, int idx) {
        if (idx == digits.length()) {
            list.add(sb.toString());
            //sb = new StringBuilder();
            return;
        }
        String s = init[digits.charAt(idx) - '2'];
        for (char c : s.toCharArray()) {
            sb.append(c);
            dfs(digits, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
