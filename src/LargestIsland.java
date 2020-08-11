public class LargestIsland {
    static int count;
    static int R;
    static int C;

    private static void DFS(int[][] islands, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        int[][] dir = new int[][] {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1},
                {-1, -1},
                {-1, 1},
                {1, -1},
                {1, 1}
        };

        for (int k = 0; k < 8; k++) {
            if (isSafe(islands, i + dir[k][0], j + dir[k][1], visited)) {
                count++;
                DFS(islands, i + dir[k][0], j + dir[k][1], visited);
            }
        }
    }

    private static int findLargerIsland(int[][] islands, int R, int C) {
        boolean[][] visited = new boolean[R][C];
        int result = 0;
        LargestIsland.R = R;
        LargestIsland.C = C;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (islands[i][j] == 1 && visited[i][j] != true) {
                    count = 1;
                    DFS(islands, i, j, visited);
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }

    private static boolean isSafe(int[][] islands, int R, int C, boolean[][] visited) {
        return (R >= 0) && (C >= 0) && (R < LargestIsland.R) &&
                (C < LargestIsland.C) && visited[R][C] != true && islands[R][C] == 1;
    }

    public static void main(String[] args) {
        int[][] islands = new int[][] {
                {0, 0, 1, 1, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1}
        };
        int region = findLargerIsland(islands, islands.length, islands[0].length);
        System.out.println(region);
    }
}
