package dp;

public class SubsetSum {

    public static boolean isSumPossible(int s, int[] set) {
        boolean[][] dp = new boolean[set.length+1][s+1];
        dp[0][0] = false;
        for (int i = 0; i <= set.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= s; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i <=set.length; i++) {
            for (int j = 1; j <=s; j++) {
                if (j-set[i-1] >= 0) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - set[i - 1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[set.length][s];
    }

    public static void main(String[] args) {
        int set[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        int[] seta = {3, 34, 4, 12, 5, 2};
        int suma = 30;
        System.out.println(SubsetSum.isSumPossible(sum, set));
        System.out.println(SubsetSum.isSumPossible(suma, seta));
    }

}
