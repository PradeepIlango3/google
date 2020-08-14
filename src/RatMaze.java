public class RatMaze {

    public static boolean canSolve(boolean[][] maze, int n) {
        boolean[][] solution = new boolean[n][n];
        if (!canSolveUtil(maze, n, 0, 0, solution)) {
            return false;
        }
        printSolution(solution, n);
        return true;
    }

    private static void printSolution(boolean[][] solution, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean canSolveUtil(boolean[][] maze, int n, int x, int y, boolean[][] solution) {
        if (!maze[x][y]) return false;
        if (x == n-1 && y == n-1) {
            solution[x][y] = true;
            return true;
        }
        solution[x][y] = true;
        if ((y+1 < n) && canSolveUtil(maze, n, x, y+1, solution)) {
            return true;
        }
        if ((x+1 < n) && canSolveUtil(maze, n, x+1, y, solution)) {
            return true;
        }
        solution[x][y] = false;
        return false;
    }

    public static void main(String[] args) {
        boolean[][] maze = new boolean[][] {
                {true, false, false, false},
                {true, true, false, true},
                {false, true, false, false},
                {true, true, true, true}
        };
        System.out.println(canSolve(maze, maze.length));
    }
}
