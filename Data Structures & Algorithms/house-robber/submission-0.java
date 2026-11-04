class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len]; // what's the max amount that can be stolen if I choose i-th house (and its successors)
        Arrays.fill(dp, -1);
        dp[len-1] = nums[len-1];
        dp[len-2] = nums[len-2];

        for (int i = len - 1; i >= 0; i--) {
            if (i >= 3) {
                dp[i-3] = nums[i-3] + dp[i];
            }
            if (i >= 2) {
                dp[i-2] = Math.max(dp[i-2], nums[i-2] + dp[i]);
            }
        }

        return Math.max(dp[0], dp[1]);
    }
}

