class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1_000_000_007;

        int[][] maxScore = new int[n][n];
        int[][] count = new int[n][n];

        for (int[] row : maxScore) Arrays.fill(row, -1);
        
        count[n - 1][n - 1] = 1;
        maxScore[n - 1][n - 1] = 0;

        for (int r = n - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                char ch = board.get(r).charAt(c);
                if (ch == 'X' || (r == n - 1 && c == n - 1)) continue;

                int val = (ch == 'E') ? 0 : ch - '0';
                
                int[] dr = {0, 1, 1};
                int[] dc = {1, 0, 1};

                for (int i = 0; i < 3; i++) {
                    int nr = r + dr[i], nc = c + dc[i];
                    if (nr < n && nc < n && maxScore[nr][nc] != -1) {
                        int score = maxScore[nr][nc] + val;
                        if (score > maxScore[r][c]) {
                            maxScore[r][c] = score;
                            count[r][c] = count[nr][nc];
                        } else if (score == maxScore[r][c]) {
                            count[r][c] = (count[r][c] + count[nr][nc]) % MOD;
                        }
                    }
                }
            }
        }

        return maxScore[0][0] == -1 ? new int[]{0, 0} : new int[]{maxScore[0][0], count[0][0]};
    }
}