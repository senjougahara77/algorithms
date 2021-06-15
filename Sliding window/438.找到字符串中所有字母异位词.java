class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] cnt = new int[26];
        for (char c : p.toCharArray()) {
            cnt[c - 'a']++;
        }
        int l = 0, r = 0;
        int len = p.length();
        int valid = p.length();
        while (r < s.length()) {
            char tmp = s.charAt(r);
            if (cnt[tmp - 'a'] > 0) valid--;
            cnt[tmp - 'a']--;
            while (valid == 0) {
                if (r - l + 1 == len) {
                    list.add(l);
                }
                char tmpl = s.charAt(l);
                if (cnt[tmpl - 'a'] == 0) valid++;
                cnt[tmpl - 'a']++;
                l++;
            }
            r++;
        }
        return list;
    }
}
