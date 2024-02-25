package Recursion.DynamicProgramming.KnapsackUnbouded;
/*
    Problem : Given a knapsack weight W and a set of n items with certain value val(i) and weight wt(i),
    we need to calculate the maximum amount that could make up this quantity exactly. 
    This is different from classical Knapsack problem, here we are allowed 
    to use unlimited number of instances of an item.
*/
public class ParentProblem {

    //Recursion
    //Time complexity : O(2^n)
    //Space complexity : O(1) Auxiliary space
    static int KnapsackUnbouded(int[] weights,int[] value,int cur,int n,int bagWeight){
        if(cur >= n || bagWeight <= 0){
            return 0;
        }

        if(weights[cur] > bagWeight){
            return KnapsackUnbouded(weights, value, cur + 1, n, bagWeight);
        }

        int option1 = KnapsackUnbouded(weights, value, cur+1, n, bagWeight);
        int option2 = value[cur] + KnapsackUnbouded(weights, value, cur, n, bagWeight - weights[cur]);
        
        return Math.max(option1, option2);
    }

    //Memoization
    //Time complexity : O(n * w)
    //Space complexity : O(n * w)
    static int KnapsackUnboudedMemo(int[] weights,int[] value,int cur,int n,int bagWeight,int[][] dp){
        if(cur >= n || bagWeight <= 0){
            return 0;
        }

        //If subproblem has been already solved
        if(dp[cur][bagWeight] != -1){
            return dp[cur][bagWeight];
        }

        if(weights[cur] > bagWeight){
            return dp[cur][bagWeight] =  KnapsackUnboudedMemo(weights, value, cur + 1, n, bagWeight,dp);
        }

        int option1 = KnapsackUnboudedMemo(weights, value, cur+1, n, bagWeight,dp);
        int option2 = value[cur] + KnapsackUnboudedMemo(weights, value, cur, n, bagWeight - weights[cur],dp);
        
        return dp[cur][bagWeight] = Math.max(option1, option2);
    }

    //Tabulation
    //Time complexity : O(n * w)
    //Space complexity : O(n * w)
    static int KnapsackUnboudedBottomUp(int[] weights,int[] value,int bagWeight){
        int n = value.length;
        int[][] dp = new int[n+1][bagWeight + 1];

        for(int i = 0;i <= n;i++){
            for(int w  = 0;w <= bagWeight;w++){
                if(i == 0 || w == 0){
                    dp[i][w] = 0;
                }else if(weights[i - 1] <= w){
                    int option1 = dp[i-1][w];
                    int option2 = value[i-1] + dp[i][w - weights[i-1]];
                    dp[i][w] = Math.max(option1,option2);
                }else{
                    dp[i][w] = dp[i-1][w];
                }

            }
        }

        return dp[n][bagWeight];
    }

    public static void main(String[] args) {
        int[] weights = { 2,4,6 };
        int[] value = { 5,11,13 };
        int bagWeight = 10;
        int ans = KnapsackUnboudedBottomUp(weights, value, bagWeight);
        //int ans = KnapsackUnbouded(weights, value, 0, n, bagWeight);
        System.out.println(ans);    
    }
}
