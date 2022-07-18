public class JulyEighteen {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n-1];
    }


    /**
     * dp[i][j]
     * 增 dp[i-1][j] + 1
     * 删 dp[i][j-1] + 1
     * 改 dp[i-1][j-1] + 1
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1] [word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                int n = 1;
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    n = 0;
                }
                dp[i][j] = Math.min(dp[i-1][j-1] + n , dp[i][j]);
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
