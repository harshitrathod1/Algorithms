package DynamicProgramming.KnapsackUnbouded;
import java.util.*;

class Solution {
    int[][] dp;
    
    int getMaxProduct(int n,int cur,int curSum){
        if(cur >= n || curSum <= 0){
            return curSum == 0 ? 1 : 0;
        }
            
        if(dp[cur][curSum] != -1) return dp[cur][curSum];
        
        int option1 = getMaxProduct(n,cur + 1,curSum);
        int option2 = cur * getMaxProduct(n,cur,curSum-cur);
        
        return dp[cur][curSum] = Math.max(option1,option2);
    }
    
    public int integerBreak(int n) {
        dp = new int[n+1][n+1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row,-1));
        return getMaxProduct(n,1,n);
    }
}