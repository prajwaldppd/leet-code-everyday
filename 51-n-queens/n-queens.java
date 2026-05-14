import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> ans = new ArrayList<>();

        queens(board, 0, ans);

        return ans;
    }

    public void queens(boolean[][] board, int row, List<List<String>> ans) {
        if (row == board.length) {
            addAns(ans, board);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                queens(board, row + 1, ans);
                board[row][col] = false;
            }
        }
    }

    public boolean isSafe(boolean[][] board, int row, int col) {
        // Check vertical column
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // Check left diagonal
        int maxLeft = Math.min(row, col);

        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }

        // Check right diagonal
        int maxRight = Math.min(row, board.length - col - 1);

        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }

        return true;
    }

    public void addAns(List<List<String>> ans, boolean[][] board) {
        List<String> list = new ArrayList<>();

        for (int row = 0; row < board.length; row++) {
            StringBuilder sb = new StringBuilder();

            for (int col = 0; col < board.length; col++) {
                if (board[row][col]) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }

            list.add(sb.toString());
        }

        ans.add(list);
    }
}