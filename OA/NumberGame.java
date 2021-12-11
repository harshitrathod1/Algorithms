package OA;

public class NumberGame {

    /*
        Time -> O(2^N * N^2 * Log(MAX_INT))
        Space -> O(2^N * N)
    */

    private int getGcd(int a,int b){ return b == 0 ? a : getGcd(b,a % b);}

    public int maxScore(int[] nums){
        int[][] dp = new int[nums.length / 2 + 1][1 << nums.length];
        return helper(nums,1,0,dp);
    }

    private int helper(int[] nums, int step,int mask, int[][] dp) {

        if(step > nums.length / 2) return 0;

        if(dp[step][mask] != 0) return dp[step][mask];

        for(int i = 0;i < nums.length;i++){
            for(int j = i+1;j < nums.length;j++){
                int new_mask = (1 << i) + (1 << j);
                if((mask & new_mask) == 0){
                    int currentGcd = step * getGcd(nums[i],nums[j]);
                    dp[step][mask] = Math.max(dp[step][mask],currentGcd +
                            helper(nums,step+1,mask+new_mask,dp));
                }
            }
        }

        return dp[step][mask];
    }

    public static void main(String[] args) {
        NumberGame ng = new NumberGame();
        int[] nums = new int[]{1,2,3,4,5,6};
        int ans = ng.maxScore(nums);
        System.out.println(ans);
    }
}
