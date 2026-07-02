import java.util.*;

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] dist = new int[m][n];
        
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        Deque<int[]> q = new ArrayDeque<>();
        dist[0][0] = grid.get(0).get(0);
        q.offer(new int[]{0, 0});
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int weight = grid.get(nr).get(nc);
                    if (dist[nr][nc] > dist[r][c] + weight) {
                        dist[nr][nc] = dist[r][c] + weight;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        
        return dist[m - 1][n - 1] < health;
    }
}