import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        
        int[] queens = new int[n];
        backtrack(0, n, queens, results);
        return results;
    }

    private void backtrack(int row, int n, int[] queens, List<List<String>> results) {
        if (row == n) {
            results.add(constructBoard(n, queens));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, queens)) {
                queens[row] = col;
                backtrack(row + 1, n, queens, results);
            }
        }
    }

    private boolean isValid(int row, int col, int[] queens) {
        for (int r = 0; r < row; r++) {
            int c = queens[r];
            if (c == col || Math.abs(r - row) == Math.abs(c - col)) {
                return false;
            }
        }
        return true;
    }

    private List<String> constructBoard(int n, int[] queens) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}