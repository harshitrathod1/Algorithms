package DynamicProgramming.MCM;

import java.util.Arrays;

/*
    Problem Statement- Given a sequence of matrices, find the most efficient way to multiply these matrices together. 
    The efficient way is the one that involves the least number of multiplications. Print the minCost of multiplication.
*/

public class ParentProblem {
    
    //Recursion
    //Time Complexity - worst case - O(2^N) exponential
    int MatrixChainMultiplication(int[] mat,int i,int j){
        if(i == j) return 0;

        int minCostOfMultiplication = Integer.MAX_VALUE;
        for(int k = i;k < j;k++){
            int subAns = mat[i-1] * mat[k] * mat[j] +MatrixChainMultiplication(mat, i, k) + 
            MatrixChainMultiplication(mat, k+1, j);
            
            if(subAns < minCostOfMultiplication){
                minCostOfMultiplication = subAns;
            }
        }

        return minCostOfMultiplication;
    }

    //Memoized
    //Time Complexity - Worst case - O(n*n*k)
    //Space Complexity - O(n*n)
    int MatrixChainMultiplicationMemo(int[] mat,int i,int j,int[][] dp){
        if(i == j) return 0;

        //Overlapping Subproblems
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int minCostOfMultiplication = Integer.MAX_VALUE;
        for(int k = i;k < j;k++){
            int subAns = mat[i-1] * mat[k] * mat[j] + MatrixChainMultiplicationMemo(mat, i, k,dp) + 
            MatrixChainMultiplicationMemo(mat, k+1, j, dp);
            
            if(subAns < minCostOfMultiplication){
                minCostOfMultiplication = subAns;
            }
        }

        return minCostOfMultiplication;
    }

    //Time complexity : O(n*n*k)
    //Space complexity : O(n*n)
    int MatrixChainMultiplicationBottomUp(int[] mat){
        int n = mat.length;
        int[][] dp = new int[n][n];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));

        for(int g = 1;g < n;g++){
            for(int i = 1,j = g;j < n;i++,j++){
                if(g == 1){
                    dp[i][j] = 0;
                }else{
                    for(int k = i;k < j;k++){
                        int curCost = dp[i][k] + dp[k+1][j] + (mat[i-1] * mat[k] * mat[j]);
                        dp[i][j] = Math.min(dp[i][j],curCost);
                    }
                }
            }
        }


        return dp[1][n-1];
    }

    public static void main(String[] args) {
        ParentProblem obj = new ParentProblem();
        int[] mat = {40,20,30,10,30};
        int n = mat.length;
        int[][] dp = new int[n][n];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        System.out.println(obj.MatrixChainMultiplicationBottomUp(mat));
    }
}
