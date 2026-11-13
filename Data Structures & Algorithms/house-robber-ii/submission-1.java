class Solution {
    private static final int[] STARTS = new int[]{0, 1, 2};
    public int rob(int[] nums) {
        int len = nums.length;
        if (len <= 3) {
            int res = Integer.MIN_VALUE;
            for (int n : nums) {
                res = res < n ? n : res;
            }
            return res;
        } else if (len == 4) {
            return Math.max(nums[0] + nums[2], nums[1] + nums[3]);
        }
        int[][] dp = new int[len][3];
        dp[len-1][0] = 0;
        dp[len-1][1] = nums[len-1];
        dp[len-1][2] = nums[len-1];
        dp[len-2][0] = nums[len-2];
        dp[len-2][1] = nums[len-2];
        dp[len-2][2] = len - 2 > 3 ? nums[len-2] : 0;
        dp[len-3][0] = nums[len-3];
        dp[len-3][1] = len - 3 > 2 ? nums[len-3] + nums[len-1] : 0;
        dp[len-3][2] = len - 3 > 3 ? nums[len-3] + nums[len-1] : 0;

        int res = Integer.MIN_VALUE;
        
        for (int start : Solution.STARTS) {
            // System.out.print(start + ": ");
            for (int i = len - 1; i >= start; i--) {
                if (i <= len - 4) {
                    dp[i][start] = nums[i] + Math.max(dp[i+2][start], dp[i+3][start]);
                }
                // System.out.print(dp[i][start] + " ");
            }
            // System.out.println();
            res = res < dp[start][start] ? dp[start][start] : res;
        }

        return res;                
    }
}
