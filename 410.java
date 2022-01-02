class Solution {
    
    public static final long INF = 9999999999l;
    
    public int splitArray(int[] nums, int m) {
        
        long dp[][] = new long[1005][55];
        init(dp);
        return new Long(func(nums, 0, 0, m, dp)).intValue();
        
    }
    
    private long func(int[] nums, int ind, int arrNum, int maxArr, long dp[][]) {
        if (ind == nums.length && arrNum == maxArr) { 
            return 0;
        }
        if (ind == nums.length) {
            return INF;
        }
        if (arrNum >= maxArr) {
            return INF;
        }
        if (dp[ind][arrNum] != -1) {
            return dp[ind][arrNum];
        }
        long ans = Math.max(nums[ind], func(nums, ind + 1, arrNum + 1, maxArr, dp));
        long sum = nums[ind];
        for (int i = ind + 1; i < nums.length; i++) {
            sum = sum + nums[i];
            ans = Math.min(ans, Math.max(sum, func(nums, i + 1, arrNum + 1, maxArr, dp)));
        }
        return dp[ind][arrNum] = ans;
    }
    
    private void init(long dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
    }
}
