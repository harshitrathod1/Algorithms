package DynamicProgramming.KnapsackBounded;

import java.util.Arrays;

public class targetSum {
    //Time complexity : O(total * n)
    //space complexity : O(total * n)
    int total;
    int findWays(int[] nums,int target,int cur,int curSum,int[][] dp){
        if(cur == nums.length){
            return target == curSum ? 1 : 0;
        }
        
        if(dp[cur][curSum + total] != -1){
            return dp[cur][curSum + total];
        }
        
        return dp[cur][curSum + total] = findWays(nums,target,cur+1,curSum - nums[cur],dp) +
            findWays(nums,target,cur+1,curSum + nums[cur],dp); 
    }



    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        total = Arrays.stream(nums).sum();
        int[][] dp = new int[n][2 * total + 1];
        
        Arrays.stream(dp).forEach(row -> Arrays.fill(row,-1));
             
        return findWays(nums,target,0,0,dp);   
    }
}
