package Recursion.DynamicProgramming.KnapsackBounded;
import java.util.Arrays;

class Solution3{

    //Time complexity : O(n * sum);
    //Space complexity : O(n * sum);
    public int minSubsetSumDifference(int[] arr, int n) {
		//1. Gather details
        int total = Arrays.stream(arr).sum();
        int target = total / 2;
        boolean[][] dp = new boolean[n+1][target + 1];
        //DP[index][target]
        for(int i = 0;i <= n;i++) dp[i][0] = true;
        
        //2. Check whether any subset with given sum
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= target;j++){
                if(arr[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - arr[i-1]];
                }
            }
        }
        //3. Get maximum sum closest to totalSum/2
        int minDifference = Integer.MAX_VALUE;
        for(int sum = target;sum >= 0;sum--){
            if(dp[n][sum] == true){
                minDifference = sum;
            	break;
            }
        }
        
        return Math.abs((total - minDifference)-minDifference);
	}
    
    //Time complexity : O(n * sum)
    //Space complexity : O(sum)
    int getMinDifference(int[] arr){
        if(arr.length == 0) return 0;
        int total = Arrays.stream(arr).sum();

        int target = total / 2;
        int n = arr.length;
        boolean[] prev = new boolean[target+1];
        boolean[] cur = new boolean[target+1];
        prev[0] = cur[0] = true;

        for(int idx = 1;idx <= n;idx++){
            for(int sum = 1;sum <= target;sum++){
                if(arr[idx-1] > sum){
                    //Dont include the cur element
                    cur[sum] = prev[sum];
                }else{
                    //Try include and exclude, both
                    cur[sum] = prev[sum] || prev[sum - arr[idx-1]];
                }
            }
            prev = cur;
        }

        int closeSum = 0;

        for(int k = target;k >= 0;k--){
            if(cur[k] == true){
                closeSum = k;
                break;
            }
        }

        return ((total - closeSum) - closeSum);
    }

    public static void main(String[] args) {
        Solution3 obj = new Solution3();
        int[] arr = {1,2,3,4};
        int n = arr.length;
        int ans = obj.minSubsetSumDifference(arr, n);
        System.out.println(ans);
    }
}