class Solution {
    String res;
    public String minWindow(String s, String t) {
        int[] cnt = new int[1000];
        for (char c : t.toCharArray()) {
            cnt[c - '0']++;
        }
        int l = 0, r = 0;
        int len = Integer.MAX_VALUE;
        int valid = t.length();
        while (r < s.length()) {
            char tmp = s.charAt(r);
            if (cnt[tmp - '0'] > 0) valid--;
            cnt[tmp - '0']--;
            while (valid == 0) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    res = s.substring(l, r + 1);
                }
                char tmpl = s.charAt(l);
                if (cnt[tmpl - '0'] == 0) valid++;
                cnt[tmpl - '0']++;
                l++;
            }
            r++;
        }
        return len == Integer.MAX_VALUE ? "" : res;
    }
}
