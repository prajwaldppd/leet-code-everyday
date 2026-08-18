class Solution {
    public ArrayList<Integer> shortestPath(int V, int[][] edges, int src, int dest) {
        // 1. Build the adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        // 2. Initialize distances from 'dest'
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[dest] = 0;

        // Priority Queue stores {distance, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0, dest});

        // 3. Run Dijkstra from the destination node
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];

            // Optimization: skip if we've found a shorter path already
            if (d > dist[u]) continue;

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int w = neighbor[1];

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new int[]{dist[v], v});
                }
            }
        }

        ArrayList<Integer> path = new ArrayList<>();

        // If the source is unreachable from the destination
        if (dist[src] == Integer.MAX_VALUE) {
            path.add(-1);
            return path;
        }

        // 4. Reconstruct the lexicographically smallest path from 'src'
        int curr = src;
        path.add(src);

        while (curr != dest) {
            int nextNode = -1;

            for (int[] neighbor : adj.get(curr)) {
                int v = neighbor[0];
                int w = neighbor[1];

                // Check if taking this edge keeps us strictly on a shortest path
                if (dist[v] != Integer.MAX_VALUE && dist[v] + w == dist[curr]) {
                    // Greedily pick the neighbor with the smallest node ID
                    if (nextNode == -1 || v < nextNode) {
                        nextNode = v;
                    }
                }
            }

            path.add(nextNode);
            curr = nextNode;
        }

        return path;
    }
}