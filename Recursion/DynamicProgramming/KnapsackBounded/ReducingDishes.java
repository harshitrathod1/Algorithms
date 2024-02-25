package Recursion.DynamicProgramming.KnapsackBounded;

class Solution {
    
    //LEETCODE 1402
    /*
        Problem : 
        
        A chef has collected data on the satisfaction level of his n dishes. Chef can cook any         dish in 1 unit of time.

        Like-time coefficient of a dish is defined as the time taken to cook that dish                 including previous dishes multiplied by its satisfaction level i.e. time[i] *                   satisfaction[i].

        Return the maximum sum of like-time coefficient that the chef can obtain after dishes           preparation.

        Dishes can be prepared in any order and the chef can discard some dishes to get this           maximum value
    */
    
    //Recursion
    //Time complexity : O(2^N)
    //Space complexity : O(1) Auxiliary space.
    int getMaxCoefficient(int[] levels,int cur,int n,int dishes){
        if(cur >= n) return 0;
         
        int option1 = getMaxCoefficient(levels,cur+1,n,dishes);
        int option2 = (dishes * levels[cur]) + getMaxCoefficient(levels,cur+1,n,dishes+1);
        
        return Math.max(option1,option2);
    }
    
    //Memoization
    //Time complexity : O(n* log(n)) + O(n * n) = O(n^2);
    //Space complexity : O(n * n);
    int getMaxCoefficientDp(int[] sat,int cur,int time,int n,int[][] dp){
        if(cur >= n) return 0;
        
        if(dp[cur][time] != -1) return dp[cur][time];
        
        int option1 = getMaxCoefficientDp(sat,cur+1,time,n,dp);
        int option2 = (time * sat[cur]) + getMaxCoefficientDp(sat,cur+1,time+1,n,dp);
        
        return dp[cur][time] = Math.max(option1,option2);
    }

}

/*
    Aim : Max Cofficient
    Coefficient = timeTaken * satisfaction[i];
    timeTaken = number of Previous dishes prepared.
    
    [-1,-8,0,5,-9]
*/