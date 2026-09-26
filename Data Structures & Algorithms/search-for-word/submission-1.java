class Solution {
    public boolean findWord(char[][] board, String word, int i, int j, int n, int m, int k) {
        if (k >= word.length())
            return true;
        if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] == '.' || board[i][j] != word.charAt(k))
            return false;
        if (word.length() == 1 & board[i][j] == word.charAt(k))
            return true;
        board[i][j] = '.';
        boolean temp = false;
        int[] x = {0, 0, -1, 1};
        int[] y = {-1, 1, 0, 0};

        for (int idx = 0; idx < 4; idx++) {
            temp = temp || findWord(board, word, i + x[idx], j + y[idx], n, m, k + 1);
        }
        board[i][j] = word.charAt(k);
        return temp;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        if (n == 0)
            return false;
        int m = board[0].length;

        if (word.length() == 0)
            return false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (findWord(board, word, i, j, n, m, 0))
                        return true;
                }
            }
        }
        return false;
    }
}
