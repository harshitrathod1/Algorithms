package DynamicProgramming.KnapsackBounded;

class Solution2{
    boolean checkIfSubsetEqualToK(int[] arr,int k){
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][k+1];
        //DP[index][target]
        //If target = 0 then true for every subset.
        for(int i = 0;i <= n;i++) dp[i][0] = true;

        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= k;j++){
                if(arr[i-1] > j){
                    //Dont include the current element
                    dp[i][j] = dp[i-1][j];
                }else{
                    //Include and dont include, try both possiblities.
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - arr[i-1]];
                }
            }
        }
        return dp[n][k];
    }

    boolean checkIfSubsetEqualToK2(int[] arr,int k){
        int n = arr.length;
        boolean[] prev = new boolean[k+1];
        boolean[] cur = new boolean[k+1];
        prev[0] = cur[0] = true;

        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= k;j++){
                if(arr[i-1] > j){
                    cur[j]  = prev[j];
                }else{
                    cur[j] = prev[j] || prev[j - arr[i-1]];
                }
            }
            prev = cur;
        }

        return cur[k];
    }
}