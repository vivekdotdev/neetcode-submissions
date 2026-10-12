class Solution {
    public String minWindow(String s, String t) {
        if(t.length() <= 0) return "";
        int l = 0, r = 0, cnt = 0;
        int hash[] = new int[256];
        int sIdx = -1, minLen = Integer.MAX_VALUE;

        for(char c : t.toCharArray()) {
            hash[c]++;
        }

        while(r < s.length()) {
            if(hash[s.charAt(r)] > 0) cnt++;

            hash[s.charAt(r)]--;
            while(cnt == t.length()) {
                if(minLen > r - l + 1) {
                    minLen = r - l + 1;
                    sIdx = l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)] > 0) cnt--;
                l++;
            }
            r++;
        }
        return (sIdx == -1) ? "" : s.substring(sIdx, sIdx + minLen);
    }
}
