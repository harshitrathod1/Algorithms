package DynamicProgramming.KnapsackBounded;
/*
    Problem Statement- Given weights and values of n items, put these items in a 
    knapsack of capacity W to get the maximum total value in the knapsack.
*/
public class ParentProblem {

    //Recursion
    //Time complexity : O(2^N)
    //Space complexity : O(1) auxiliary space
    static int knapsackBounded(int[] weights,int[] value,int n,int cur,int bagWeight){
        if(cur >= n || bagWeight <= 0){
            return 0;
        }

        if(weights[cur] > bagWeight){
            return knapsackBounded(weights, value, n, cur+1, bagWeight);
        }

        int option1 = knapsackBounded(weights, value, n, cur+1, bagWeight);
        int option2 = value[cur] + knapsackBounded(weights, value, n, cur+1, bagWeight - weights[cur]);
        
        return Math.max(option1, option2);
    }

    //Memoized
    //Time complexity : O(n * bagWeight);
    //Space Complexity : O(n * bagWeight);
    static int knapsackBoundedMemo(int[] weights,int[] value,int cur,int bagWeight,int n,int[][] dp){
        if(cur >= n || bagWeight <= 0) return 0;
        
        if(weights[cur] > bagWeight){
            return dp[cur][bagWeight] = knapsackBounded(weights, value, n, cur+1, bagWeight);
        }

        int option1 = knapsackBounded(weights, value, n, cur+1, bagWeight);
        int option2 = value[cur] + knapsackBounded(weights, value, n, cur+1, bagWeight - weights[cur]);
        
        return dp[cur][bagWeight] =  Math.max(option1, option2);
    }

    //Tabulation
    //Time complexity : O(n * bagWeight);
    //Space Complexity : O(n * bagWeight);
    static int knapsackBoundedBottomUp(int[] weights,int[] value,int bagWeight){
        int n = value.length;
        int[][] dp = new int[n+1][bagWeight + 1];

        for(int i = 0;i <= n;i++){
            for(int w  = 0;w <= bagWeight;w++){
                if(i == 0 || w == 0){
                    dp[i][w] = 0;
                }else if(weights[i - 1] <= w){
                    int option1 = dp[i-1][w];
                    int option2 = value[i-1] + dp[i-1][w - weights[i-1]];
                    dp[i][w] = Math.max(option1,option2);
                }else{
                    dp[i][w] = dp[i-1][w];
                }

            }
        }

        return dp[n][bagWeight];
    }

    public static void main(String[] args) {
        int[] wt = {9,13,153,50,15,68,27,39,23,52,11,32,24,48,73,42,43,22,7,18,4,30};
        int[] val = {150,35,200,160,60,45,60,40,30,10,70,30,15,10,40,70,75,80,20,12,50,10};
        int w = 400;
        int ans = knapsackBoundedBottomUp(wt, val, w);
        System.out.println(ans);
    }
}
