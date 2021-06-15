class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int res = 0;
        while (r < s.length()) {
            char tmp = s.charAt(r);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            while (map.get(tmp) > 1) {
                char tmpl = s.charAt(l);
                l++;
                map.put(tmpl, map.get(tmpl) - 1);
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}
