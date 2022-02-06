package DynamicProgramming.KnapsackBounded;

public class CountOfAllSubset {
    int total;
    int countSubsetBottomUp(int[] arr,int n,int sum){
        int[][] dp = new int[n][sum + 1];

        for(int i = 0;i <= n;i++) dp[i][0] = 1;

        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= sum;j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][sum];
    }
}
