class Solution {
    private final String[] map;
    public Solution() {
        map = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    }
    private void combination(int idx, String curr, String digit, List<String> ans) {
        if(idx == digit.length()) {
            ans.add(curr);
            return;
        }
        String s = map[digit.charAt(idx) - '0'];
        for(int i = 0; i < s.length(); i++) {
            combination(idx+1, curr + s.charAt(i), digit, ans);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0) return ans;
        combination(0, "", digits, ans);
        return ans;
    }
}
