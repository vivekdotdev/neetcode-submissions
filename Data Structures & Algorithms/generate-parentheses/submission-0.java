class Solution {
    public void helper(StringBuilder sb, int open, int close, int n, List<String> res){
        if(sb.length() == (2*n)) {
            res.add(sb.toString());
            return;
        }

        if(open < n) {
            sb.append('(');
            helper(sb, open + 1, close, n, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close < open) {
            sb.append(')');
            helper(sb, open, close + 1, n, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(new StringBuilder(), 0, 0, n, res);
        return res;
    }
}
