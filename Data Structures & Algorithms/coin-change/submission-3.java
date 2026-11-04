class Solution {
    private int[] coins;
    private int[] memo;
    private int maxValue;
    private static final int UNVISITED = -1;
    public int coinChange(int[] coins, int amount) {
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
