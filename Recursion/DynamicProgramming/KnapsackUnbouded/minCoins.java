package Recursion.DynamicProgramming.KnapsackUnbouded;
/*
    Problem : Return the fewest number of coins that you need to make up that amount. 
    If that amount of money cannot be made up by any combination of the coins, return -1.
    You may assume that you have an infinite number of each kind of coin.

    Ex : arr = [1,2,5] , amt = 11, ways = 3;
*/
import java.util.*;

public class minCoins { 
    public static final int MAX = Integer.MAX_VALUE;
    
    int[][] dp = new int[12+1][10000 + 1];
    
    //Memoized
    int minCoinsMemo(int[] arr,int amt,int cur){
        if(cur >= arr.length || amt <= 0){
            return amt == 0 ? 0 : MAX - 1;
        }
        
        if(dp[cur][amt] != -1) return dp[cur][amt];
        
        if(arr[cur] > amt) return dp[cur][amt] = minCoinsMemo(arr,amt,cur+1);
        
        int option1 = minCoinsMemo(arr,amt,cur+1);
        int option2 = 1 + minCoinsMemo(arr,amt - arr[cur],cur);
        
        return dp[cur][amt] = Math.min(option1,option2);
    }

    //Tablulation
    int minCoinsBottomUp(int[] arr,int amt){
        int n = arr.length;
        int[][] dp = new int[n+1][amt+1];
        
        Arrays.stream(dp).forEach(row -> Arrays.fill(row,MAX - 1));
        
        for(int i = 0;i <= n;i++) dp[i][0] = 0;
        
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= amt;j++){
                if(arr[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    int option1 = dp[i-1][j];
                    int option2 = 1 + dp[i][j - arr[i - 1]];
                    
                    dp[i][j] = Math.min(option1,option2);
                }
            }
        }
        return dp[n][amt];
    }

    //Space Optimized
    int minCoinsBottomUpSpaceOptimized(int[] arr,int amt){
        int n = arr.length;

        int[] prev = new int[amt + 1];
        int[] cur = new int[amt + 1];
        
        Arrays.fill(prev,MAX - 1);
        Arrays.fill(cur,MAX - 1);
        
        prev[0] = cur[0] = 0;
        
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= amt;j++){
                if(arr[i-1] > j){
                    cur[j] = prev[j];
                }else{
                    int option1 = prev[j];
                    int option2 = 1 + cur[j - arr[i - 1]];
                    
                    cur[j] = Math.min(option1,option2);
                }
            }
            prev = cur;
        }
        
        return cur[amt];
    }
}
