class Solution {
    public int calPoints(String[] ops) {
        int res = 0;
        Stack<Integer> st = new Stack<>();
        for(String op : ops) {
            if(op.equals("+")) {
                int top = st.pop();
                int newTop = top + st.peek();
                st.push(top);
                st.push(newTop);
                res += newTop;
            } else if(op.equals("D")) {
                st.push(2* st.peek());
                res += st.peek();;
            } else if(op.equals("C")) {
                res -= st.pop();
            } else {
                st.push(Integer.parseInt(op));
                res += st.peek();
            }
        }
        return res;
    }
}