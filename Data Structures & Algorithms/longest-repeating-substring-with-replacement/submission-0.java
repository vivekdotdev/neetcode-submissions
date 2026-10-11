class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> cnt = new HashMap<>();

        int res = 0, l = 0, maxf = 0;

        for (int r = 0; r < s.length(); r++) {
            cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, cnt.get(s.charAt(r)));

            while ((r - l + 1) - maxf > k) {
                cnt.put(s.charAt(l), cnt.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
