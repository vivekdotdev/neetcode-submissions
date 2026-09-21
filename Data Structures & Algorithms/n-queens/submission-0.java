class Solution {
    public void solve(int col, char[][] board, int n, int[] leftRow, int[] lowerDia, int[] upperDia,
        List<List<String>> res) {
        if (col == n) {
            List<String> temp = new ArrayList<>();
            for (char[] c : board) {
                temp.add(new String (c));
            }
            res.add(temp);
            return;
        }
        for (int row = 0; row < n; row++) {
            if (leftRow[row] == 0 && lowerDia[row + col] == 0 && upperDia[n - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDia[row + col] = 1;
                upperDia[n - 1 + col - row] = 1;

                solve(col + 1, board, n, leftRow, lowerDia, upperDia, res);

                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDia[row + col] = 0;
                upperDia[n - 1 + col - row] = 0;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        int[] leftRow = new int[n];
        int[] lowerDia = new int[2 * n - 1];
        int[] upperDia = new int[2 * n - 1];

        solve(0, board, n, leftRow, lowerDia, upperDia, res);
        return res;
    }
}
