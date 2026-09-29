class Solution {
    public void backtrack(
        String s,int i, List<String> cur, List<String> ans, Set<String> wordSet) {
            if(i == s.length()) {
                ans.add(String.join(" ", cur));
                return;
            }

            for(int j = i; j < s.length(); j++) {
                String w = s.substring(i, j+1);
                if(wordSet.contains(w)) {
                    cur.add(w);
                    backtrack(s, j + 1, cur, ans, wordSet);
                    cur.remove(cur.size() - 1);
                }
            }
        }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordDict);
        List<String> cur = new ArrayList<>();

        backtrack(s, 0, cur, ans, wordSet);
        return ans;
    }
}