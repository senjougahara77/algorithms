class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] cnt = new int[1000];
        for (char c : s1.toCharArray()) {
            cnt[c - '0']++;
        }
        int l = 0, r = 0;
        int len = s1.length();
        int valid = s1.length();
        while (r < s2.length()) {
            char tmp = s2.charAt(r);
            if (cnt[tmp - '0'] > 0) valid--;
            cnt[tmp - '0']--;
            while (valid == 0) {
                if (r - l + 1 == len) {
                    return true;
                }
                char tmpl = s2.charAt(l);
                if (cnt[tmpl - '0'] == 0) valid++;
                cnt[tmpl - '0']++;
                l++;
            }
            r++;
        }
        return false;
    }
}
