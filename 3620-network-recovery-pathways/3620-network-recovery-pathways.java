import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        int maxEdge = 0;
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            maxEdge = Math.max(maxEdge, edge[2]);
        }

        int low = 0, high = maxEdge;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canReach(n, adj, online, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean canReach(int n, List<List<int[]>> adj, boolean[] online, long k, int minWeight) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.add(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int u = (int) curr[0];
            long d = curr[1];

            if (d > dist[u]) continue;
            if (u == n - 1) return d <= k;

            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int w = edge[1];
                if (online[v] && w >= minWeight) {
                    if (dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                        pq.add(new long[]{v, dist[v]});
                    }
                }
            }
        }
        return false;
    }
}