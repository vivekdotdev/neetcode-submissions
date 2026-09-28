class Solution {

    public int solve(int col, char[][] board, int n, int[] leftRow, int[] lowerDia, int[] upperDia
        ) {
        if (col == n) {
            return 1;
        }
        int res = 0;
        for (int row = 0; row < n; row++) {
            if (leftRow[row] == 0 && lowerDia[row + col] == 0 && upperDia[n - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDia[row + col] = 1;
                upperDia[n - 1 + col - row] = 1;

                res += solve(col + 1, board, n, leftRow, lowerDia, upperDia);

                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDia[row + col] = 0;
                upperDia[n - 1 + col - row] = 0;
            }
        }
        return res;
    }

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        int[] leftRow = new int[n];
        int[] lowerDia = new int[2 * n - 1];
        int[] upperDia = new int[2 * n - 1];

        return solve(0, board, n, leftRow, lowerDia, upperDia);
    }
}