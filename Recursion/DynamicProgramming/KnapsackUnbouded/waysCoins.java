package Recursion.DynamicProgramming.KnapsackUnbouded;
/*
    Problem : Return the number of combinations that make up that amount. 
    If that amount of money cannot be made up by any combination of the coins, return 0.
    You may assume that you have an infinite number of each kind of coin.

    Ex : coins = [1,2,5] , amount = 5 , totalWays = 4;
    5=5
    5=2+2+1
    5=2+1+1+1
    5=1+1+1+1+1
*/
public class waysCoins {
    int[][] dp;
    //Memoization
    int waysOfAmount(int[] arr,int amt,int cur){
        if(amt <= 0 || cur >= arr.length){
            return amt == 0 ? 1 : 0;
        }
        
        if(dp[cur][amt] != -1) return dp[cur][amt];
        
        if(arr[cur] > amt) return dp[cur][amt] = waysOfAmount(arr,amt,cur + 1);
        
        int option1 = waysOfAmount(arr,amt,cur+1);
        int option2 = waysOfAmount(arr,amt - arr[cur],cur);
        
        return dp[cur][amt] =  option1 + option2;
    }
    //Tabulation
    int waysOfAmountDp(int[] arr,int amt){
        int n = arr.length;
        
        for(int i = 0;i <= n;i++) dp[i][0] = 1;
        
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= amt;j++){
                if(arr[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - arr[i-1]];
                }
            }
        }
        return dp[n][amt];
    }
}
