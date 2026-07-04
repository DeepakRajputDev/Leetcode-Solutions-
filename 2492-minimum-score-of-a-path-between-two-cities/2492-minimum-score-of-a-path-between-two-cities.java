class Solution {
    public int minScore(int n, int[][] roads) {
        java.util.List<java.util.List<int[]>> adj = new java.util.ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new java.util.ArrayList<>());
        }
        for (int[] road : roads) {
            adj.get(road[0]).add(new int[]{road[1], road[2]});
            adj.get(road[1]).add(new int[]{road[0], road[2]});
        }
        
        int minScore = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n + 1];
        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        
        queue.add(1);
        visited[1] = true;
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int dist = edge[1];
                minScore = Math.min(minScore, dist);
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
        
        return minScore;
    }
}