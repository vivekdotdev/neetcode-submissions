class Solution {
    public boolean isPalindrome(String s, int start, int end) {
        while(start <= end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
    public void helper(int idx, String s, List<List<String>> res, List<String> path) {
        if(idx == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = idx; i < s.length(); i++) {
            if(isPalindrome(s, idx, i)) {
                path.add(s.substring(idx, i+1));
                helper(i+1, s, res, path);
                path.remove(path.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>(); 
        helper(0, s, res, new ArrayList<>());
        return res;
    }
}
