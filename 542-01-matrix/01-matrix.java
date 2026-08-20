class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    dist[i][j] = -1;
                }
            }
        }

        int[] dirR = {-1, 1, 0, 0};
        int[] dirC = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int i = 0; i < 4; i++) {
                int newR = r + dirR[i];
                int newC = c + dirC[i];
                if (newR >= 0 && newR < m && newC >= 0 && newC < n && dist[newR][newC] == -1) {
                    dist[newR][newC] = dist[r][c] + 1;
                    queue.offer(new int[]{newR, newC});
                }
            }
        }

        return dist;

    }
}