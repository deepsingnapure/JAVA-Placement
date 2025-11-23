class Solution {
    public int maxSumDivThree(int[] nums) {

        int[] dp = new int[3];
        dp[1] = dp[2] = Integer.MIN_VALUE; // impossible states initially

        for (int x : nums) {
            int[] temp = dp.clone();

            for (int r = 0; r < 3; r++) {
                int newR = (r + x) % 3;
                dp[newR] = Math.max(dp[newR], temp[r] + x);
            }
        }

        return dp[0];
    }
}
