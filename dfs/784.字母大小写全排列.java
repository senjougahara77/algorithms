class Solution {
    List<String> list;
    StringBuilder sb;
    public List<String> letterCasePermutation(String s) {
        list = new ArrayList<>();
        sb = new StringBuilder();
        dfs(s, 0);
        return list;
    }

    public void dfs(String s, int idx) {
        if (idx == s.length()) {
            list.add(sb.toString());
            return;
        }
        char c = s.charAt(idx);
        if (Character.isLetter(c)) {
            // 选当前字母的小写
            sb.append(Character.toLowerCase(c));
            dfs(s, idx + 1);
            sb.deleteCharAt(idx);
            // 选当前字母的大写
            sb.append(Character.toUpperCase(c));
            dfs(s, idx + 1);
            sb.deleteCharAt(idx);
        } else {
            // 当前数字直接加入然后进入下一层
            sb.append(c);
            dfs(s, idx + 1);
            sb.deleteCharAt(idx);
        }
    }
}
