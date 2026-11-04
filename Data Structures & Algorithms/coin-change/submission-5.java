class Solution {
    private int[] coins;
    private int[] memo;
    private int maxValue;
    private static final int UNVISITED = -1;


    public int coinChange(int[] coins, int amount) { // Bottom-up
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            if (dp[i] == -1) {
                continue;
            }
            // System.out.println("i: " + i);
            for (int coin : coins) {
                if (coin <= amount - i) {
                    // System.out.println("Coin: " + coin);
                    dp[i + coin] = dp[i + coin] == -1 ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i + coin]);
                    // System.out.println("dp[" + (i+coin) + "]: " + dp[i + coin]);
                }
            }
            // System.out.println("+++++++++");
        }
        return dp[amount];
    }

    public int coinChangeRecDP(int[] coins, int amount) {
        this.coins = coins;
        this.memo = new int[amount+1];
        for (int i = 1; i <= amount; i++) { // memo[0] stays 0
            this.memo[i] = UNVISITED;
        }
        this.maxValue = amount + 1;
        int res = this.dp(amount);
        return res == this.maxValue ? -1 : res;
    }

    private int dp(int amount) {
        // System.out.println("Amount: " + amount);
        if (this.memo[amount] != UNVISITED) {
            return this.memo[amount];
        }
        int res = this.maxValue;
        for (int coin : this.coins) {
            // System.out.println("Coin: " + coin);
            if (coin <= amount) {
                int candidate = this.dp(amount - coin);
                res = candidate < res ? candidate : res;
                if (res == 0) {
                    break;
                }
            }
        }
        if (res != this.maxValue) {
            res += 1;
        }
        this.memo[amount] = res;
        // System.out.println("Res: " + res);
        return res;
    }
}
