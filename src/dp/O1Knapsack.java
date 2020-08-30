package dp;

public class O1Knapsack {

    public static int rob(int W, int[] val, int[] wt) {
        int n = val.length;
        int dp[][] = new int[W+1][n+1];
        for (int i = 0; i <= W; i++) {
            for (int j = 0; j <=n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (wt[j-1] <= i) {
                        dp[i][j] = Math.max(dp[i][j-1], dp[i-wt[j-1]][j-1] + val[j-1]);
                    } else {
                        dp[i][j] = dp[i][j-1];
                    }
                }
            }
        }
        return dp[W][n];
    }

    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        System.out.println(O1Knapsack.rob(W, val, wt));
    }
}
